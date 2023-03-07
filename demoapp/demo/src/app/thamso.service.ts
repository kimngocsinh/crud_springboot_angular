import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { thamso } from './interface/thamso'; 
import { Observable } from 'rxjs';
import { Page } from './interface/page'; 

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ThamsoService {

  private url:string = 'http://localhost:8081/api/thamso';

  constructor(private http:HttpClient) { }


  public getAllThamSo(thamso:thamso):Observable<Page>{
  
    return this.http.post<Page>(`${this.url}/list`, thamso);
  }


  public addThamSo(thamso:thamso):Observable<thamso>{
    return this.http.post<thamso>(`${this.url}/add`, thamso);
  }

  public updateThamSo(thamso:thamso, id:number):Observable<thamso>{
    return this.http.put<thamso>(`${this.url}/update/${id}`, thamso);
  }

  public deleteThamSo(id:number):Observable<void>{
    return this.http.delete<void>(`${this.url}/delete/${id}`);
  }
}
