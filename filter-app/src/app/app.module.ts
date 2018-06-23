import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { Ng2AutoCompleteModule } from 'ng2-auto-complete';


@NgModule({
    declarations: [
        AppComponent
    ],

    imports: [
        Ng2AutoCompleteModule,
        FormsModule,
        BrowserModule,
        HttpClientModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
