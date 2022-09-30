import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MoviedetailsService {
  favdata:any
  data:any;
  constructor() { 
    console.log("this is movie  movie details"+this.data)
  }
}
