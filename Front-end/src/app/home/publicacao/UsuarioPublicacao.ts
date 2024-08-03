export class UsuarioPublicacao{
    id!: number;
    email: string;
    nome: string;
    telefone: string[];

    constructor(email: string, nome: string, telefone: string[]){
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }
}