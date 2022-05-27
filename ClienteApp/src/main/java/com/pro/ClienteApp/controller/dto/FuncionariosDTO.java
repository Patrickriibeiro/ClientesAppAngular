package com.pro.ClienteApp.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.pro.ClienteApp.model.entity.CargosEntity;
import com.pro.ClienteApp.model.entity.ServicoPrestadoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class FuncionariosDTO {
	
	private String nome;

	private String cpf;

	private CargosEntity cargo;
	
	private List<ServicoPrestadoEntity> servicoPrestado;

}
