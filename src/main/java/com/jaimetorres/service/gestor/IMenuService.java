package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.model.gestor.Menu;



public interface IMenuService extends ICRUD<Menu , Integer >{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
