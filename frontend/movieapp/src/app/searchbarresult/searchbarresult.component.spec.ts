import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchbarresultComponent } from './searchbarresult.component';

describe('SearchbarresultComponent', () => {
  let component: SearchbarresultComponent;
  let fixture: ComponentFixture<SearchbarresultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchbarresultComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchbarresultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
