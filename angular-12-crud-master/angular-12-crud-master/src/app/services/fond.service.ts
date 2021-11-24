import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fond } from '../models/fond.model';

const baseUrl = 'http://localhost:8080/api/v1';

@Injectable({
  providedIn: 'root'
})
export class FondService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Fond[]> {
    return this.http.get<Fond[]>(`${baseUrl}/contrats`);
  }
  get(id: any): Observable<Fond> {
    return this.http.get(`${baseUrl}/fond/${id}`);
  }
  create(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/create/fond`, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/fond/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/fond/${id}`);
  }


}