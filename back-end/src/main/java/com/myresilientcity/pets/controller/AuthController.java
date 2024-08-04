package com.myresilientcity.pets.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myresilientcity.pets.config.infra.TokenService;
import com.myresilientcity.pets.domain.entity.Usuario;
import com.myresilientcity.pets.domain.entity.dto.LoginRequestDTO;
import com.myresilientcity.pets.domain.entity.dto.RegisterRequestDTO;
import com.myresilientcity.pets.domain.entity.dto.ResponseDTO;
import com.myresilientcity.pets.domain.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class AuthController {
	
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    @PostMapping("login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body){
    	System.out.println(body.toString());
        Usuario usuario = this.usuarioRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), usuario.getPassword())) {
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(new ResponseDTO(usuario.getId(), usuario.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body){
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(body.email());

        if(usuario.isEmpty()) {
        	Usuario novoVendedor = new Usuario();
            novoVendedor.setPassword(passwordEncoder.encode(body.password()));
            novoVendedor.setEmail(body.email());
            novoVendedor.setNome(body.name());
            this.usuarioRepository.save(novoVendedor);

            String token = this.tokenService.generateToken(novoVendedor);
            return ResponseEntity.ok(new ResponseDTO(novoVendedor.getId(), novoVendedor.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}

