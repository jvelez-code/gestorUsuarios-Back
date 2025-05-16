package com.jaimetorres.service.gestor;
import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Extension;


public interface IExtensionService extends ICRUD<Extension , Integer > {
	
	Integer crearExt (Extension filtro);
	List<Extension> extEmpresa (ParametrosDTO filtro);
	Extension buscarExt (ParametrosDTO filtro);
	void removeExtension(ParametrosDTO filtro);
	void addExtension(ParametrosDTO filtro);
	
}
