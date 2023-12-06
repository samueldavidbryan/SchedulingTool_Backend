import { Component, OnInit } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';
import { RequestDaysOff } from '../day-off-request'
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-days-requested',
  templateUrl: './days-requested.component.html',
  styleUrls: ['./days-requested.component.css']
})
export class DaysRequestedComponent implements OnInit {

  date: RequestDaysOff = null;
  error: HttpErrorResponse = null;
  custnumreturned: Date = null;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

}
