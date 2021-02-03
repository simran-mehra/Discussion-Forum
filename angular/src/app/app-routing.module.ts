import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { TopicComponent } from './Components/home/topic/topic.component';
import { LoginComponent } from './Components/login/login.component';
import { RegisterComponent } from './Components/register/register.component';
import { QuestionsComponent } from './Components/home/questions/questions.component';
import { SearchComponent } from './Components/home/search/search.component';
import {InsertComponent} from './Components/home/insert/insert.component';
import { AnswerComponent } from './Components/home/answer/answer.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'home/topic', component: TopicComponent},
  {path: 'home/questions', component: QuestionsComponent},
  {path: 'home/search', component: SearchComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home/questions/insert', component: InsertComponent},
  {path: 'home/questions/answer', component: AnswerComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginComponent, RegisterComponent, HomeComponent, TopicComponent,
  QuestionsComponent, SearchComponent];
