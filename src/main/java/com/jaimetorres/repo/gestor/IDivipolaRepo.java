package com.jaimetorres.repo.gestor;


import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.Divipola;
import com.jaimetorres.model.gestor.Usuario;

public interface IDivipolaRepo extends IGenericRepo<Divipola, Integer> {
	

	@Query(value="SELECT  d.id_zona,d.nombre,concat('  (',di.nombre,')') as departamento "
			+ "FROM  divipola d , divipola di "
			+ "WHERE d.id_zona_padre =di.id_zona "
			+ "ORDER by d.nombre", nativeQuery = true)
	List<Object[]> buscar();
	
	@Query("SELECT d FROM Divipola d WHERE d.nombre = :nombre")
   List<Divipola> findByNombre(@Param("nombre") String nombre);

}
