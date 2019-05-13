import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClient } from '@angular/common/http';
import { Login } from './login';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router, private loginservice: AuthenticationService) {}

  email: string = null;

  ngOnInit() {
  }

  login(email:string, password:string) {
    this.loginservice.authenticate({email, password} as Login)
      .pipe(first())
      .subscribe(
        ()=>this.router.navigate(['/index']));
  }
}
