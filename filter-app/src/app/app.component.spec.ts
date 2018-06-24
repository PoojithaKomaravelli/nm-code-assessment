import { ComponentFixture, TestBed} from '@angular/core/testing';
import { FilterService } from  './services/filter.service';
import { AppComponent } from './app.component';
import {Observable} from 'rxjs/Observable';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Ng2AutoCompleteModule } from 'ng2-auto-complete';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/map'


class MockFilterService {
    private baseUrl = 'https://api.publicapis.org/';
    getExamplesByCategory(category: string): Observable<Response> {
        return Observable.of(null);
    }
    getCategories(): Observable<string[]> {
        return Observable.of(["Books", "Authors"]);
    }

}
describe('AppComponent', () => {
    let appComponent: AppComponent;
    let filterService: MockFilterService;
    let fixture: ComponentFixture<AppComponent>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [
                AppComponent
            ], imports: [
                Ng2AutoCompleteModule,
                FormsModule,
                BrowserModule,
                HttpClientModule
            ],
            providers: [
                { provide: FilterService, useClass: MockFilterService }
            ]
        });
        appComponent = TestBed.createComponent(AppComponent).componentInstance;
        filterService = TestBed.get(FilterService);
    });


    it('should create the app', () => {
        expect(appComponent).toBeTruthy();
    });

    it('should not show group data on load', () => {
        appComponent.categories = ["Animals", "Books"];
        appComponent.selectedCategory = 'Books';
        appComponent.ngOnInit();
        appComponent.filterCategories();
        expect(appComponent.showNoData).toEqual(false);
    });


});

