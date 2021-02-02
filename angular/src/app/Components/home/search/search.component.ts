import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {


  topics: any;
  id: any;

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

}
