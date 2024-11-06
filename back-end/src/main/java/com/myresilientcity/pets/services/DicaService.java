package com.myresilientcity.pets.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.myresilientcity.pets.domain.entity.Dica;
import com.myresilientcity.pets.domain.repository.DicaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DicaService {

	private final DicaRepository dicaRepository;
	
	public Dica adicionarDicas(Dica dica) {
		return this.dicaRepository.save(dica);
	}
	
	public List<Dica> listagemDica(){
		return this.dicaRepository.findAll();
	}
	
	public Dica procurarDicaPorId(Long id) {
		return this.dicaRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dica não encoontrada!"));
	}
	
	public void apagarDicaPorId(Long id) {
		this.dicaRepository.findById(id).map(dica -> {
			this.dicaRepository.delete(dica);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public void alterarDica(Long id, Dica dicaAlterada) {
		this.dicaRepository.findById(id).map(dica  -> {
			dica.setTexto(dicaAlterada.getTexto());
			dica.setTitulo(dicaAlterada.getTitulo());
			return this.dicaRepository.save(dica);
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
