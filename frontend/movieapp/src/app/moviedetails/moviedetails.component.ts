import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { filter, map, Observable } from 'rxjs';
import { CrudService } from 'src/service/crud.service';
import { MoviedetailsService } from 'src/service/moviedetails.service';
import { Commentdata } from '../class/commentdata';
import { Favourite } from '../class/favourite';

@Component({
  selector: 'app-moviedetails',
  templateUrl: './moviedetails.component.html',
  styleUrls: ['./moviedetails.component.css']
})
export class MoviedetailsComponent implements OnInit {
 

  constructor(private movie:MoviedetailsService, private fav:CrudService ,private _snackBar: MatSnackBar ,private route :Router) { }
datastorage:any
datacomment=new Commentdata("","")

color="white"
list:any
userComment:any
alluserdata:any
datacomments:any[]=[]
dataarray:{username:string , comment:string}[]=[];
  ngOnInit(): void {
    this.datastorage= this.movie.data
    this.fav.getalluser().subscribe(c=>{

this.datacomments.splice(0,this.datacomments.length)
      this.alluserdata=c
      
for(let i=0;i<this.alluserdata.length;i++){
       console.log(this.alluserdata[i].username)
  for(let j=0;j<this.alluserdata[i].movie.length;j++){
   
    
     for(let k=0;k<this.alluserdata[i].movie[j].comments.length;k++){
  
      console.log(this.alluserdata[i].movie[j].comments[k])
this.datacomments.push( this.datacomment={
  username:this.alluserdata[i].username,comment:this.alluserdata[i].movie[j].comments[k]
});
   }     
   }}
  }

  )
    // =======================================================
    
   

    // //////////////////////////////////////////////////////
  
    this.fav.getdatatofavlist().pipe(map(c=>{

      for(let a of c){
          console.log(a.movieName)
        if(a.movieName===this.datastorage.title){
   
          this.color="red"
          break;
         }else{
          this.color="white"
         }
      }
          
          })).subscribe()
   
  }
favourite=new Favourite("","","","","")
sendtofav(dataobj:any){
  console.log(dataobj)
  this.favourite={
  movieName:dataobj.title,
  releaseDate:dataobj.release_date,
  pictureURL:dataobj.poster_path,
  popularity:dataobj.popularity,
  overview:dataobj.overview
  }
this.fav.adddatatofav(this.favourite).subscribe(c=>{
  this._snackBar.open('added successfully', 'ok',{
    duration:1500
  });
},err=>{
  this._snackBar.open('movie is already present in favourites', 'ok',{
    duration:1500
  });
})
}

postComment(){
  console.log(this.userComment+"username is")
  console.log("title is "+this.datastorage.title)
  this.fav.postcomment(this.userComment,this.datastorage.title).subscribe(c=>{
    this.userComment=""
   
    this.fav.getalluser().subscribe(c=>{

      this.datacomments.splice(0,this.datacomments.length)
            this.alluserdata=c
            
      for(let i=0;i<this.alluserdata.length;i++){
             console.log(this.alluserdata[i].username)
        for(let j=0;j<this.alluserdata[i].movie.length;j++){
         
          
           for(let k=0;k<this.alluserdata[i].movie[j].comments.length;k++){
        
            console.log(this.alluserdata[i].movie[j].comments[k])
      this.datacomments.push( this.datacomment={
        username:this.alluserdata[i].username,comment:this.alluserdata[i].movie[j].comments[k]
      });
         }
         }}
        }
      
        )
    
  });
  //********************************************************* */

}


}
