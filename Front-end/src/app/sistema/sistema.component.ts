import { Component } from '@angular/core';
import { PacotaoMaterialModule } from '../pacotao-material.module';

@Component({
  selector: 'app-sistema',
  standalone: true,
  imports: [PacotaoMaterialModule],
  templateUrl: './sistema.component.html',
  styleUrl: './sistema.component.scss'
})
export class SistemaComponent {

}
