import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Rating } from './rating';
import { Ratings } from './rating-list';
@Injectable({
  providedIn: 'root'
})
export class RatingService {
  getRating(): Observable<Rating[]> {
    return of(Ratings);
  }
  constructor() { }
}
