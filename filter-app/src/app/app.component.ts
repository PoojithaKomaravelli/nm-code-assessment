import { Component, OnInit } from '@angular/core';
import { FilterService, Entry } from  './services/filter.service';
import {HttpClient} from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';



@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [FilterService, HttpClient],
    
})
export class AppComponent implements OnInit {
    public categories: string[];
    public selectedCategory: string;
    public showGroups: boolean = false;
    public showNoData: boolean = false;

    public searchResults: string[] = [];
    constructor(private service: FilterService) {

    }

    ngOnInit() {
        this.service.getCategories().subscribe(
            data => { this.categories = (data); });
    }

    filterCategories() {

        this.searchResults = [];
        if (this.selectedCategory != 'Select' && this.categories.indexOf(this.selectedCategory) >= 0) {

            this.service.getSearchResultsByCategory(this.selectedCategory).subscribe(
                (data) => {
                    this.showGroups = true;
                    this.showNoData = false;
                    data.entries.
                        forEach((element) => { this.searchResults.push(element.API); })
                    this.searchResults.sort();
                },
                (err) => {
                    this.showNoData = true;
                    this.showGroups = false;
                }
            );

        } else {
            this.showGroups = false;

        }


    }


}
