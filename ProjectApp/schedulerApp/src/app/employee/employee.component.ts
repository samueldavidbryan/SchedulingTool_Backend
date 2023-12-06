import { Component, OnInit, Input } from '@angular/core';
import { Employee } from '../employee'
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  error: HttpErrorResponse = null;
  emp: Employee = null;
  employeeNumber: number = null;
  appsection = 1;
  emplObj: Object = null;
  @Input() num: Employee;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.addSchedule(this.num.id);
  }
  //@PostMapping("/schedule/new/{employeeNumber}"
  addSchedule(_id: number): void {
    this.http.post<Employee>('http://localhost:8080/schedule/new/' , _id)
      .subscribe(data => {
          this.emp = data;
        },
        (error: HttpErrorResponse) => {
          this.error = error;
        });
  }



}
