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
import com.jaimetorres.model.gestor.Usuarios;
import com.jaimetorres.service.gestor.IAgenteCampanaService;
import com.jaimetorres.service.gestor.IUsuarioMigraService;

@RestController
@RequestMapping("/UsuariosMigra")
public class UsuariosController {


	@Autowired
	private IUsuarioMigraService service;


	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Usuarios>> listar() throws Exception{
		List<Usuarios> lista=service.listar();
		return new ResponseEntity<List<Usuarios>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Usuarios listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}

	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<Usuarios> registrar(@Valid @RequestBody Usuarios Usuarios) throws Exception{
		Usuarios obj=service.registrar(Usuarios);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
		return new ResponseEntity<Usuarios>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Usuarios> modificar(@Valid @RequestBody Usuarios Usuarios) throws Exception{
		Usuarios obj=service.modificar(Usuarios);
		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Usuarios obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/ultimoLogin")
	public ResponseEntity<Void> ultimoLogin(@RequestBody ParametrosDTO filtro) throws Exception {	
		service.ultimoLoginS(filtro);		
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
	

}
