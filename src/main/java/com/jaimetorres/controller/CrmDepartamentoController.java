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
import com.jaimetorres.model.gestor.CrmDepartamento;
import com.jaimetorres.service.gestor.ICrmDepartamentoService;

@RestController
@RequestMapping("/crmDepartamentos")
public class CrmDepartamentoController {


	@Autowired
	private ICrmDepartamentoService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmDepartamento>> listar() throws Exception{
		List<CrmDepartamento> lista=service.listar();
		return new ResponseEntity<List<CrmDepartamento>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmDepartamento listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmDepartamento> registrar(@Valid @RequestBody CrmDepartamento CrmDepartamento) throws Exception{
		CrmDepartamento obj=service.registrar(CrmDepartamento);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDepartamento()).toUri();
		return new ResponseEntity<CrmDepartamento>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmDepartamento> modificar(@Valid @RequestBody CrmDepartamento CrmDepartamento) throws Exception{
		CrmDepartamento obj=service.modificar(CrmDepartamento);
		return new ResponseEntity<CrmDepartamento>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmDepartamento obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
