package com.pro.ClienteApp.controller.dto;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoPrestadoDTO {
	
	@NotEmpty(message = "{campo.descricao.invalido}")
	private String descricao;
	
	@NotEmpty(message = "{campo.preco.invalido}")
	private String preco;
	
	@NotEmpty(message = "{campo.data.invalido}")
	private String data;
	
	@NotNull(message = "{campo.cliente.invalido}")
	private Integer idCliente;

}
