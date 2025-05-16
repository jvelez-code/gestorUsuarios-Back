package com.jaimetorres.service.gestor;


import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Usuarios;

public interface IUsuarioMigraService extends ICRUD < Usuarios, Integer > {
	
	//ÚLTIMO LOGUEO
	void ultimoLoginS(ParametrosDTO filtro);
	
	Usuarios listarUsuarios(ParametrosDTO filtro);
	
	List<Usuarios> listarEmpresa(ParametrosDTO filtro);

	Usuarios validarUsuarios(ParametrosDTO filtro);


	

}
