package com.jaimetorres.service.gestor.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroContactoDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.TipoDocumento;
import com.jaimetorres.repo.gestor.IContactoRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IContactoService;

@Service
public class ContactoServiceImpl extends CRUDImpl<Contacto, Integer> implements IContactoService {

	@Autowired
	private IContactoRepo repo;
	
	@Override
	protected IGenericRepo<Contacto, Integer> getRepo(){
		return repo;
	}	

	@Override
	public Integer buscarMax(ParametrosDTO filtro) {
		
		return repo.buscarMax(filtro.getIdCliente());
	}
	
	@Override
	public Contacto buscar(Integer idContactoMax) {
		
		return repo.buscar(idContactoMax);
	}




	
	



		
}


