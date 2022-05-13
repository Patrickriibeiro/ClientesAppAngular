package com.pro.ClienteApp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro.ClienteApp.model.entity.ServicoPrestadoEntity;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestadoEntity,Integer> {
	
	
	@Query(" select s from ServicoPrestadoEntity s join s.cliente c " +
            " where upper( c.nome ) like upper( :nome ) and MONTH(s.data) =:mes    ")
    List<ServicoPrestadoEntity> findByNomeClienteAndMes(
            @Param(value = "nome") String nome, @Param(value = "mes") Integer mes);

}
