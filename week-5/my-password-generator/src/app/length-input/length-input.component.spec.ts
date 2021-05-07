import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LengthInputComponent } from './length-input.component';

describe('LengthInputComponent', () => {
  let component: LengthInputComponent;
  let fixture: ComponentFixture<LengthInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LengthInputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LengthInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
