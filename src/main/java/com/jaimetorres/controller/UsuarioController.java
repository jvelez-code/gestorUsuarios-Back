package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.AgenteDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.AgenteCampana;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.model.gestor.Usuarios;
import com.jaimetorres.service.gestor.IAgenteCampanaService;
import com.jaimetorres.service.gestor.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


	@Autowired
	private IUsuarioService service;
	
	@Autowired
	private IAgenteCampanaService serviceAg;
	


	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() throws Exception{
		List<Usuario> lista=service.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Usuario listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}

	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario Usuario) throws Exception{
		Usuario obj=service.registrar(Usuario);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
		return new ResponseEntity<Usuario>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Usuario> modificar(@Valid @RequestBody Usuario Usuario) throws Exception{
		Usuario obj=service.modificar(Usuario);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Usuario obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/buscar")
	public ResponseEntity<Usuario[]> buscarUsuario(@RequestBody ParametrosDTO filtro) throws Exception{
		Usuario[] obj = service.buscar(filtro);
		return new ResponseEntity<Usuario[]>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/buscarExt")
	public ResponseEntity<AgenteDTO> buscarUsuarioExt(@RequestBody ParametrosDTO filtro) throws Exception{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
		AgenteDTO obj = serviceAg.buscarCampana(filtro);
		
		return new ResponseEntity<AgenteDTO>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/buscarLogin")
	public ResponseEntity<Usuarios> buscarLogin(@RequestBody ParametrosDTO filtro) throws Exception{
		Usuarios obj = service.buscarLogin(filtro);		
		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/cerrar")
	public ResponseEntity<Void> cerrarSesion(@RequestBody ParametrosDTO filtro) throws Exception{
		
		service.cerrarSesion(filtro);
		
		return new ResponseEntity<Void>( HttpStatus.OK);
	}

}
