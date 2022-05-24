package com.pro.ClienteApp.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class CargosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@NotNull(message = "{campo.cargo.obrigatorio}")
	@Column(nullable = false, length = 40)
	private String nome;
	
	@NotNull(message = "{campo.salario.obrigatorio}")
	@Column(nullable = false)
	private BigDecimal salario;
	
}
