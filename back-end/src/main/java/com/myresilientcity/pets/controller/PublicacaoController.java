package com.myresilientcity.pets.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myresilientcity.pets.domain.entity.Publicacao;
import com.myresilientcity.pets.domain.entity.dto.PublicacaoDTO;
import com.myresilientcity.pets.domain.repository.UsuarioRepository;
import com.myresilientcity.pets.services.PublicacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/postagens")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PublicacaoController {
	

	private final PublicacaoService publicacaoService;
	private final UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Publicacao> getPublicacoes(){
		return this.publicacaoService.listagemDePublicacao();
	}
	
	@PostMapping("/private")
	public ResponseEntity<Publicacao> postPublicacao(PublicacaoDTO publicacaoDTO){
		Publicacao publicacao = this.publicacaoService.salvarPublicacao(publicacaoDTO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(publicacao);
	}
	
	@GetMapping("/private/publicacaopessoa/{id}")
	public List<Publicacao> getPublicacoesPorPessoa(@PathVariable Long id){
		System.out.println("id: " + id);
		return this.publicacaoService.ListarPublicacaoPorPessoa(id);
	}
	
}
