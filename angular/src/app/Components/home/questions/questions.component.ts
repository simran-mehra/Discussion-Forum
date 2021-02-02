import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { NavigationExtras, Router } from '@angular/router';
@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  topics: any;
  quesList: any;
  topicHeading = 'All Question';
  id: any;
  question: any;
  constructor(
    private http: HttpClient,
    private route: Router
  ) { }

  ngOnInit(): void {
    this.id = localStorage.getItem('id');
    this.http.get('http://localhost:8080/question/all/' + this.id).subscribe(data => {
      this.question = data;

    });

    this.http.get('http://localhost:8080/topic/subscribe/get/' + this.id).subscribe(data => {
      this.topics = data;
    });
  }

  getTopic(index: any ): void{
    if (index === -1){
      this.topicHeading = 'All Question';
      this.http.get('http://localhost:8080/question/all/' + this.id).subscribe(data => {

        this.question = data;

      });
    }
    else{

    this.topicHeading = this.topics[index].topicname;
    const id = this.topics[index].id;
    this.http.get('http://localhost:8080/question/topic/' + id).subscribe(data => {

      this.question = data;

    });

  }
}

changeScreen(value: any): void{
  localStorage.setItem('ques', JSON.stringify(value));
  this.route.navigate(['/home/questions/answer']);
}

}
