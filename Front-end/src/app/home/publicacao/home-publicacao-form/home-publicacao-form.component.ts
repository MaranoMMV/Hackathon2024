import { Component, OnInit } from '@angular/core';
import { Publicacao } from './Publicacao';
import { PublicacaoService } from '../../../services/publicacao.service';
import { NgClass, NgStyle } from '@angular/common';

@Component({
  selector: 'app-home-publicacao-form',
  standalone: true,
  imports: [NgStyle, NgClass],
  templateUrl: './home-publicacao-form.component.html',
  styleUrl: './home-publicacao-form.component.scss',
  providers: [PublicacaoService]
})
export class HomePublicacaoFormComponent implements OnInit {


  publicacao!: Publicacao;
  publicacoes: Publicacao[] = [];

  constructor(private publicacaoService: PublicacaoService){}

  ngOnInit(): void {
    this.publicacaoService.list().subscribe( (response: any) => {
      console.log(response)
      this.publicacoes = response;
    }
  )
  }
}
