import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CrudService } from 'src/service/crud.service';
import { GetrecommendedDataService } from 'src/service/getrecommended-data.service';
import { LoginService } from 'src/service/login.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  constructor(private service:GetrecommendedDataService , private router:Router ,private login:LoginService , private crud :CrudService) { }
searchbar:any;
avatar:any
logo:any
name:any
  ngOnInit(): void {
   this.name= this.crud.username
    this.logo=this.login.displaylogo;
    this.avatar=this.login.displayavatar;
  }
  searchmethod(){
    
    this.service.movieName=this.searchbar;
    
 
  }
  
}
