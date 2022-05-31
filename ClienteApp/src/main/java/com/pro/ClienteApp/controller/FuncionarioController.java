package com.pro.ClienteApp.controller;

import java.util.ArrayList;
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

import com.pro.ClienteApp.controller.dto.FuncionariosDTO;
import com.pro.ClienteApp.model.entity.CargosEntity;
import com.pro.ClienteApp.model.entity.FuncionarioEntity;
import com.pro.ClienteApp.model.repository.CargoRepository;
import com.pro.ClienteApp.model.repository.FuncionarioRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/funcionarios")
@Slf4j
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private CargoRepository cargoRepository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void salvarFuncionario(@RequestBody FuncionariosDTO func) {
	   FuncionarioEntity funcEntity = new FuncionarioEntity();
	   funcEntity.setNome(func.getNome());
	   funcEntity.setCpf(func.getCpf());
	   CargosEntity cargo = cargoRepository.findById(func.getCargo().getId()).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
	   funcEntity.setCargo(cargo);
	   funcionarioRepository.save(funcEntity);
	}

	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void alterarFuncionario(@PathVariable("id") Integer id, @RequestBody FuncionariosDTO func) {
		CargosEntity cargoEntity = cargoRepository.findById(func.getCargo().getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));

		funcionarioRepository.findById(id).map(funcRep -> {
			funcRep.setNome(func.getNome());
			funcRep.setCpf(func.getCpf());
			funcRep.setCargo(cargoEntity);
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
	public FuncionariosDTO buscaFunc(@PathVariable("id") Integer id) {
		 FuncionarioEntity vo = funcionarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
		 FuncionariosDTO dto = new FuncionariosDTO();
		 dto.setNome(vo.getNome());
		 dto.setCpf(vo.getCpf());
		 dto.setCargo(vo.getCargo());	
		 return dto;
	}

	@GetMapping()
	public List<FuncionariosDTO> listarTodos() {
		List<FuncionarioEntity> list = funcionarioRepository.findAll();
		List<FuncionariosDTO> listDto = new ArrayList<FuncionariosDTO>();
		list.forEach( x -> {	
			FuncionariosDTO dto = new FuncionariosDTO();
			dto.setNome(x.getNome());
			dto.setCpf(x.getCpf());
			dto.setCargo(x.getCargo());		
			listDto.add(dto);
		});
		return listDto;
	}
}
