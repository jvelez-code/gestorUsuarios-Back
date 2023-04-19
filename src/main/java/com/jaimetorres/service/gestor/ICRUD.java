package com.jaimetorres.service.gestor;

import java.util.List;

public interface ICRUD <T , ID >{
	T registrar (T pac) throws Exception ;
	T modificar (T pac) throws Exception ;
	List<T> listar()    throws Exception ;
	T listarPorId (ID id) throws Exception ;
	void eliminar (ID id) throws Exception ;
}
