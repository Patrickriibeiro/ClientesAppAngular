package com.pro.ClienteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pro.ClienteApp.model.entity.ClienteEntity;
import com.pro.ClienteApp.model.repository.ClienteRepository;

@RestController //Tudo que retornar nesse com essa anotação será um automaticamente um responseBody.
@RequestMapping(value = "api/clientes") // Mapeamento de url base;
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping //Usado para inserir um novo dado.
	@ResponseStatus(HttpStatus.CREATED) //retorna o Status code informado na anotação. 
	public ClienteEntity salvar(@RequestBody ClienteEntity cliente) {
		return clienteRepository.save(cliente);
	}

}
