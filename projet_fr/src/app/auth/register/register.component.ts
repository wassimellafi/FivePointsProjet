import { Component, OnInit } from '@angular/core';
import {LoginRequest} from "../../models/LoginRequest.model";
import {Router} from "@angular/router";
import {AuthServiceService} from "../../services/auth/auth-service.service";
import {JwtResponse} from "../../models/JwtResponse.model";

@Component({
  selector: 'ngx-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent  {

  user: any = {
    password: null,
    email: null,
    firstName:null,
    lastName:null,
  };
  loginRequest:LoginRequest;

  testAuth=false;
  authFailed=false;
  constructor(
    private router: Router,private serviceAuth:AuthServiceService) {

  }

  register()
  {
    this.serviceAuth.register(this.user).subscribe(
      (data:any)=>{
        this.router.navigateByUrl("/auth/login");
        this.testAuth=false;
      },
      (error)=>{
        this.testAuth=true;
      }
    )
  }


}
