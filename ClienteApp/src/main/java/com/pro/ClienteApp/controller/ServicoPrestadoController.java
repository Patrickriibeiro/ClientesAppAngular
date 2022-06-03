package com.pro.ClienteApp.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pro.ClienteApp.controller.dto.ServicoPrestadoDTO;
import com.pro.ClienteApp.model.entity.ClienteEntity;
import com.pro.ClienteApp.model.entity.FuncionarioEntity;
import com.pro.ClienteApp.model.entity.ServicoPrestadoEntity;
import com.pro.ClienteApp.model.repository.ClienteRepository;
import com.pro.ClienteApp.model.repository.FuncionarioRepository;
import com.pro.ClienteApp.model.repository.ServicoPrestadoRepository;
import com.pro.ClienteApp.utils.BigDecimalConverter;

@RestController
@RequestMapping("/api/servico-prestado")
@CrossOrigin("http://localhost:4200/")
public class ServicoPrestadoController {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	private ServicoPrestadoRepository servicoRepo;
	
	@Autowired 
	private FuncionarioRepository funcRepo;

	@Autowired
	private BigDecimalConverter bigConverter;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestadoEntity salvar(@RequestBody @Valid ServicoPrestadoDTO dto) {

		Optional<ClienteEntity> clienteOpcional = clienteRepo.findById(dto.getIdCliente());
		
		Optional<FuncionarioEntity> funcionarioOptional = funcRepo.findById(dto.getIdFuncionario());

		ServicoPrestadoEntity servicoPrestado = new ServicoPrestadoEntity();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		servicoPrestado.setCliente(clienteOpcional
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente")));
		servicoPrestado.setValor(bigConverter.bigDecimalConverter(dto.getPreco()));
		
		servicoPrestado.setFuncionario(funcionarioOptional
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionario inexistente")));
      
		return servicoRepo.save(servicoPrestado);
	}
	
	@GetMapping()
	public List<ServicoPrestadoEntity> pesquisar(@RequestParam(value = "nome", required = false, defaultValue = "") String nome, 
			@RequestParam(value = "mes", required = false, defaultValue = "") String mes){	
	  return servicoRepo.findByNomeClienteAndMes("%" + nome + "%", Integer.parseInt(mes));
	}
	
	@GetMapping("/buscarTodos")
	public List<ServicoPrestadoEntity> buscarTodos(){
	   return servicoRepo.findAll();	
	 }
	}
