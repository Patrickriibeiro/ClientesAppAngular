package com.pro.ClienteApp.model.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
	
    @OneToMany
    @JoinColumn(name = "id_funcionario")
    private List<FuncionarioEntity> funcionarioEntity;
	
}
