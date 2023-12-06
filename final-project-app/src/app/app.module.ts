import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RequestOffComponent } from './request-off/request-off.component';
import { DaysRequestedComponent } from './days-requested/days-requested.component';
import { EmployeesComponent } from './employees/employees.component';
import { HttpClientModule }    from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    RequestOffComponent,
    DaysRequestedComponent,
    EmployeesComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
