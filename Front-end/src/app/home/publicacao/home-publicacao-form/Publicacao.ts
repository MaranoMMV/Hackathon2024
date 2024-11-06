import { UsuarioPublicacao } from "../UsuarioPublicacao";

export class Publicacao{
    id: number;
    texto: string;
    imagemPublicacao: any;
    comentarios: any;
    animal: number;
    usuario: UsuarioPublicacao;
    status: number;

    constructor(    id: number, texto: string, imagemPublicada: any, comentarios: any, animal: number,    usuario: UsuarioPublicacao, status: number){
        this.id = id;
        this.texto = texto;
        this.imagemPublicacao = imagemPublicada;
        this.comentarios = comentarios;
        this.animal = animal;
        this.usuario = usuario;
        this.status = status;
    }
}

export class PublicacaoDTO{
    id: number;
    texto: string;
    imagemPublicacao: any;
    animal: number;

    constructor(    id: number, texto: string, imagemPublicada: any, animal: number){
        this.id = id;
        this.texto = texto;
        this.imagemPublicacao = imagemPublicada;
        this.animal = animal;
    }
}