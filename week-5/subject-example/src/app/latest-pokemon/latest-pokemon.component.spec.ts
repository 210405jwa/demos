import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LatestPokemonComponent } from './latest-pokemon.component';

describe('LatestPokemonComponent', () => {
  let component: LatestPokemonComponent;
  let fixture: ComponentFixture<LatestPokemonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LatestPokemonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LatestPokemonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
