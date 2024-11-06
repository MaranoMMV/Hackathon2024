import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SistemaPublicacaoFormComponent } from './sistema-publicacao-form.component';

describe('SistemaPublicacaoFormComponent', () => {
  let component: SistemaPublicacaoFormComponent;
  let fixture: ComponentFixture<SistemaPublicacaoFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SistemaPublicacaoFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SistemaPublicacaoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
