package com.jaimetorres.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.DetalleGestion;


public interface IDetalleGestionRepo extends IGenericRepo<DetalleGestion, Integer> {
	
	
		
	@Query("SELECT  dg FROM DetalleGestion dg "
			+ "INNER JOIN FETCH dg.usuario "
			+ "INNER JOIN FETCH dg.gestion g "
			+ "INNER JOIN FETCH dg.estadoGestion es "
			+ "LEFT JOIN FETCH es.estadoGestionPadre "
			+ "INNER JOIN FETCH g.cliente cl "
			+ "INNER JOIN FETCH g.campana c "
			+ "INNER JOIN FETCH c.tipoCampana "
			+ "where cl.idCliente= :nroCliente "
			+ "ORDER BY dg.fechaGestion desc ")
	List<DetalleGestion> buscar(@Param("nroCliente") Integer nroCliente);
	
	
	
	
	@Query(value = "SELECT *  FROM  detalle_gestion  d where d.id_gestion= '1253365'",  nativeQuery = true)
	List<DetalleGestion> buscaR(@Param("nroCliente") Integer nroCliente);

	
}
