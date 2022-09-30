import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Route, Router } from '@angular/router';
import { CrudService } from 'src/service/crud.service';
import { LoginService } from 'src/service/login.service';
import { Login } from '../class/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route:Router, private crud:CrudService ,private loginvalue:LoginService ,private _snackBar: MatSnackBar) { }
  profileForm = new FormGroup({
    name : new FormControl('', [Validators.required ]),
    pass : new FormControl('', [Validators.required])
  })
  userLogin= new Login("","")
  getusername() {
    
    return this.profileForm.controls.name
    }

  getpassword() {
    return this.profileForm.controls.pass
  }
  
  hide = true;
    onsubmit(){
    console.log(this.userLogin)
    this.crud.username=this.userLogin.username
    this.crud.loginuser(this.userLogin).subscribe(c=>{
      console.log(c)
     this.loginvalue.displaylogo="none"
     this.loginvalue.displayavatar="block"
      if(c.message=="User Successfully logged in")
      {
        
        sessionStorage.setItem("token",c.token)
        this._snackBar.open('Logged in successfully', 'ok',{
          duration:1000
        });
        
        this.route.navigateByUrl('/')  
        this.loginvalue.login=true
      }
      }, err=>{
      this._snackBar.open("check your username password", "close")
      });
      }

  ngOnInit(): void {
  }

}
