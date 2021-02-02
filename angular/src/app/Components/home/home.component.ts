import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  topics: any;
  id: any;
  question = '';
  choosenTopic: any;
  questionList: any;
  showAllQuestion = true;



  constructor(
    private http: HttpClient,
    private route: Router
  ) { }

  ngOnInit(): void {
    this.id = localStorage.getItem('id');
    this.http.get('http://localhost:8080/topic/subscribe/get/' + this.id).subscribe(data => {
      this.topics = data;
    });
  }

  questionNavigate(): void{
    this.route.navigateByUrl('/home/questions/insert');
  }

  search(): void{

    if (this.question === ''){
      alert('Enter the question');
    }

    if (this.choosenTopic === undefined){
      alert('Selct a topic');
    }
    if (this.question !== '' && this.choosenTopic !== undefined){
      this.http.get(`http://localhost:8080/search/${this.question}/${this.choosenTopic.id}`).subscribe(data => {
      this.questionList = data;

      if (this.questionList.length === 0){
        this.showAllQuestion = true;
        alert('No such type question available');

      }
      else{
        this.showAllQuestion = false;
      }
      });
    }

  }

  changeScreen(value: any): void{
    localStorage.setItem('ques', value);
    this.route.navigate(['/home/questions/answer/']);
  }

}
