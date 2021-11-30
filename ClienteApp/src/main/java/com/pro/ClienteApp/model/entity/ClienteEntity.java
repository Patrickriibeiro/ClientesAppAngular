package com.pro.ClienteApp.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
	
	 @Column(nullable = false, length = 150)
     private String nome;
	 
	 @Column(nullable = false, length = 11)
     private String cpf;
	 
	 @Column(name = "data_cadastro")
     private LocalDate dataCadastro;
     
}
