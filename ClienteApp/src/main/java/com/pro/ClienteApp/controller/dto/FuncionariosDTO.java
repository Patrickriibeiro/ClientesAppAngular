package com.pro.ClienteApp.controller.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class FuncionariosDTO {
	
    private Integer id;
	
	private String nomeCargo;
	
	private Integer cargoId;
		
	@NotEmpty(message = "{campo.cargo.obrigatorio}")	
	private String nome;

	@NotEmpty(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
 	private String cpf;
	
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate dataCadastro; 
	
	private List<ServicoPrestadoDTO> servicoPrestado;

}
