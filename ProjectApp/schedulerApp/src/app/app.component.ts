import { Component, Input } from '@angular/core';
import { RequestDaysOff } from './day-off-request';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Scheduler Tool';
  @Input() req: RequestDaysOff;
  requested: RequestDaysOff = null;
  requests: Array<RequestDaysOff> = null;
  error: HttpErrorResponse = null;
  appsection = 1;

  constructor(private http: HttpClient) {

  }

  getRequestByNumber(number: number): void {
    this.error = null;
    this.requests = null;
    this.http.get<Array<RequestDaysOff>>('http://localhost:8080/schedule/return/' + number)
      .subscribe(data => {
          this.requested.date = data;
          console.log(this.req.date);
        }, (error: HttpErrorResponse) => {
          this.error = error;
        }
      );
  }
}
