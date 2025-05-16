package com.jaimetorres.service.gestor.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaimetorres.model.gestor.CompromisoComercial;
import com.jaimetorres.repo.gestor.ICompromisoComercialRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.ICompromisoComercialService;

@Service
public class CompromisoComercialServiceImpl extends CRUDImpl<CompromisoComercial, Integer> implements ICompromisoComercialService {

	@Autowired
	private ICompromisoComercialRepo repo;
	
	@Override
	protected IGenericRepo<CompromisoComercial, Integer> getRepo(){
		return repo;
	}


			
}


