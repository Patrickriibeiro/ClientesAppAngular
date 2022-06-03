package com.pro.ClienteApp.controller.dto;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ServicoPrestadoDTO {
	
	private String clienteNome;
	
	@NotEmpty(message = "{campo.descricao.invalido}")
	private String descricao;
	
	@NotEmpty(message = "{campo.preco.invalido}")
	private String preco;
	
	@NotEmpty(message = "{campo.data.invalido}")
	private String data;
	
	@NotNull(message = "{campo.cliente.invalido}")
	private Integer idCliente;
	
	@NotNull(message = "{campo.cliente.invalido}")
	private Integer idFuncionario;
	
}
