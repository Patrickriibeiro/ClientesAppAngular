package com.pro.ClienteApp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.ClienteApp.model.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
	

}
