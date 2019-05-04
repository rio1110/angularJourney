import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {email: '', password: ''};

  constructor(private http: HttpClient, private router: Router, private loginservice: AuthenticationService) {}

  ngOnInit() {
  }

  login() {
    this.loginservice.authenticate(this.credentials, () => {
        this.router.navigateByUrl('/login');
    });
    return false;
  }


}
