import { Component } from '@angular/core';
import { HomeCarouselComponent } from '../home-carousel/home-carousel.component';
import { HomeFooterComponent } from '../template/home-footer/home-footer.component';
import { HomePublicacaoFormComponent } from '../publicacao/home-publicacao-form/home-publicacao-form.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HomePublicacaoFormComponent, HomeFooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
  
})
export class HomeComponent {

}
