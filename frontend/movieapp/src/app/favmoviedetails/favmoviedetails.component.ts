import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CrudService } from 'src/service/crud.service';
import { MoviedetailsService } from 'src/service/moviedetails.service';

@Component({
  selector: 'app-favmoviedetails',
  templateUrl: './favmoviedetails.component.html',
  styleUrls: ['./favmoviedetails.component.css']
})
export class FavmoviedetailsComponent implements OnInit {
datastorage:any
  constructor(private moviedetails:MoviedetailsService , private crud:CrudService ,private _snackBar: MatSnackBar) { }

  ngOnInit() {
    this.datastorage= this.moviedetails.data
    console.log("this is movie detail"+this.moviedetails.data)
  
  }
  remove(data:any){
   
    this.crud.removefav(this.datastorage.movieName).subscribe(c=>{
      console.log(data.movieName)
      this._snackBar.open('deleted successfully', 'ok',{
        duration:1000
      });
    })

    

  }

}
