package com.myresilientcity.pets.domain.entity;

import com.myresilientcity.pets.domain.entity.enums.TipoUsuario;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class UsuarioCNPJ extends Usuario {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String razaoSocial;
	private String localizacao;
	
	public UsuarioCNPJ(Long id, @NotNull String nome, @NotNull String email, @NotNull String password,
			TipoUsuario tipoUsuario, String cnpj, String razaoSocial, String localizacao) {
		super(id, nome, email, password, tipoUsuario);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.localizacao = localizacao;
	}
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	

	

}
