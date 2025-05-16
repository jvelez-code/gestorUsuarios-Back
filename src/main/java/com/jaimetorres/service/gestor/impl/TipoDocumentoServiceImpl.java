package com.jaimetorres.service.gestor.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.jaimetorres.model.gestor.TipoDocumento;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ITipoDocumentoService;


@Service
public class TipoDocumentoServiceImpl  implements ITipoDocumentoService {

	@Autowired
	private ITipoDocumentoRepo repo;
	

	@Override
	public TipoDocumento registrar(TipoDocumento cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public TipoDocumento modificar(TipoDocumento cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public List<TipoDocumento> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public TipoDocumento listarPorId(String id) throws Exception {
		//Opotional java 8 para capturar los null point exception
		Optional<TipoDocumento> op = repo.findById(id);
		return op.isPresent() ? op.get() : new TipoDocumento();
	}

	@Override
	public void eliminar(String id) throws Exception {
		repo.deleteById(id);
		
	}
	



		
}


