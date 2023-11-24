package com.jaimetorres.repo.gestor;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.CicloDeVida;


public interface ICicloDeVidaRepo extends IGenericRepo<CicloDeVida, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE detalle_gestion_comercial dgc SET ciclo_vida = :cicloVida WHERE id_detalle_gestion_comercial = :idDetalleComer", nativeQuery = true)
	void modificar(@Param("idDetalleComer") Integer idDetalleComer, @Param("cicloVida") Integer cicloVida);
}
