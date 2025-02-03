package com.jaimetorres.repo.gestor;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.jaimetorres.model.gestor.UsuariosClaves;


public interface IUsuariosClavesRepo extends IGenericRepo<UsuariosClaves, Integer> {
	
	@Query("FROM UsuariosClaves WHERE idUsuario = :idUsuario ")
	List<UsuariosClaves> buscarClaves(@Param("idUsuario") Integer idUsuario);
	

}
