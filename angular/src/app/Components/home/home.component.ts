import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup,FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  topics: any;
  id: any;
  question = '';
  choosenTopic :any;
  questionList: any;
  showAllQuestion = true;
  choosenQuestion : any;
  dropdownTopic: FormGroup;
  dropdownQuestion: FormGroup;


  constructor(
    private http: HttpClient,
    private route: Router,
    public fb: FormBuilder
  ) {
    this.dropdownTopic = new FormGroup({
      topicIndex: new FormControl(null)

    });

    this.dropdownQuestion = new FormGroup({
      questionIndex: new FormControl(null)
    });
    this.dropdownTopic.controls.topicIndex.setValue("Topic",{onlySelf:true});
    this.dropdownQuestion.controls.questionIndex.setValue("All",{onlySelf:true});
   }




  ngOnInit(): void {
    this.id = localStorage.getItem('id');
    this.http.get('http://localhost:8080/topic/subscribe/get/' + this.id).subscribe(data => {
      this.topics = data;
    });
    this.http.get('http://localhost:8080/question/all/' + this.id).subscribe(data => {
      this.questionList = data;

    });
  }

  questionNavigate(): void{
    this.route.navigateByUrl('/home/questions/insert');
  }


  search(): void{
    this.choosenTopic=this.dropdownTopic.value.topicIndex;
    this.choosenQuestion=this.dropdownQuestion.value.questionIndex;
    if (this.question === ''){
      this.addFilter(this.choosenQuestion,this.choosenTopic);
    }

    if (this.choosenTopic === "Topic"){
      alert('Selct a topic');
    }
    if (this.question !== '' && this.choosenTopic !== "Topic"){
      this.http.get(`http://localhost:8080/search/${this.question}/${this.choosenTopic.id}`).subscribe(data => {
      this.questionList = data;

      if (this.questionList.length === 0){
        this.showAllQuestion = true;
        alert('No such type question available');
        this.reset();

      }
      });
    }

  }

  changeScreen(value: any): void{
    console.log(value);
    localStorage.setItem('ques', JSON.stringify(value));
    this.route.navigate(['/home/questions/answer/']);
  }

  addFilter(choosenQuestion,choosenTopic): void{
    if(this.choosenQuestion==='me' && this.choosenTopic!=="Topic"){
        console.log("Question asked by user for that particular topic");
        this.http.get('http://localhost:8080/question/user/' + this.id+'/'+this.choosenTopic.id).subscribe(data => {
      this.questionList = data;

    });
    }
    else if (this.choosenQuestion==='All' && this.choosenTopic!=="Topic"){
      console.log("All question according to topicid");
      this.http.get('http://localhost:8080//question/topic/' + this.choosenTopic.id).subscribe(data => {
      this.questionList = data;

    });
    }

    else if(this.choosenQuestion==="All" && this.choosenTopic==="Topic"){
      console.log("All question");
      this.http.get('http://localhost:8080/question/all/' + this.id).subscribe(data => {
      this.questionList = data;

    });
    }

    else if (this.choosenQuestion==="me" && this.choosenTopic==="Topic"){
      console.log("All me question");
      this.http.get('http://localhost:8080/question/user/' + this.id).subscribe(data => {
      this.questionList = data;

    });
    }
  }

  // addFilter(): void{

  //   console.log(this.dropdownTopic.value);
  //   console.log(this.dropdownQuestion.value);
  // }

  reset(): void{
    this.dropdownTopic.controls.topicIndex.setValue("Topic",{onlySelf:true});
    this.dropdownTopic.controls.topicIndex.setValue('Topic');
    this.dropdownQuestion.controls.questionIndex.setValue("All",{onlySelf:true});
    this.dropdownQuestion.controls.questionIndex.setValue('All');
    this.question = '';
    this.http.get('http://localhost:8080/question/all/' + this.id).subscribe(data => {
      this.questionList = data;

    });
  }

}
