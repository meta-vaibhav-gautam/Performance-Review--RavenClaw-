import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganisationalComponent } from './organisational.component';

describe('OrganisationalComponent', () => {
  let component: OrganisationalComponent;
  let fixture: ComponentFixture<OrganisationalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrganisationalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganisationalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
