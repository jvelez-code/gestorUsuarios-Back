package com.jaimetorres.service.gestor.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.ICRUD;

public abstract class CRUDImpl<T , ID> implements ICRUD<T , ID>{
	
protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T registrar(T obj) throws Exception {
		return getRepo().save(obj);
	}

	@Override
	public T modificar(T obj) throws Exception {
		return getRepo().save(obj);
	}
		
	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}
	
	@Override
	public T listarPorId(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);		
	}
	
	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}
	
	
	}
