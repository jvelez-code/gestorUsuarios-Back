package com.jaimetorres.service.gestor.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.AgenteDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Archivo;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IArchivoService;

@Service
public class ArchivoServiceImpl extends CRUDImpl<Archivo, Integer> implements IArchivoService {

	@Autowired
	private IArchivoRepo repo;
	
	@Override
	protected IGenericRepo<Archivo, Integer> getRepo(){
		return repo;
	}

//	@Override
//	public Archivo buscarArchivo(String filtro) {
//		Archivo count = repo.countByNombreArchivo(filtro);
//		return count;
//	}

	
}


