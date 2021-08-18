import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Insurance } from '../model/insurance';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

private url = 'http://localhost:8080/api/insurance';

  constructor(private http: HttpClient) {}

  save(data: [][]){
    return this.http.post(this.url, data).pipe(tap(console.log));
  }

  get(): Observable<Insurance[]>{
    return this.http.get(this.url).pipe(tap(console.log));
  }

  delete(): Observable<{}>{
    return this.http.delete(this.url).pipe(tap(console.log));
  }


}


