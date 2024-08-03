import { UsuarioPublicacao } from "../UsuarioPublicacao";

export class Publicacao{
    id!: number;
    texto: string;
    imagemPublicacao: any;
    comentarios: any;
    animal: number;
    usuario: UsuarioPublicacao;
    status: number;

    constructor(texto: string, imagemPublicada: any, comentarios: any, animal: number,    usuario: UsuarioPublicacao, status: number){
        this.texto = texto;
        this.imagemPublicacao = imagemPublicada;
        this.comentarios = comentarios;
        this.animal = animal;
        this.usuario = usuario;
        this.status = status;
    }
}