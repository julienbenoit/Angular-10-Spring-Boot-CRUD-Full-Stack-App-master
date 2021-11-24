import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fond } from '../models/fond.model';
import { Contrat } from '../models/contrat.model';

const baseUrl = 'http://localhost:8080/api/v1';

@Injectable({
  providedIn: 'root'
})
export class ContratService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Contrat[]> {
    return this.http.get<Contrat[]>(`${baseUrl}/contrats`);
  }
  getAllFond(id: any): Observable<Fond[]> {
    return this.http.get<Fond[]>(`${baseUrl}/contrats/${id}`);
  }
  get(id: any): Observable<Contrat> {
    return this.http.get(`${baseUrl}/contrat/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/create/contrat`, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/contrat/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/contrat/${id}`);
  }

  findByName(name: any): Observable<Contrat[]> {
    return this.http.get<Contrat[]>(`${baseUrl}/contrat?name=${name}`);
  }
}
