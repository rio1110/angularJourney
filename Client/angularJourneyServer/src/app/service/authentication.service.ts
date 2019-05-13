import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Login } from '../login/login';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  authenticated = false;
  private loginUrl = 'http://localhost:8080/login';

  constructor(private http: HttpClient) { }

  /**
   * post Login
   * @param login 
   * @param callback 
   */
  authenticate(login: Login): Observable<Login> {
    const body = new HttpParams()
    .set('email', login.email)
    .set('pass', login.password);
    return this.http.post<any>(
      this.loginUrl,
      body.toString(),
      httpOptions
      )
      .pipe(
      catchError(this.handleError<Login>('authenticate'))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  logOut() {
    sessionStorage.removeItem('email');
  }
}
