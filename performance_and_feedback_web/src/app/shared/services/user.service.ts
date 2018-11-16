import { Injectable } from '@angular/core';
import {Member} from '../../shared/models/member';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  initializeUser(): Member {
    return new Member(1, 'somi@gmail.com', new Date(2013, 9, 22), "Somi Vishnoi", 2, 3, 5, 0);
  }
  
}
