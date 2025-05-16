package com.jaimetorres.repo.gestor;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.FidelizacionComercial;


public interface IFidelizacionComercialRepo extends IGenericRepo < FidelizacionComercial, Integer > {
	
	
	@Query(" FROM FidelizacionComercial fc WHERE fc.fechaGestion between :fechaInicial and :fechaFinal ")
	List<FidelizacionComercial> buscarFidelizacionR	(@Param("fechaInicial") LocalDateTime localDateTime,@Param("fechaFinal") LocalDateTime localDateTime2);
	
}
