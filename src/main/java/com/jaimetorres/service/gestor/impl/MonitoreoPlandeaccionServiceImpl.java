package com.jaimetorres.service.gestor.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.MonitoreoPlandeaccion;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.IMonitoreoPlandeaccionService;

@Service
public class MonitoreoPlandeaccionServiceImpl extends CRUDImpl<MonitoreoPlandeaccion, Integer> implements IMonitoreoPlandeaccionService {

	@Autowired
	private IMonitoreoPlandeaccionRepo repo;
	
	@Override
	protected IGenericRepo<MonitoreoPlandeaccion, Integer> getRepo(){
		return repo;
	}


	
}


