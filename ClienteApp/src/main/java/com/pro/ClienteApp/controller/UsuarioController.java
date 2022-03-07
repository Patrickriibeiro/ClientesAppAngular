package com.pro.ClienteApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pro.ClienteApp.model.entity.UsuarioEntity;
import com.pro.ClienteApp.model.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository userRep;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid UsuarioEntity usuario) {
	    userRep.save(usuario);	
	}
}
