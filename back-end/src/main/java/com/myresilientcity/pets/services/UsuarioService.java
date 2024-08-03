package com.myresilientcity.pets.services;

import org.springframework.stereotype.Service;

import com.myresilientcity.pets.domain.entity.Usuario;
import com.myresilientcity.pets.domain.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public Usuario salvarUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
}
