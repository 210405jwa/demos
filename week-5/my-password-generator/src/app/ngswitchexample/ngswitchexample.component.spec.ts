import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgswitchexampleComponent } from './ngswitchexample.component';

describe('NgswitchexampleComponent', () => {
  let component: NgswitchexampleComponent;
  let fixture: ComponentFixture<NgswitchexampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NgswitchexampleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NgswitchexampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
