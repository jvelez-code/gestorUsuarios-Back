package com.jaimetorres.service.contact.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.model.contact.AskEstado;
import com.jaimetorres.repo.contact.IAskEstadoRepo;
import com.jaimetorres.repo.contact.IGenericContactRepo;
import com.jaimetorres.service.contact.IAskEstadoService;


@Service
public class askEstadoServiceImpl extends CRUDContactImpl<AskEstado, Integer> implements IAskEstadoService {

	@Autowired
	private IAskEstadoRepo repo;

	@Override
	protected IGenericContactRepo<AskEstado, Integer> getRepo() {
				return repo;
	}

	@Override
	public List<AskEstado> buscar() {
		return repo.buscar();
	}

	}
