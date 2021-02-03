import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css']
})
export class AnswerComponent implements OnInit {

  ques: any;
  answer: any;
  userId: any;
  rating: any;

  constructor(
    private router: Router,
    private http: HttpClient
    )
  {
}

  ngOnInit(): void {
    // this.userId = localStorage.getItem('id');
    // this.ques = JSON.parse(localStorage.getItem('ques'));
    // this.http.get('http://localhost:8080/question/answer/' + this.ques.id).subscribe(data => {
    //   this.answer = data;
    // });
  }

  saveRating(): void{
    console.log(this.rating);
  }

}
