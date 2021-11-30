package com.pro.ClienteApp.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ServicoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@ManyToOne // relacionamento de muitos para um.
	@JoinColumn(name = "id_cliente") // Define campo de forest key.
	private ClienteEntity cliente;
	
	@Column // se não passar um value com nome da coluna, a coluna receberá o nome da variavel.
	private BigDecimal valor;

}
