package com.myresilientcity.pets.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myresilientcity.pets.domain.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
