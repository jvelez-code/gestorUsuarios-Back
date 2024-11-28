package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.MonitoreoGrabaciones;
import com.jaimetorres.service.gestor.IMonitoreoGrabacionesService;

@RestController
@RequestMapping("/MonitoreoGrabaciones")
public class MonitoreoGrabacionesController {


	@Autowired
	private IMonitoreoGrabacionesService service;


	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<MonitoreoGrabaciones>> listar() throws Exception{
		List<MonitoreoGrabaciones> lista=service.listar();
		return new ResponseEntity<List<MonitoreoGrabaciones>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public MonitoreoGrabaciones listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<MonitoreoGrabaciones> registrar(@Valid @RequestBody MonitoreoGrabaciones MonitoreoGrabaciones) throws Exception{
		MonitoreoGrabaciones obj=service.registrar(MonitoreoGrabaciones);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMonitoreo()).toUri();
		return new ResponseEntity<MonitoreoGrabaciones>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<MonitoreoGrabaciones> modificar(@Valid @RequestBody MonitoreoGrabaciones MonitoreoGrabaciones) throws Exception{
		MonitoreoGrabaciones obj=service.modificar(MonitoreoGrabaciones);
		return new ResponseEntity<MonitoreoGrabaciones>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		MonitoreoGrabaciones obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}



}
