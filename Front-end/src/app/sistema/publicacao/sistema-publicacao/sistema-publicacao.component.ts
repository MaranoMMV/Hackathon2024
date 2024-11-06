import { Component } from '@angular/core';
import { Publicacao } from '../../../home/publicacao/home-publicacao-form/Publicacao';
import { PublicacaoService } from '../../../services/publicacao.service';
import { PacotaoMaterialModule } from '../../../pacotao-material.module';
import { LoginService } from '../../../services/login.service';

@Component({
  selector: 'app-sistema-publicacao',
  standalone: true,
  imports: [PacotaoMaterialModule],
  templateUrl: './sistema-publicacao.component.html',
  styleUrl: './sistema-publicacao.component.scss',
  providers: [PublicacaoService, LoginService]
})
export class SistemaPublicacaoComponent {


  publicacao!: Publicacao;
  publicacoes: Publicacao[] = [];

  constructor(private publicacaoService: PublicacaoService, private loginService: LoginService){}

  ngOnInit(): void {
    this.listarPublicacoes();
  }
  listarPublicacoes(){
    const id = this.loginService.getUserId();
    this.publicacaoService.listagemPublicacaoPorPessoa(Number(id)).subscribe( (response: any[]) => {
      (response);
      console.log(response)
      this.publicacoes = response;
    }
  )
  }
}


