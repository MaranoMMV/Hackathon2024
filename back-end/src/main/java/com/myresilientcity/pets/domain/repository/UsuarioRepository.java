package com.myresilientcity.pets.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myresilientcity.pets.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	 Optional<Usuario> findByEmail(String email);

}
