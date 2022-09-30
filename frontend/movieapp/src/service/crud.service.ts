import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
username:any;
data:any;
movieNameForList:any

  constructor(private http:HttpClient) { }



    registeruser(data:any):Observable<any>{
      return this.http.post<any>('http://localhost:5000/api/v2/register',data)
    }
    loginuser(data:any):Observable<any>{
      console.log("this is login data "+data)
      return this.http.post<any>('http://localhost:5000/samar-api/login',data)
    }
    adddatatofav(data:any):Observable<any>{

      const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
      console.log(this.username)
      return this.http.post<any>('http://localhost:5000/api/v2/fav/add/'+this.username,data,requestOptions)
      }
   getdatatofav():Observable<any>{
    const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
    const requestOptions = {headers: httpHeader}
      return this.http.get<any>('http://localhost:5000/api/v2/fav/allMovies/'+this.username,requestOptions)
      }
      removefav(value:any):Observable<any>{
        const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
        const requestOptions = {headers: httpHeader}
      return this.http.delete<any>('http://localhost:5000/api/v2/fav/delete/'+this.username+"/"+value,requestOptions)
      }
    
      getdatatofavlist():Observable<any>{
        const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
        const requestOptions = {headers: httpHeader}
          return this.http.get<any>('http://localhost:5000/api/v2/fav/allMovieslist/'+this.username,requestOptions)
          }
     
          postcomment(value:any,movieName:any):Observable<any>{
            const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
            const requestOptions = {headers: httpHeader}
          return this.http.post<any>('http://localhost:5000/api/v2/fav/comments/'+this.username+"/"+movieName+"/"+value,requestOptions)
          }
          getalluser():Observable<any>{
            const httpHeader = new HttpHeaders({"Content-Type":"application/json",Authorization:`Bearer ${sessionStorage.getItem('token')}` })
            const requestOptions = {headers: httpHeader}
              return this.http.get<any>('http://localhost:5000/api/v2/fav/alluser/'+this.movieNameForList,requestOptions)
              }

    }
