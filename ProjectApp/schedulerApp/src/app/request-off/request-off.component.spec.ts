import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestOffComponent } from './request-off.component';

describe('RequestOffComponent', () => {
  let component: RequestOffComponent;
  let fixture: ComponentFixture<RequestOffComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestOffComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestOffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
