package com.pro.ClienteApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pro.ClienteApp.model.entity.ClienteEntity;
import com.pro.ClienteApp.model.repository.ClienteRepository;

@RestController // Tudo que retornar com essa anotação será um automaticamente um
				// responseBody.
@RequestMapping(value = "api/clientes") // Mapeamento de url base;
@CrossOrigin("http://localhost:4200/")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping // Usado para inserir um novo dado.
	@ResponseStatus(code = HttpStatus.CREATED) // retorna o Status code informado na anotação. @Valid serve para validar o campos da entidade na requisição Rest inves de ser na hora da persistencia.
	public ClienteEntity salvar(@RequestBody @Valid ClienteEntity cliente)  {
		return clienteRepository.save(cliente);
	}

	@GetMapping(value = "{id}")
	public ClienteEntity acharPorId(@PathVariable(name = "id") Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
	}
	
	@GetMapping
	public List<ClienteEntity> listarTodos(){
		return clienteRepository.findAll();
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable(name = "id") Integer id) {
		clienteRepository.findById(id).map(cliente -> {
			clienteRepository.delete(cliente);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
	}

	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT) // "reason" Use somente não tiver algum retorno no metodo https.
	public void atualizar(@PathVariable(value = "id") Integer id, @RequestBody @Valid ClienteEntity clienteAtualizado) {
		clienteRepository.findById(id).map(cliente -> {
			cliente.setNome(clienteAtualizado.getNome());
			cliente.setCpf(clienteAtualizado.getCpf());
			return clienteRepository.save(clienteAtualizado);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
	}
	
	

}
