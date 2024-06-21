package com.jaimetorres.service.gestor.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.TipoDocumento;
import com.jaimetorres.model.gestor.Usuarios;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.repo.gestor.IUsuariosRepo;
import com.jaimetorres.service.gestor.IUsuarioMigraService;

@Service
public class UsuariosServiceImpl extends CRUDImpl<Usuarios, Integer> implements UserDetailsService, IUsuarioMigraService {
	
	@Autowired
	private IUsuariosRepo repo;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuarios usuarios = repo.findOneByUsername(username);
		
		if(usuarios == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		usuarios.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails ud = new User(usuarios.getUsername(), usuarios.getPassword(), roles);
		
		return ud;
	}

	@Override
	protected IGenericRepo<Usuarios, Integer> getRepo() {
		return repo;
	}

	@Override
	public void ultimoLoginS(ParametrosDTO filtro) {
		repo.ultimoLoginR(filtro.getLoginAgente(),filtro.getUltimoLogin());
		
	}


}
