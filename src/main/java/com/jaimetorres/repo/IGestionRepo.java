package com.jaimetorres.repo;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.Gestion;


public interface IGestionRepo extends IGenericRepo<Gestion, Integer> {
	
	
//	@Query("FROM Gestion g WHERE g.cliente.idCliente= :nroCliente ")
//	List<Gestion> buscar(@Param("nroCliente") Integer nroCliente);
	
	
	@Query(value="SELECT * FROM gestion WHERE id_cliente= :nroCliente ", nativeQuery = true)
	List<Gestion> buscarA(@Param("nroCliente") Integer nroCliente);
	
	

}
