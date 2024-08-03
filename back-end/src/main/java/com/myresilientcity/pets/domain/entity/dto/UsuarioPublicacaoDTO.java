package com.myresilientcity.pets.domain.entity.dto;

import java.util.Set;

public record UsuarioPublicacaoDTO(String nome, String email, Set<String> telefone) {

}
