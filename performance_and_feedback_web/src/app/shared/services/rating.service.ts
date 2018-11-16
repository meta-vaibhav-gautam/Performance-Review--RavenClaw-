import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Rating } from '../models/rating';
import { Ratings } from '../../../assets/rating-list';
@Injectable({
  providedIn: 'root'
})
export class RatingService {
  getRating(): Observable<Rating[]> {
    return of(Ratings);
  }
  constructor() { }
}
