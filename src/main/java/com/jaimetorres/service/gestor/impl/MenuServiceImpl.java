package com.jaimetorres.service.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.model.gestor.Menu;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.repo.gestor.IMenuRepo;
import com.jaimetorres.service.gestor.IMenuService;


@Service
public class MenuServiceImpl extends CRUDImpl<Menu, Integer> implements IMenuService {
	
	@Autowired
	private IMenuRepo repo;

	@Override
	protected IGenericRepo<Menu, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		/*List<Menu> menus = new ArrayList<>();
		repo.listarMenuPorUsuario(nombre).forEach(x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setIcono(String.valueOf(x[1]));
			m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));		
			
			menus.add(m);
		});
		return menus;*/
		return repo.listarMenuPorUsuario(nombre);
	}

}
