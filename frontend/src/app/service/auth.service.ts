import { Injectable } from '@angular/core';
import axios from 'axios';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl = 'http://localhost:8080/login'; // URL del endpoint de login en tu backend

  constructor() {}

  login(username: string, password: string): Observable<any> {
    const body = { username, password };

    return new Observable(observer => {
      axios.post(this.loginUrl, body, { headers: { 'Content-Type': 'application/json' }})
        .then(response => {
          if (response.data && response.data.token) {
            localStorage.setItem('token', response.data.token);
            console.log(response.data.token);
          }
          observer.next(response.data);
          observer.complete();
        })
        .catch(error => {
          observer.error(error);
        });
    });
  }
}

