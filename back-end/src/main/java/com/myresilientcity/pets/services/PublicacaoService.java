package com.myresilientcity.pets.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.myresilientcity.pets.domain.entity.Publicacao;
import com.myresilientcity.pets.domain.entity.Usuario;
import com.myresilientcity.pets.domain.entity.dto.PublicacaoDTO;
import com.myresilientcity.pets.domain.entity.enums.StatusAdocao;
import com.myresilientcity.pets.domain.repository.ImagemPostagemRepository;
import com.myresilientcity.pets.domain.repository.PublicacaoRepository;
import com.myresilientcity.pets.domain.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicacaoService {
	
	@Autowired
	private final PublicacaoRepository publicacaoRepository;
	private final ImagemPostagemRepository imagemPostagemRepository;
	private final UsuarioRepository usuarioRepository;
	
	
	public Publicacao salvarPublicacao(PublicacaoDTO publicacaoDTO) {
		this.imagemPostagemRepository.findById(publicacaoDTO.idImagem());
		Publicacao publicacao = new Publicacao();
		publicacao.setAnimalEnum(publicacaoDTO.animal());
		publicacao.setDataCriacao(LocalDateTime.now());
		publicacao.setImagemPostagem(null);
		publicacao.setStatus(StatusAdocao.DISPONIVEL.getCod());
		publicacao.setTexto(publicacaoDTO.texto());
		

		
		return this.publicacaoRepository.save(publicacao);
	}
	
	public Publicacao buscarPublicacaoPorId(Long id) {
		return this.publicacaoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacao Não encontrada!"));
	}
	
	public List<Publicacao> listagemDePublicacao(){
		 List<Publicacao> publicacoes = publicacaoRepository.findByStatus(2);
	        return publicacoes.stream().map( publicacao -> {
	        	publicacao.getUsuario().setPassword(null);
	        	publicacao.getUsuario().setPublicacoes(null);
	        	publicacao.getUsuario().setTipoUsuario(null);
	        	return publicacao;
	        }

	        		).collect(Collectors.toList());

	}
	
	public void editarPublicacao(Long id, Publicacao publicacaoAtualizada) {
		this.publicacaoRepository.findById(id).map( publicacao -> {
			publicacao.setAnimalEnum(publicacaoAtualizada.getAnimalEnum());
			publicacao.setStatus(publicacaoAtualizada.getStatus());
			publicacao.setTexto(publicacaoAtualizada.getTexto());
			return this.publicacaoRepository.save(publicacao);
		}).orElseThrow( () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacao não encontrada!"));
	}
	
	public List<Publicacao> ListarPublicacaoPorPessoa(Long id) {
		Usuario usuario = this.usuarioRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado para a busca de publicacoes"));
		System.out.println(usuario.toString());
		return this.publicacaoRepository.findByUsuario(usuario);
	}

}
