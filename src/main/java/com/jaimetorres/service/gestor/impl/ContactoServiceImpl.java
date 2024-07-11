package com.jaimetorres.service.gestor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.repo.gestor.IContactoRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
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

	@Override
	public Contacto gestionSaliente (ParametrosDTO filtro) {
		
		return repo.buscarIdCont(filtro.getIdGestion());
	}

	
	@Override
	public Contacto actualizarContacto(Integer id, Contacto contacto) {
		    Contacto contac = repo.findById(id).orElse(null);
        if (contac != null) {
        	
            // Actualizar el campo específico del contacto        	
        	contac.setNombre(contacto.getNombre());
        	contac.setCorreoElectronico(contacto.getCorreoElectronico());
        	contac.setTelefonoDirecto(contacto.getTelefonoDirecto());
        	contac.setNumeroContacto(contacto.getNumeroContacto());
        	contac.setTelefonoCelular(contacto.getTelefonoCelular());        	
        	return repo.save(contac);
        } else {
            // Manejar el caso cuando el contacto no existe
            throw new RuntimeException("El contacto con ID " + id + " no existe");
        }
		
		
	}


	
		
}


