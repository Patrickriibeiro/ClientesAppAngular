package com.pro.ClienteApp.controller.dto;

import java.math.BigDecimal;
import java.util.List;

import com.pro.ClienteApp.model.entity.FuncionarioEntity;

import lombok.Data;

@Data
public class CargoDTO {

	private Integer id;
		
	private String nome;
	
	private BigDecimal salario;
	
    private List<FuncionarioEntity> funcionarioEntity;
	
	
}
