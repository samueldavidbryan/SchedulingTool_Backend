import { Component, OnInit, Input } from '@angular/core';
import { RequestDaysOff } from '../day-off-request'
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Employee } from '../employee';

@Component({
  selector: 'app-request-off',
  templateUrl: './request-off.component.html',
  styleUrls: ['./request-off.component.css']
})
export class RequestOffComponent implements OnInit {
  @Input() req: RequestDaysOff;
  @Input() num: Employee;

  requested: RequestDaysOff = null;
  employeeNum: Employee = {
    id: 1,
    firstName: "Lina",
    lastName: "Fina"
  }
  error: HttpErrorResponse = null;
  request: RequestDaysOff = {
    date : 2018-12-30,
    status : "PENDING",
    number : 1,
  }

  constructor(private http: HttpClient) { }

  addRequestToSchedule(number: number, date: any): void {
    this.http.post('http://localhost:8080/schedule/day/' +
      {number} + '/'+ {date} )
      .subscribe(data => {
        this.requested.date = data;
      });
  }

  ngOnInit (): void {
    this.addRequestToSchedule(this.requested.number, this.requested.date);

  }

}
