import { Component, OnInit } from '@angular/core';
import {DataService } from "../../data.service";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  option=["angular","njdsaf","dsab","dsfhbajs","asdhjh"];
  topicHeading='Select Topic';

  getTopic(i: string ): void{
    console.log(i);
    this.topicHeading=i;

  }
  constructor(
    private service: DataService
  ) { }

  ngOnInit(): void {
    console.log(this.service.userId);
  }

}
