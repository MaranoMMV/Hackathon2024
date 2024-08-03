package com.myresilientcity.pets.domain.entity;

import com.myresilientcity.pets.domain.entity.enums.TipoUsuario;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Data
public class UsuarioCPF extends Usuario{

	private static final long serialVersionUID = 1L;
	
	private Boolean aceitaReceberEmails;

	public UsuarioCPF(Long id, @NotNull String nome, @NotNull String email, @NotNull String password,
			TipoUsuario tipoUsuario, Boolean aceitaReceberEmails) {
		super(id, nome, email, password, tipoUsuario);
		this.aceitaReceberEmails = aceitaReceberEmails;
	}


	
	

}
