package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.DetalleGestion;


public interface IDetalleGestionRepo extends IGenericRepo<DetalleGestion, Integer> {
	
	
	@Query("SELECT  dg FROM DetalleGestion dg "
			+ "LEFT JOIN FETCH dg.usuario "
			+ "LEFT JOIN FETCH dg.gestion g "
			+ "LEFT JOIN FETCH dg.estadoGestion es "
			+ "LEFT JOIN FETCH es.estadoGestionPadre "
//			+ "LEFT JOIN FETCH g.cliente cl "
//			+ "LEFT JOIN FETCH g.campana c "
//			+ "LEFT JOIN FETCH c.tipoCampana "
			//+ "WHERE cl.idCliente= :nroCliente "
			+ "where dg.idDetalleGestion= :nroCliente "
			+ "ORDER BY dg.fechaGestion desc ")
	List<DetalleGestion> buscar(@Param("nroCliente") Integer nroCliente);
	
	@Query("SELECT  dg FROM DetalleGestion dg "
			+ "where dg.idDetalleGestion= :nroCliente "
			+ "ORDER BY dg.fechaGestion desc ")
	Page<DetalleGestion> buscarM(@Param("nroCliente") Integer nroCliente, Pageable pageable);
	
	@Query("SELECT  dg FROM DetalleGestion dg "
			+ "LEFT JOIN FETCH dg.gestion g "
			+ "LEFT JOIN FETCH g.cliente cl "
			+ "WHERE cl.idCliente= :nroCliente "
			+ "ORDER BY dg.fechaGestion desc ")
	List<DetalleGestion> buscarMAi(@Param("nroCliente") Integer nroCliente);
	
	@Query(value="select observacion from detalle_gestion where id_gestion in (select ID_GESTION from gestion WHERE id_cliente= :nroCliente )", nativeQuery = true)
	List<DetalleGestion> buscarMA(@Param("nroCliente") Integer nroCliente);
	

	//@Modifying
	@Query(value = "SELECT dg.id_detalle_gestion AS idDetalleGestion FROM detalle_gestion dg WHERE dg.id_gestion='14591811'", nativeQuery  = true )
	DetalleGestion buscaR(@Param("nroCliente") Integer nroCliente);


	
}
