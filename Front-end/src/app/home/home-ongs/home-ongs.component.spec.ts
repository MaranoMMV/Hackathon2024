import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeOngsComponent } from './home-ongs.component';

describe('HomeOngsComponent', () => {
  let component: HomeOngsComponent;
  let fixture: ComponentFixture<HomeOngsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeOngsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HomeOngsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
