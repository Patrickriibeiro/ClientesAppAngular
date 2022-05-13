package com.pro.ClienteApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pro.ClienteApp.model.entity.FuncionarioEntity;
import com.pro.ClienteApp.model.repository.FuncionarioRepository;

@RestController
@RequestMapping(value = "/api/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@DeleteMapping("id")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletaFunc(@PathVariable("id") Integer id) {
		funcionarioRepository.findById(id).map(func -> {
			funcionarioRepository.delete(func);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
	}

	@GetMapping({"id"})
	public FuncionarioEntity buscaFunc(@PathVariable("id") Integer id) {
		return funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
	}

	@GetMapping()
	public List<FuncionarioEntity> listarTodos() {
		return funcionarioRepository.findAll();
	}
}
