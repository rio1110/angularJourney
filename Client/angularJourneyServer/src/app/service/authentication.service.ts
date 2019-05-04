import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  authenticated = false;
  private loginUrl = '/login';

  constructor(private http: HttpClient) { }

  authenticate(credentials, callback) {
    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.post('/login', {headers: headers}).subscribe(response => {
      if (response['email']) {
          this.authenticated = true;
      } else {
          this.authenticated = false;
      }
      return callback && callback();
    });
  }

  // isUserLoggedIn() {
  //   let user = sessionStorage.getItem('email');
  //   console.log(!(user === null))
  //   return !(user === null)
  // }

  logOut() {
    sessionStorage.removeItem('email');
  }
}
