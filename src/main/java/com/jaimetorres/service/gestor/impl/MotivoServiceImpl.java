package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.Motivo;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.IMotivoService;

@Service
public class MotivoServiceImpl extends CRUDImpl<Motivo, Integer> implements IMotivoService {

	@Autowired
	private IMotivoRepo repo;
	
	@Override
	protected IGenericRepo<Motivo, Integer> getRepo(){
		return repo;
	}}


