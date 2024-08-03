package com.myresilientcity.pets.config.infra;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.myresilientcity.pets.domain.entity.Usuario;
import com.myresilientcity.pets.domain.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	   @Autowired
	    private TokenService tokenService;
	   
	   @Autowired 
	   private UsuarioRepository usuarioRepository;
	   
	   @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	        String token = recoverToken(request);
	        if (token != null) {
	            try {
	                String email = tokenService.validateToken(token);
	                if (email != null) {
	                    Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found"));
	                    var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	                    var authentication = new UsernamePasswordAuthenticationToken(usuario, null, authorities);
	                    SecurityContextHolder.getContext().setAuthentication(authentication);
	                } else {

	                }
	            } catch (Exception e) {
	                // Exceção ao validar o token
	            }
	        } else {
	            // Token não encontrado na requisição
	        }
	        filterChain.doFilter(request, response);
	    }

	    private String recoverToken(HttpServletRequest request) {
	        String authHeader = request.getHeader("Authorization");
	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
	            return authHeader.substring(7);
	        }
	        return null;
	    }
}
