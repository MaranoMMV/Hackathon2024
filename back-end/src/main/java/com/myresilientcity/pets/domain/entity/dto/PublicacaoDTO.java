package com.myresilientcity.pets.domain.entity.dto;

import org.springframework.web.multipart.MultipartFile;

public record PublicacaoDTO(String texto, Long idUsuario, Integer StatusAdocao, Long idImagem, Integer animal, MultipartFile file ) {

}
