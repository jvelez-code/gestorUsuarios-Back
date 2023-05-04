package com.jaimetorres.repo.gestor;

import com.jaimetorres.model.gestor.Usuarios;

public interface IUsuariosRepo extends IGenericRepo<Usuarios, Integer> {
	
	Usuarios findOneByUsername(String username);	

}
