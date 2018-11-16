import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../../shared/services/user.service';
import { Member } from '../../../../shared/models/member';
import {Rating} from '../../../../shared/models/rating';
import {Ratings} from '../../../../../assets/rating-list';
import {RatingService} from '../../../../shared/services/rating.service';
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
