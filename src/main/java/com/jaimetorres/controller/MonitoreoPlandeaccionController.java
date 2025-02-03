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
import com.jaimetorres.model.gestor.MonitoreoPlandeaccion;
import com.jaimetorres.service.gestor.IMonitoreoPlandeaccionService;

@RestController
@RequestMapping("/MonitoreoPlandeacciones")
public class MonitoreoPlandeaccionController {


	@Autowired
	private IMonitoreoPlandeaccionService service;


	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<MonitoreoPlandeaccion>> listar() throws Exception{
		List<MonitoreoPlandeaccion> lista=service.listar();
		return new ResponseEntity<List<MonitoreoPlandeaccion>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public MonitoreoPlandeaccion listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<MonitoreoPlandeaccion> registrar(@Valid @RequestBody MonitoreoPlandeaccion MonitoreoPlandeaccion) throws Exception{
		MonitoreoPlandeaccion obj=service.registrar(MonitoreoPlandeaccion);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPlan()).toUri();
		return new ResponseEntity<MonitoreoPlandeaccion>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<MonitoreoPlandeaccion> modificar(@Valid @RequestBody MonitoreoPlandeaccion MonitoreoPlandeaccion) throws Exception{
		MonitoreoPlandeaccion obj=service.modificar(MonitoreoPlandeaccion);
		return new ResponseEntity<MonitoreoPlandeaccion>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		MonitoreoPlandeaccion obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}



}
