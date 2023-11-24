package com.jaimetorres.repo.gestor;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.FidelizacionComercial;


public interface IFidelizacionComercialRepo extends IGenericRepo < FidelizacionComercial, Integer > {
	
	
	@Query(" FROM FidelizacionComercial fc WHERE fc.fechaGestion between :fechaInicial and :fechaFinal ")
	List<FidelizacionComercial> buscarFidelizacionR	(@Param("fechaInicial") Date fechaInicial,@Param("fechaFinal") Date fechaFinal);
	
}
