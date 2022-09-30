import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavmoviedetailsComponent } from './favmoviedetails.component';

describe('FavmoviedetailsComponent', () => {
  let component: FavmoviedetailsComponent;
  let fixture: ComponentFixture<FavmoviedetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FavmoviedetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FavmoviedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
