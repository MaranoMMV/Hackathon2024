import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeInteresseAdocaoComponent } from './home-interesse-adocao.component';

describe('HomeInteresseAdocaoComponent', () => {
  let component: HomeInteresseAdocaoComponent;
  let fixture: ComponentFixture<HomeInteresseAdocaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeInteresseAdocaoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HomeInteresseAdocaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
