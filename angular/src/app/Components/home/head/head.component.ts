import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/data.service';

@Component({
  selector: 'app-head',
  templateUrl: './head.component.html',
  styleUrls: ['./head.component.css']
})
export class HeadComponent implements OnInit {
  Searchbar=false;

  constructor(private ds:DataService) { }

  ngOnInit(): void {
  }

  onclick1(){
    this.Searchbar=!this.Searchbar;
  }
}
