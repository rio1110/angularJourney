import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HouseholdAccountsComponent } from './household-accounts.component';

describe('HouseholdAccountsComponent', () => {
  let component: HouseholdAccountsComponent;
  let fixture: ComponentFixture<HouseholdAccountsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HouseholdAccountsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HouseholdAccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
