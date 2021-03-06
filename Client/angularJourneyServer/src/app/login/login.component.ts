import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClient } from '@angular/common/http';
import { Login } from './login';
import { first } from 'rxjs/operators';
import { AlertServiceService } from '../service/alert-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private router: Router,
    private alertService: AlertServiceService,
    private loginservice: AuthenticationService) {}

  email: string = null;

  ngOnInit() {
  }

  login(email:string, password:string) {
    this.loginservice.authenticate({email, password} as Login)
      .pipe(first())
      .subscribe(
        (res)=>{this.router.navigate(['/index'])
        },
        (error) => {
          var errorMesage: string = error;
          if(new String(error).indexOf('401') != -1) {
            errorMesage = 'Error: Email or Password is not correct.'
          }
          this.alertService.error(errorMesage);
        });
  }
}
