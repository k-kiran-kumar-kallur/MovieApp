import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/service/crud.service';
import { GetrecommendedDataService } from 'src/service/getrecommended-data.service';
import { MoviedetailsService } from 'src/service/moviedetails.service';
import { filter, map, Observable } from 'rxjs';
import * as AOS from 'aos';
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  constructor(private getalllist:GetrecommendedDataService, private moviedetails:MoviedetailsService,private fav:CrudService) { }

  alldata:any;
arr2:any[]=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
page=1;
  ngOnInit(): void {
    AOS.init();
    this.getalllist.getalldata(this.page).subscribe(c=>{
      console.log(c)
      this.alldata=c;
      console.log(this.arr2.length)
    
    })
   
  }
  status:any="disabled"
  add(value:any){ 
    if(this.page>1 ||value>0){
    this.page=this.page+value
  this.status=""}
    else{
this.status="disabled"
    }
    this.getalllist.getalldata(this.page).subscribe(c=>{
      this.alldata=c;
      console.log(this.arr2.length)
    
    })
  }

  navigate(a:any){
    
      this.page=a
  
      this.getalllist.getalldata(this.page).subscribe(c=>{
        this.alldata=c;
        console.log(this.arr2.length)
      
      }
  )}
  carddata(value:any){
    
    this.moviedetails.data=value;
    this.fav.movieNameForList=value.title
  }
 

}
