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
	


	
}
