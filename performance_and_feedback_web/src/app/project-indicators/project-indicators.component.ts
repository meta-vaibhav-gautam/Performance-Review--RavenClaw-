import { Component, OnInit } from '@angular/core';
import { RatingService } from '../rating.service';
import { Rating } from '../rating';
import { UserService } from '../user.service';
import { Member } from '../member';


@Component({
  selector: 'app-project-indicators',
  templateUrl: './project-indicators.component.html',
  styleUrls: ['./project-indicators.component.css']
})
export class ProjectIndicatorsComponent implements OnInit {

  constructor(private ratingService: RatingService, private userService: UserService) { }
  user: Member;
  ratingList: Rating[];

  ngOnInit() {
    this.getRatings();
  }

  getRatings(): void{
    this.ratingService.getRating().subscribe(ratings => this.ratingList = ratings);
    this.user = this.userService.initializeUser();
  }

}
