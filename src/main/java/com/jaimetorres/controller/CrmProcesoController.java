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
import com.jaimetorres.model.gestor.CrmProceso;
import com.jaimetorres.service.gestor.ICrmProcesoService;

@RestController
@RequestMapping("/crmProcesos")
public class CrmProcesoController {


	@Autowired
	private ICrmProcesoService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmProceso>> listar() throws Exception{
		List<CrmProceso> lista=service.listar();
		return new ResponseEntity<List<CrmProceso>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmProceso listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmProceso> registrar(@Valid @RequestBody CrmProceso CrmProceso) throws Exception{
		CrmProceso obj=service.registrar(CrmProceso);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getidProceso()).toUri();
		return new ResponseEntity<CrmProceso>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmProceso> modificar(@Valid @RequestBody CrmProceso CrmProceso) throws Exception{
		CrmProceso obj=service.modificar(CrmProceso);
		return new ResponseEntity<CrmProceso>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmProceso obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
