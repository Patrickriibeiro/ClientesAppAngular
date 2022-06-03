package com.pro.ClienteApp.controller.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class CargoDTO {

	private Integer id;
		
	private String nome;
	
	private BigDecimal salario;
	
    private List<FuncionariosDTO> funcionarioDto;
	
	
}
