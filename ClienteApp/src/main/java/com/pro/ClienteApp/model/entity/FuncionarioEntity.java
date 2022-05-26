package com.pro.ClienteApp.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 60)
	private String nome;

	@Column(nullable = false, length = 11)
	@NotNull(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private CargosEntity cargo;
	
	@ManyToMany
	@JoinColumn(name = "id_servico")
	private List<ServicoPrestadoEntity> servicoPrestado;
	
	 @Column(name = "data_cadastro", updatable = false) //updatable não permite que esse campo seja atualizado. 
	 @JsonFormat(pattern =  "dd/MM/yyyy")//Formata o retorno do json em data br.
     private LocalDate dataCadastro;
	 
	 @PrePersist  //Quando esse entidade for persistida no bando de dados ele executara esse metodo.
	   public void prePersist() {
		 setDataCadastro(LocalDate.now());
	 }
     

}
