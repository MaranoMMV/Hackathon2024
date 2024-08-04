import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { PacotaoMaterialModule } from '../../../pacotao-material.module';

@Component({
  selector: 'app-home-menu',
  standalone: true,
  imports: [PacotaoMaterialModule],
  templateUrl: './home-menu.component.html',
  styleUrl: './home-menu.component.scss'
})
export class HomeMenuComponent {

}
