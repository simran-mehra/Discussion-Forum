import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HeadComponent } from './Components/home/head/head.component';
import { InsertComponent } from './Components/home/insert/insert.component';
import { AnswerComponent } from './Components/home/answer/answer.component';

@NgModule({
  declarations: [
    AppComponent ,
    routingComponents,
    HeadComponent,
    InsertComponent,
    AnswerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
