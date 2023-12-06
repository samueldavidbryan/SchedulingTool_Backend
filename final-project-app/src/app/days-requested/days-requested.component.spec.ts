import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DaysRequestedComponent } from './days-requested.component';

describe('DaysRequestedComponent', () => {
  let component: DaysRequestedComponent;
  let fixture: ComponentFixture<DaysRequestedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DaysRequestedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DaysRequestedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
