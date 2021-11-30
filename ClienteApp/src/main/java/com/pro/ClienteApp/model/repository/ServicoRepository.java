package com.pro.ClienteApp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.ClienteApp.model.entity.ServicoEntity;

public interface ServicoRepository extends JpaRepository<ServicoEntity,Integer > {

}
