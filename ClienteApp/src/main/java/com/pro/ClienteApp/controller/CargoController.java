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

import com.pro.ClienteApp.model.entity.CargosEntity;
import com.pro.ClienteApp.model.repository.CargoRepository;

@RestController
@RequestMapping("api/cargo")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void criarCargo(@RequestBody CargosEntity cargo) {
		cargoRepository.save(cargo);
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CargosEntity buscaCargo(@PathVariable("id") Integer id) {
		return cargoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void alterarCargo(@PathVariable("id") Integer id, @RequestBody CargosEntity cargo) {
		cargoRepository.findById(id).map(cargoVO -> {
			cargoVO.setNome(cargo.getNome());
			cargoVO.setSalario(cargo.getSalario());
			return cargoRepository.save(cargoVO);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<CargosEntity> buscaTodosCargos() {
		return cargoRepository.findAll();
	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deletarCargo(@PathVariable("id") Integer id) {
		cargoRepository.deleteById(id);
	}
}