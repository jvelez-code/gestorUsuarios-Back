package com.jaimetorres.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Rol;
import com.jaimetorres.service.gestor.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {


	@Autowired
	private IRolService service;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar() throws Exception{
		List<Rol> lista=service.listar();
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Rol listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}

	@PostMapping
	public ResponseEntity<Rol> registrar(@Valid @RequestBody Rol Rol) throws Exception{
		Rol obj=service.registrar(Rol);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRol()).toUri();
		return new ResponseEntity<Rol>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Rol> modificar(@Valid @RequestBody Rol Rol) throws Exception{
		Rol obj=service.modificar(Rol);
		return new ResponseEntity<Rol>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Rol obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
