import { Component, OnInit } from '@angular/core';
import {Member} from '../../member';
import {UserService} from '../../user.service';
import {Rating} from '../rating';
import {Ratings} from '../rating-list';
import {RatingService} from '../rating.service';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-self-development',
  templateUrl: './self-development.component.html',
  styleUrls: ['./self-development.component.css']
})
export class SelfDevelopmentComponent implements OnInit {
  user: Member;
  ratings: Observable<Rating[]>;
  
  constructor(public userService: UserService, public ratingService: RatingService) {}

  ngOnInit() {
    this.user = this.userService.initializeUser();
    this.ratings = this.ratingService.getRating();
  }
}
