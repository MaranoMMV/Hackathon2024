import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePublicacaoFormComponent } from './home-publicacao-form.component';

describe('HomePublicacaoFormComponent', () => {
  let component: HomePublicacaoFormComponent;
  let fixture: ComponentFixture<HomePublicacaoFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomePublicacaoFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HomePublicacaoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
