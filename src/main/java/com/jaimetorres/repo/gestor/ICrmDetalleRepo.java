package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.CrmCasos;
import com.jaimetorres.model.gestor.CrmDetalle;


public interface ICrmDetalleRepo extends IGenericRepo < CrmDetalle, Integer> {
	

	@Query("FROM CrmDetalle d JOIN d.crmCasos c WHERE c.idCaso= :IdCrmCaso ORDER BY d.fechaDetalle DESC")
	List<CrmDetalle> buscarDetalleR(@Param("IdCrmCaso") Integer IdCrmCaso );
	
}
