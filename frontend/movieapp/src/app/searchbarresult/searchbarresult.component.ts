import { Component, OnChanges, OnInit } from '@angular/core';
import { CrudService } from 'src/service/crud.service';
import { GetrecommendedDataService } from 'src/service/getrecommended-data.service';
import { LoginService } from 'src/service/login.service';
import { MoviedetailsService } from 'src/service/moviedetails.service';
import * as AOS from 'aos';

@Component({
  selector: 'app-searchbarresult',
  templateUrl: './searchbarresult.component.html',
  styleUrls: ['./searchbarresult.component.css']
})
export class SearchbarresultComponent implements OnInit  {
  data:any;
  result:any;
  constructor(private service:GetrecommendedDataService , private moviedetails:MoviedetailsService ,private login:LoginService ,private crud:CrudService) { 
    
  }
  avatar:any
  logo:any
  name:any
  ngOnInit() {
    AOS.init();
    this.name= this.crud.username
    this.logo=this.login.displaylogo;
    this.avatar=this.login.displayavatar; 
    this.service.getallbyname(this.service.movieName).subscribe(c=>{
     
      this.data=c
    })
  }
  
  carddata(value:any){
    this.moviedetails.data=value;
  }
  search(){
    this.service.movieName=this.result;
    this.service.getallbyname(this.service.movieName).subscribe(c=>{
     
      this.data=c
    })
  }
}
