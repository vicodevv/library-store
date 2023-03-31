import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { forkJoin, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment as env } from 'src/environments/environment';
import { APIResponse, Book } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private readonly BASE_URL = env.BASE_URL; 

  constructor(private http: HttpClient) { }

  public getAllBooks(){
    return this.http.get<APIResponse<Book>>(`${this.BASE_URL}/api/books`);
  }
  
  }
