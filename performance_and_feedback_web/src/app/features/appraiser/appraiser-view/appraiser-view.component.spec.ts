import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppraiserViewComponent } from './appraiser-view.component';

describe('AppraiserViewComponent', () => {
  let component: AppraiserViewComponent;
  let fixture: ComponentFixture<AppraiserViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppraiserViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppraiserViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
