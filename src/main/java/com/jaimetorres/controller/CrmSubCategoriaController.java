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
import com.jaimetorres.model.gestor.CrmSubCategoria;
import com.jaimetorres.service.gestor.ICrmSubCategoriaService;

@RestController
@RequestMapping("/crmSubcategoria")
public class CrmSubCategoriaController {


	@Autowired
	private ICrmSubCategoriaService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmSubCategoria>> listar() throws Exception{
		List<CrmSubCategoria> lista=service.listar();
		return new ResponseEntity<List<CrmSubCategoria>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmSubCategoria listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmSubCategoria> registrar(@Valid @RequestBody CrmSubCategoria CrmCategoria2) throws Exception{
		CrmSubCategoria obj=service.registrar(CrmCategoria2);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCategoria()).toUri();
		return new ResponseEntity<CrmSubCategoria>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmSubCategoria> modificar(@Valid @RequestBody CrmSubCategoria CrmCategoria2) throws Exception{
		CrmSubCategoria obj=service.modificar(CrmCategoria2);
		return new ResponseEntity<CrmSubCategoria>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmSubCategoria obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

	@GetMapping("listarPorCat/{id}")
	public ResponseEntity<List<CrmSubCategoria>> listarPorCat(@PathVariable("id")Integer id) throws Exception{
		List<CrmSubCategoria> crmSubCategoria = new ArrayList<>();
		crmSubCategoria = service.buscarSubcateS(id);
		return new ResponseEntity<List<CrmSubCategoria>>(crmSubCategoria, HttpStatus.OK);
	}
	


}
