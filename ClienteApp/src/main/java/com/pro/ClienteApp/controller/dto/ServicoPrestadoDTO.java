package com.pro.ClienteApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoPrestadoDTO {
	
	private String descricao;
	
	private String preco;
	
	private String data;
	
	private Integer idCliente;

}
