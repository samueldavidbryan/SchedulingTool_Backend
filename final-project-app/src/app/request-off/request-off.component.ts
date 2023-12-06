import { Component, OnInit } from '@angular/core';
import { RequestDaysOff } from '../day-off-request';

@Component({
  selector: 'app-request-off',
  templateUrl: './request-off.component.html',
  styleUrls: ['./request-off.component.css']
})
export class RequestOffComponent implements OnInit {
  /*
  
  */
 request: RequestDaysOff = {
  number : 1,
  date : 2008-10-5,
  status : "PENDING",
 };

  constructor() { }

  ngOnInit() {
  }

}
