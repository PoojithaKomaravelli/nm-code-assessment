import { Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';



export interface Entry {
    API: string;
    Description: string;
    Auth: string;
    HTTPS: string;
    Cors: string;
    Category: string;
    Link: string
    
}

export interface Response {
    count: number;
    entries : Entry[];    
}

@Injectable()
export class FilterService {
    private baseUrl ='http://localhost:8080/api/';

    constructor(private http: HttpClient){}
    
    getSearchResultsByCategory(category: string) :Observable<Response>{
        return this.http.get(this.baseUrl+'entries?category='+category).map(
        (res) => res as Response
            );}
        
        
   getCategories() : Observable<string[]> {
    return this.http.get(this.baseUrl+'categories').map((res) => res as string[]);
    }
}