import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from '../types/login-response.type';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  apiUrl: string = "http://localhost:8080/api/";

  constructor(private httpClient: HttpClient) { }

  login(email: string, password: string): Observable<LoginResponse> {
    return this.httpClient.post<LoginResponse>(`${this.apiUrl}login`, { email, password }).pipe(
      tap((value) => {
        sessionStorage.setItem("auth_token", value.token);
        sessionStorage.setItem("user-id", value.id.toString());
        sessionStorage.setItem("username", value.name);
      })
    );
  }

  getUserId(): number | null{
    const id = sessionStorage.getItem("user-id");
    return id ? Number(id) : null;
  }
}
