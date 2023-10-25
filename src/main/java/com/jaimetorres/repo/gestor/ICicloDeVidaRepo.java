package com.jaimetorres.repo.gestor;


import com.jaimetorres.model.gestor.CicloDeVida;


public interface ICicloDeVidaRepo extends IGenericRepo<CicloDeVida, Integer> {
	
//	@Query("FROM Cliente c WHERE c.CicloDeVida.tipoDoc= :tipoDoc AND c.nroDocumento= :nroDocumento")
//	List<Cliente> buscar(@Param("tipoDoc") String tipoDoc,@Param("nroDocumento") String nroDocumento);
//	
//	
//	@Query("FROM Cliente c WHERE c.fecha BETWEEN :fechaCliente AND :fechaSgte")
//	List<Cliente> buscarFecha(@Param("fechaCliente") LocalDateTime fechaCliente,@Param("fechaSgte") LocalDateTime fechaSgte);

}
