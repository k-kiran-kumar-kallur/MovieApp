import { Component, OnInit } from '@angular/core';
import { GetrecommendedDataService } from 'src/service/getrecommended-data.service';

@Component({
  selector: 'app-chips',
  templateUrl: './chips.component.html',
  styleUrls: ['./chips.component.css']
})
export class ChipsComponent implements OnInit {

  constructor(private getalllist:GetrecommendedDataService) { }

  ngOnInit(): void {
  }
  search(value:any){
this.getalllist.genreId=value;
console.log(this.getalllist.genreId)
  }

}
