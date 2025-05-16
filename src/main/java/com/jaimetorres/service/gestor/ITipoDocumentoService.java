package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.model.gestor.TipoDocumento;


public interface ITipoDocumentoService {
	
    TipoDocumento registrar (TipoDocumento pac) throws Exception ;
	TipoDocumento modificar (TipoDocumento pac) throws Exception ;
	List<TipoDocumento> listar()    throws Exception ;
	TipoDocumento listarPorId (String id) throws Exception ;
	void eliminar (String id) throws Exception ;
}
