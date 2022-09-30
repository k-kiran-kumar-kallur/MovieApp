import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from 'src/service/login.service';

@Injectable({
  providedIn: 'root'
})
export class CardguardGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.checkloginin();
  }
  
  constructor(private log:LoginService){

  }
    checkloginin(){
  if(this.log.login==true){
    return true
  }else{
    return false
  }
    }
    
}
