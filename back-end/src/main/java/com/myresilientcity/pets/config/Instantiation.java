package com.myresilientcity.pets.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.myresilientcity.pets.domain.entity.Publicacao;
import com.myresilientcity.pets.domain.entity.Usuario;
import com.myresilientcity.pets.domain.entity.UsuarioCNPJ;
import com.myresilientcity.pets.domain.entity.UsuarioCPF;
import com.myresilientcity.pets.domain.entity.enums.AnimalEnum;
import com.myresilientcity.pets.domain.entity.enums.StatusAdocao;
import com.myresilientcity.pets.domain.entity.enums.TipoUsuario;
import com.myresilientcity.pets.domain.repository.PublicacaoRepository;
import com.myresilientcity.pets.domain.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner{

	private final UsuarioRepository usuarioRepository;
	private final PublicacaoRepository publicacaoRepository;

	
	@Override
	public void run(String... args) throws Exception {
		//Usuarios CNPJ e CPF
		Usuario usuarioCNPJ = new UsuarioCNPJ(null, "Grupo LTDA", "grupo@gmail.com", "123", TipoUsuario.DOADOR_CNPJ, "21736182376", "Razao e emocao", "rua das ruas");
		usuarioCNPJ.getTelefone().addAll(Arrays.asList("1231231123", "123123123"));
		this.usuarioRepository.save(usuarioCNPJ);
		
		 Usuario usuarioCPF1 = new UsuarioCPF(null, "Matheus", "Matheusmmv14@gmail.com", "123", TipoUsuario.DOADOR_CPF, true);
         Usuario usuarioCPF2 = new UsuarioCPF(null, "Geovana", "geovana@gmail.com", "123", TipoUsuario.DOADOR_CPF, false);
 			usuarioCPF1.getTelefone().addAll(Arrays.asList("34217641623", "425629834624"));
         this.usuarioRepository.saveAll(Arrays.asList(usuarioCPF1, usuarioCPF2));
         
         Publicacao publicacao1 = new Publicacao(null, "Estou doando um Cachorro!", usuarioCNPJ, StatusAdocao.DISPONIVEL, AnimalEnum.CACHORRO, LocalDateTime.now());
         Publicacao publicacao2 = new Publicacao(null, "Estou doando um gato", usuarioCPF1, StatusAdocao.DOADO, AnimalEnum.GATO, LocalDateTime.now());
         
         this.publicacaoRepository.saveAll(Arrays.asList(publicacao1, publicacao2));
		
		
		
	}

}
