package com.jaimetorres.service.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Extension;
import com.jaimetorres.repo.gestor.IExtensionRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.IExtensionService;


@Service
public class ExtensionServiceImpl extends CRUDImpl<Extension, Integer> implements IExtensionService {

	@Autowired
	private IExtensionRepo repo;

	@Override
	protected IGenericRepo<Extension, Integer> getRepo(){
		return repo;
	}

	@Override
	public Integer crearExt(Extension filtro) {
		Extension ext = repo.findByid(filtro.getExtension());
		if( ext == null){ 
			ext = new Extension();
			ext.setExtension(filtro.getExtension());
			ext.setFechaestado(filtro.getFechaestado());
			ext.setDuracionultimoestado(filtro.getDuracionultimoestado());
			ext.setDisponible(filtro.getDisponible());
			ext.setEmpresa(filtro.getEmpresa());
			repo.save(ext);
			return 1;
		}
		return 2;
	}

	@Override
	public List<Extension> extEmpresa(ParametrosDTO filtro) {
		return repo.buscarEmpresa(filtro.getIdEmpresa());
	}

	@Override
	public Extension buscarExt(ParametrosDTO filtro) {
		return repo.findByid(filtro.getExtension());
	}


	@Override
	public void removeExtension(ParametrosDTO filtro) {
		repo.actuaExtension(filtro.getExtension());
	}

	@Override
	public void addExtension(ParametrosDTO filtro) {
		repo.asignarExtension(filtro.getIdUsuario(), filtro.getExtension());
	}
	
	

	}


