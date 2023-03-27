package com.jaimetorres.service.contact.impl;

import java.util.List;

import com.jaimetorres.repo.contact.IGenericContactRepo;
import com.jaimetorres.service.contact.ICRUDContact;

public abstract class CRUDContactImpl<T , ID> implements ICRUDContact<T , ID>{
	
protected abstract IGenericContactRepo<T, ID> getRepo();
	
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
