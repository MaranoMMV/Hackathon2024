package com.myresilientcity.pets.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myresilientcity.pets.domain.entity.enums.TipoUsuario;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class  Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	private String Estado;

	private String Cidade;
	
	   @OneToMany(mappedBy = "usuario")
	   @JsonIgnore
	    private List<Publicacao> publicacoes = new ArrayList<>();
	
	private Integer tipoUsuario;
	
	@ElementCollection
	@CollectionTable(name="telefone")
	private Set<String> telefone = new HashSet<>();

	public Usuario(Long id, @NotNull String nome, @NotNull String email, @NotNull String password, TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.tipoUsuario = tipoUsuario.getCod();
	}
	

}
