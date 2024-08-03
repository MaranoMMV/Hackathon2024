package com.myresilientcity.pets.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ImagemPostagem extends Imagem {


    @JoinColumn(name = "publicacao_id")
    @OneToOne
    private Publicacao publicacao;

    public ImagemPostagem(Long id, String name, String type, byte[] picByte, Publicacao publicacao) {
        super(id, name, type, picByte);
        this.publicacao = publicacao;
    }
    



	

	
	

}
