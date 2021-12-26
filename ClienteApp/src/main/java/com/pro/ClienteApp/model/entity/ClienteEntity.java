package com.pro.ClienteApp.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

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
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
	
	 @Column(nullable = false, length = 150)
     private String nome;
	 
	 @Column(nullable = false, length = 11)
     private String cpf;
	 
	 @Column(name = "data_cadastro")
	 @JsonFormat(pattern =  "dd/MM/yyyy")
     private LocalDate dataCadastro;
	 
	 @PrePersist  //Quando esse entidade for persistida no bando de dados ele executara esse metodo.
	   public void prePersist() {
		 setDataCadastro(LocalDate.now());
	 }
     
}
