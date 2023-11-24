package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.Gestion;


public interface IGestionRepo extends IGenericRepo<Gestion, Integer> {



	@Query("FROM Gestion g WHERE g.idGestion= :nroCliente ORDER BY g.idGestion DESC")
	Gestion buscarM (@Param("nroCliente") Integer nroCliente);


	@Query(value="SELECT * FROM gestion WHERE id_cliente= :nroCliente ", nativeQuery = true)
	List<Gestion> buscarA(@Param("nroCliente") Integer nroCliente);



}