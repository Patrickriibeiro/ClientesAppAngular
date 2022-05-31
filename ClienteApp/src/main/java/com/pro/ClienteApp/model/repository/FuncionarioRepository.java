package com.pro.ClienteApp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.ClienteApp.model.entity.CargosEntity;
import com.pro.ClienteApp.model.entity.FuncionarioEntity;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
	
	public List<FuncionarioEntity> findByCargo(CargosEntity cargo);
	
}
