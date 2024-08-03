package com.myresilientcity.pets.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.myresilientcity.pets.domain.entity.enums.AnimalEnum;
import com.myresilientcity.pets.domain.entity.enums.StatusAdocao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String texto;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    private Integer status;
    
    @OneToOne(mappedBy = "publicacao")
    private ImagemPostagem imagemPostagem;
    
    @ManyToMany
    private List<Comentario> comentarios;
    
    private Integer animalEnum;
    
    private LocalDateTime dataCriacao;

	public Publicacao(Long id, String texto, Usuario usuario, StatusAdocao status, AnimalEnum animalEnum, LocalDateTime dataCriacao) {
		super();
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.status = status.getCod();
		this.animalEnum = animalEnum.getCod();
		this.dataCriacao = dataCriacao;
	}
	
	

}
