import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GetrecommendedDataService {
genreId:any;
movieName:any;
  constructor(private http:HttpClient) { }

 getalldata(page:any):Observable<any>{
  return this.http.get<any>("http://localhost:5000/tmdb/listed/"+page);
 }
 getallbygenreId(genreId:any):Observable<any>{
  return this.http.get<any>("http://localhost:5000/tmdb/listid/"+genreId);
 }
 getallbyname(movie:any):Observable<any>{
  return this.http.get<any>("http://localhost:5000/tmdb/listname/"+movie);
 }
 
}
