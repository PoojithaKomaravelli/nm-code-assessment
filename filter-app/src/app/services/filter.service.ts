import { Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';



export interface Template {
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
    entries : Template[];    
}

@Injectable()
export class FilterService {
    private baseUrl ='https://api.publicapis.org/';

    constructor(private http: HttpClient){}
    
    getExamplesByCategory(category: string) :Observable<Response>{
        return this.http.get(this.baseUrl+'entries?category='+category).map(
        (res) => res as Response
            );
        }
   getCategories() : Observable<string[]> {
    return this.http.get(this.baseUrl+'categories').map((res) => res as string[]);
    }
}