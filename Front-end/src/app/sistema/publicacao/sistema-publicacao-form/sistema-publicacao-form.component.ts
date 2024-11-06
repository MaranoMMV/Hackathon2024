import { Component } from '@angular/core';
import { PacotaoMaterialModule } from '../../../pacotao-material.module';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Publicacao, PublicacaoDTO } from '../../../home/publicacao/home-publicacao-form/Publicacao';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PublicacaoService } from '../../../services/publicacao.service';
import { MatFileUploadModule } from 'angular-material-fileupload';


@Component({
  selector: 'app-sistema-publicacao-form',
  standalone: true,
  imports: [PacotaoMaterialModule],
  templateUrl: './sistema-publicacao-form.component.html',
  styleUrl: './sistema-publicacao-form.component.scss'

})
export class SistemaPublicacaoFormComponent {

  id!:number;
  formulario!: FormGroup;

  publicacao!: Publicacao;

  constructor(
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private publicacaoService: PublicacaoService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
  ) { }

  onSubmit() {
    if (this.id) {
      const formValues = this.formulario.value;
      const publicacao: PublicacaoDTO = new PublicacaoDTO(
        formValues.id,
        formValues.texto,
        formValues.animal,
        formValues.imagem,
      );
      console.log(publicacao)
      this.publicacaoService.atualizar(publicacao)
        .subscribe(response => {
          this.openSnackBar("Publicacao editado com sucesso!!", "fechar");
          this.router.navigate(['sistema/cliente']);
        });
    } else {
      const formValues = this.formulario.value;
      const publicacao: PublicacaoDTO = new PublicacaoDTO(
        formValues.id,
        formValues.texto,
        formValues.animal,
        formValues.imagem,
      );
      this.publicacaoService.salvar(publicacao).subscribe(response => {
        this.openSnackBar("Publicacao editado com sucesso!!", "fechar");
        this.router.navigate(['sistema/cliente']);
      });
    }
  }
    voltarListagem() {
      this.router.navigate(['sistema/cliente']);
    }

    openSnackBar(message: string, action: string) {
      this.snackBar.open(message, action);
    }
  }

