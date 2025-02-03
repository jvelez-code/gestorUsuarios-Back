package com.jaimetorres.service.gestor.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaimetorres.model.gestor.MonitoreoGrabaciones;
import com.jaimetorres.repo.gestor.IMonitoreoGrabacionesRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.IMonitoreoGrabacionesService;

@Service
public class MonitoreoGrabacionesServiceImpl extends CRUDImpl<MonitoreoGrabaciones, Integer> implements IMonitoreoGrabacionesService {

	@Autowired
	private IMonitoreoGrabacionesRepo repo;
	
	@Override
	protected IGenericRepo<MonitoreoGrabaciones, Integer> getRepo(){
		return repo;
	}
	
	
			
}


