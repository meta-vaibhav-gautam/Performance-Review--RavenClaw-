import { Component, OnInit } from '@angular/core';
import { RatingService } from '../../../../shared/services/rating.service';
import { Rating } from '../../../../shared/models/rating';
import { UserService } from '../../../../shared/services/user.service';
import { Member } from '../../../../shared/models/member';


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
