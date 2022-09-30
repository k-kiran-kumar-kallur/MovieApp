import { Component, OnInit } from '@angular/core';
import { GetrecommendedDataService } from 'src/service/getrecommended-data.service';
import { MoviedetailsService } from 'src/service/moviedetails.service';
import * as AOS from 'aos';
@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {

  constructor(private getalllist:GetrecommendedDataService, private moviedetails:MoviedetailsService) { }
data:any
  ngOnInit() {
    AOS.init();
    this.getalllist.getallbygenreId(this.getalllist.genreId).subscribe(c=>{
 this.data=c
    })
  }
  carddata(value:any){
    this.moviedetails.data=value;
  }

}
