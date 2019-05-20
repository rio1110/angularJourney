import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private loginService:AuthenticationService, private http: HttpClient, private router: Router) {
    // this.loginService.authenticate(undefined);
   }

  ngOnInit() {
  }

  logout() {
    this.http.post('logout', {}).subscribe(() => {
      this.loginService.authenticated = false;
      this.router.navigateByUrl('/login');
    })
  }
}
