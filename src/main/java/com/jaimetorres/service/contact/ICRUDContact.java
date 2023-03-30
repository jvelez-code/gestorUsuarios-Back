package com.jaimetorres.service.contact;

import java.util.List;


public interface ICRUDContact <T , ID >{
	T registrar (T pac) throws Exception ;
	T modificar (T pac) throws Exception ;
	List<T> listar()    throws Exception ;
	T listarPorId (ID id) throws Exception ;
	void eliminar (ID id) throws Exception ;
}
