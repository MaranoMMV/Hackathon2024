import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Publicacao } from '../home/publicacao/home-publicacao-form/Publicacao';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PublicacaoService {
  url: string = 'http://localhost:8080/api/postagens';
  constructor(private http: HttpClient) { }

  list(): Observable<Publicacao[]> {
  return this.http.get<Publicacao[]>(`${this.url}`); 
}
}
