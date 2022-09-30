import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/service/crud.service';
import { MoviedetailsService } from 'src/service/moviedetails.service';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {
 
  constructor(private favdata:CrudService ,private moviedetails:MoviedetailsService) { }
favmovie:any
  ngOnInit() {
  this.favdata.getdatatofav().subscribe(c=>{
   console.log(c.movie.movieName+"this is favourite")
    this.favmovie=c.movie
  })
  }
  carddata(value:any){
    this.moviedetails.data=value;
  }

}
