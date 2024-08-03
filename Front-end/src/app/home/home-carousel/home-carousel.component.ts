import { Component } from '@angular/core';
import { SlickCarouselModule } from 'ngx-slick-carousel';

@Component({
  selector: 'app-home-carousel',
  standalone: true,
  imports: [SlickCarouselModule],
  templateUrl: './home-carousel.component.html',
  styleUrl: './home-carousel.component.scss'
})
export class HomeCarouselComponent {
  slides = [
    {img: 'http://placehold.it/350x150/000000', alt: "Imagem1"},
    {img: "http://placehold.it/350x150/111111", alt: "Imagem2"},
    {img: "http://placehold.it/350x150/333333", alt: "Imagem3"},
    {img: "http://placehold.it/350x150/666666", alt: "Imagem4"}
  ];

  slideConfig = {
    "slidesToShow": 1,
    "slidesToScroll": 1,
    "autoplay": true,
    "autoplaySpeed": 3000,
    "pauseOnHover": true,
    "infinite": true,
    "responsive": [
      {
        "breakpoint": 992,
        "settings": {
          "infinite": true,
          "arrows": true,
          "slidesToShow": 1,
          "slidesToScroll": 1,
        },
      },
      {
        "breakpoint": 768,
        "settings": {
          "arrows": true,
          "infinite": true,
          "slidesToShow": 1,
          "slidesToScroll": 1,
        },
      },
    ],
  };
}