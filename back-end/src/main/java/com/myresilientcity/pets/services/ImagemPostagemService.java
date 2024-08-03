package com.myresilientcity.pets.services;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myresilientcity.pets.domain.entity.ImagemPostagem;
import com.myresilientcity.pets.domain.entity.Publicacao;
import com.myresilientcity.pets.domain.repository.ImagemPostagemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImagemPostagemService {

	private PublicacaoService publicacaoService;
	private ImagemService imagemService;
	private ImagemPostagemRepository imagemRepositoryRepository;
	
	public BodyBuilder uplaodImage(MultipartFile file, Long idPublicacao ) throws IOException {
		
		Publicacao publicacao = this.publicacaoService.buscarPublicacaoPorId(idPublicacao);

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImagemPostagem img = new ImagemPostagem(null, file.getOriginalFilename(), file.getContentType(),
				imagemService.compressBytes(file.getBytes()), publicacao );
		imagemRepositoryRepository.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}
}
