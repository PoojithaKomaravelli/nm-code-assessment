# FilterApp

This project was initially generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.3.2. The app helps the user to quickly choose from  available options. Here are few features of the app :
On load of the page , user will see a search input field. 
On click of the input field, he will see a list of options available to select/filter .
As the user gives the input, suggestions are populated in alphabetical order.
On successful selection of category , search results  are populated to the user in alphabetical order with first letter of each Search result capitalized.
If the API used to fetch the data for selected category doesnt give a positive response user will see message :  “Unfortunately no results were found. Please try after sometime”.


# Angular CLI goodies

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.
