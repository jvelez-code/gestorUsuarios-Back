package com.jaimetorres.service.gestor.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
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

	@Override
	public Usuarios listarUsuarios(ParametrosDTO filtro) {
		Usuarios usuario = repo.usuariosCalidad(filtro.getLoginAgente());
		if (usuario == null) {
			Usuarios nuevoUsuario = new Usuarios();
			nuevoUsuario.setEmail("notiene@notiene.com");
			return nuevoUsuario;		
		}
		
		return usuario;
	}

	@Override
	public List<Usuarios> listarEmpresa(ParametrosDTO filtro) {
		return repo.usuariosEmpresa(filtro.getIdEmpresa());
	}

	@Override
	public Usuarios validarUsuarios(ParametrosDTO filtro) {
		Usuarios usu =  repo.findOneByUsername(filtro.getLoginAgente());
		Usuarios usua =  repo.findOneByEmail(filtro.getEmail());
		if (usu != null) {
			return usu;
		} else if (usua != null) {
			return usua;
		}
		return usu;
	}



}
