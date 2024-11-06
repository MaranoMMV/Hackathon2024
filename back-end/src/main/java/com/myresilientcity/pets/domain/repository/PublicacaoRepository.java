package com.myresilientcity.pets.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myresilientcity.pets.domain.entity.Publicacao;
import com.myresilientcity.pets.domain.entity.Usuario;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long>{

	List<Publicacao> findByUsuario(Usuario usuario);
    List<Publicacao> findByStatus(Integer status);
}
