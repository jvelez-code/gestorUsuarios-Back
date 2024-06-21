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
import com.jaimetorres.model.gestor.CrmEstado;
import com.jaimetorres.service.gestor.ICrmEstadoService;

@RestController
@RequestMapping("/crmEstados")
public class CrmEstadoController {


	@Autowired
	private ICrmEstadoService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmEstado>> listar() throws Exception{
		List<CrmEstado> lista=service.listar();
		return new ResponseEntity<List<CrmEstado>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmEstado listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmEstado> registrar(@Valid @RequestBody CrmEstado CrmEstado) throws Exception{
		CrmEstado obj=service.registrar(CrmEstado);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEstado()).toUri();
		return new ResponseEntity<CrmEstado>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmEstado> modificar(@Valid @RequestBody CrmEstado CrmEstado) throws Exception{
		CrmEstado obj=service.modificar(CrmEstado);
		return new ResponseEntity<CrmEstado>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmEstado obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
