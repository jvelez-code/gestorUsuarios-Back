package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.CrmDetalle;
import com.jaimetorres.model.gestor.Festivo;
import com.jaimetorres.service.gestor.IFestivoService;

@RestController
@RequestMapping("/festivos")
public class FestivoController {


	@Autowired
	private IFestivoService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<Festivo>> listar() throws Exception{
		List<Festivo> lista=service.listar();
		return new ResponseEntity<List<Festivo>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Festivo listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<Festivo> registrar(@Valid @RequestBody Festivo CrmCategoria2) throws Exception{
		Festivo obj=service.registrar(CrmCategoria2);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getFecha()).toUri();
		return new ResponseEntity<Festivo>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Festivo> modificar(@Valid @RequestBody Festivo CrmCategoria2) throws Exception{
		Festivo obj=service.modificar(CrmCategoria2);
		return new ResponseEntity<Festivo>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Festivo obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	



}
