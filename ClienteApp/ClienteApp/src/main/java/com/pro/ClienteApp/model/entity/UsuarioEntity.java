package com.pro.ClienteApp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, name = "usuario")
	@NotEmpty(message = "{campo.usuario.invalido}")
	private String usuario;
	
	@Column(name = "senha")
	@NotEmpty(message = "{campo.password.invalido}")
	private String password;

}
