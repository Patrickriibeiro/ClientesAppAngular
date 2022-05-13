package com.pro.ClienteApp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.ClienteApp.model.entity.ClienteEntity;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {
	
}
