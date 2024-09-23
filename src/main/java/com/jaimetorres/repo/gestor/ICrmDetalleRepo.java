package com.jaimetorres.repo.gestor;


import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.CrmCasos;
import com.jaimetorres.model.gestor.CrmDetalle;


public interface ICrmDetalleRepo extends IGenericRepo < CrmDetalle, Integer> {
	

	@Query(value = "SELECT id_detalle ,fecha_detalle ,observacion ,u.usuario FROM crm_detalle cd, usuario u "
			+ "WHERE cd.id_usuario = u.id_usuario AND id_caso = :IdCrmCaso ORDER BY id_detalle  DESC ", nativeQuery = true)
	List<Object[]> buscarDetalleR(@Param("IdCrmCaso") Integer IdCrmCaso );
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO crm_detalle (fecha_detalle, observacion, id_caso, id_usuario) VALUES (:fechaDetalle, :observacion, :idCrmCaso, :idUsuario)", nativeQuery = true)
	void registrar(@Param("fechaDetalle") String fechaDetalle, @Param("observacion") String observacion, @Param("idCrmCaso") Integer idCrmCaso, @Param("idUsuario") Integer idUsuario);
	
	
	
	
}
