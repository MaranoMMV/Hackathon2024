import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { HomeCarouselComponent } from './home-carousel/home-carousel.component';
import { HomeFooterComponent } from './template/home-footer/home-footer.component';
import { HomeMenuComponent } from './template/home-menu/home-menu.component';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { HomePublicacaoFormComponent } from './publicacao/home-publicacao-form/home-publicacao-form.component';
import { PublicacaoService } from '../services/publicacao.service';
import { HomeInteresseAdocaoComponent } from './home-interesse-adocao/home-interesse-adocao.component';



  @NgModule({
    declarations: [
      
    ],
    imports: [
      HomeCarouselComponent,
      CommonModule,
      SlickCarouselModule,
      MatSidenavModule,
      MatListModule,
      HttpClientModule,
      RouterModule,
      MatToolbarModule, 
      MatIconModule,
      MatButtonModule,
      HomePublicacaoFormComponent,
      HomeInteresseAdocaoComponent
    ],
  exports: [
    SlickCarouselModule,
    MatSidenavModule, 
    MatListModule,
    HttpClientModule, 
    RouterModule,
    MatToolbarModule, 
    MatIconModule, 
    MatButtonModule,
    HomeCarouselComponent,
    HomePublicacaoFormComponent,
    HomeInteresseAdocaoComponent
  ], providers: [
    PublicacaoService
  ]
})

export class HomeModule { }
