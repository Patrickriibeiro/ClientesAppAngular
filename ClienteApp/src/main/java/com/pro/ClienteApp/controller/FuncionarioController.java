package com.pro.ClienteApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.pro.ClienteApp.model.entity.FuncionarioEntity;
import com.pro.ClienteApp.model.entity.ServicoPrestadoEntity;
import com.pro.ClienteApp.model.repository.FuncionarioRepository;

@RestController
@RequestMapping(value = "/api/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void salvarFuncionario(@RequestBody FuncionarioEntity func) {
		funcionarioRepository.save(func);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void alterarFuncionario(@PathVariable("id") Integer id, @RequestBody FuncionarioEntity func) {
		funcionarioRepository.findById(id).map( funcRep -> {
			funcRep.setNome(func.getNome());
			funcRep.setCpf(func.getCpf());
			funcRep.setCargo(func.getCargo());
			return funcionarioRepository.save(funcRep);
		});
	}
	
	@PostMapping("/inserir/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void inserirCargo(@PathVariable("id") Integer id,@RequestBody ServicoPrestadoEntity servicoPrestado) {
	      funcionarioRepository.findById(id).map( funcRep -> {
	    	 funcRep.getServicoPrestado().add(servicoPrestado);
	    	 return funcionarioRepository.save(funcRep);
	      }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
	}

	@DeleteMapping("id")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletaFunc(@PathVariable("id") Integer id) {
		funcionarioRepository.findById(id).map(func -> {
			funcionarioRepository.delete(func);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
	}

	@GetMapping({ "id" })
	public FuncionarioEntity buscaFunc(@PathVariable("id") Integer id) {
		return funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
	}

	@GetMapping()
	public List<FuncionarioEntity> listarTodos() {
		return funcionarioRepository.findAll();
	}
}
