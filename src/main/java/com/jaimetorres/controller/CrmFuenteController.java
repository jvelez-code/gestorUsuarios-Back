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
import com.jaimetorres.model.gestor.CrmFuente;
import com.jaimetorres.service.gestor.ICrmFuenteService;

@RestController
@RequestMapping("/crmFuentes")
public class CrmFuenteController {


	@Autowired
	private ICrmFuenteService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmFuente>> listar() throws Exception{
		List<CrmFuente> lista=service.listar();
		return new ResponseEntity<List<CrmFuente>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmFuente listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmFuente> registrar(@Valid @RequestBody CrmFuente CrmFuente) throws Exception{
		CrmFuente obj=service.registrar(CrmFuente);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdFuente()).toUri();
		return new ResponseEntity<CrmFuente>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmFuente> modificar(@Valid @RequestBody CrmFuente CrmFuente) throws Exception{
		CrmFuente obj=service.modificar(CrmFuente);
		return new ResponseEntity<CrmFuente>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmFuente obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
