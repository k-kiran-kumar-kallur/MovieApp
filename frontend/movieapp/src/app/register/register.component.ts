import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CrudService } from 'src/service/crud.service';
import { Register } from '../class/register';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private route:Router ,private crud:CrudService,private _snackBar: MatSnackBar) { }
 
  hide = true;

    register= new FormGroup({
    userName:new FormControl('',[Validators.required]),
    userEmailId:new FormControl('',[Validators.required,Validators.email]) ,
    userPassword:new FormControl('',[Validators.required])
   , usernumber:new FormControl('',[Validators.required])})
    
registerobject =new Register("","","","")

  getEmailId(){
    return this.register.controls.userEmailId
  }
  getusername() {
    return this.register.controls.userName
    }

  getpassword() {
    return this.register.controls.userPassword
  }
  getusernumber(){
    return this.register.controls.usernumber
  }
  
  onsubmit(){
this.crud.registeruser(this.registerobject).subscribe(c=>console.log(c))
this._snackBar.open("User registered sucessfulyy", "close")
this.route.navigateByUrl('/login')
}

  ngOnInit(): void {
  }

}
