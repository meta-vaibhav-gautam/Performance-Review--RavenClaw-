import { Component, OnInit } from '@angular/core';
import {RatingService} from '../../../../shared/services/rating.service';
import {Rating} from '../../../../shared/models/rating';
@Component({
  selector: 'app-organisational',
  templateUrl: './organisational.component.html',
  styleUrls: ['./organisational.component.css']
})
export class OrganisationalComponent implements OnInit {
  ratingList: Rating[];
  constructor(private ratingService: RatingService) { }

  ngOnInit() {
    this.getRatings();
  }

  getRatings(): void{
    this.ratingService.getRating().subscribe(ratings => this.ratingList = ratings);
  }
}
