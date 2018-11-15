import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelfDevelopmentComponent } from './self-development.component';

describe('SelfDevelopmentComponent', () => {
  let component: SelfDevelopmentComponent;
  let fixture: ComponentFixture<SelfDevelopmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelfDevelopmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelfDevelopmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
