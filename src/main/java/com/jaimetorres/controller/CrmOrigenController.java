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
import com.jaimetorres.model.gestor.CrmOrigen;
import com.jaimetorres.service.gestor.ICrmOrigenService;

@RestController
@RequestMapping("/crmOrigenes")
public class CrmOrigenController {


	@Autowired
	private ICrmOrigenService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmOrigen>> listar() throws Exception{
		List<CrmOrigen> lista=service.listar();
		return new ResponseEntity<List<CrmOrigen>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmOrigen listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmOrigen> registrar(@Valid @RequestBody CrmOrigen CrmOrigen) throws Exception{
		CrmOrigen obj=service.registrar(CrmOrigen);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdOrigen()).toUri();
		return new ResponseEntity<CrmOrigen>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmOrigen> modificar(@Valid @RequestBody CrmOrigen CrmOrigen) throws Exception{
		CrmOrigen obj=service.modificar(CrmOrigen);
		return new ResponseEntity<CrmOrigen>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmOrigen obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
