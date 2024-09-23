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

import com.jaimetorres.dto.FiltroCrmDetallesDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.CrmCategoria;
import com.jaimetorres.service.gestor.ICrmCategoriaService;

@RestController
@RequestMapping("/crmCategorias")
public class CrmCategoriaController {


	@Autowired
	private ICrmCategoriaService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmCategoria>> listar() throws Exception{
		List<CrmCategoria> lista=service.listar();
		return new ResponseEntity<List<CrmCategoria>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmCategoria listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmCategoria> registrar(@Valid @RequestBody CrmCategoria CrmCategoria1) throws Exception{
		CrmCategoria obj=service.registrar(CrmCategoria1);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCategoria()).toUri();
		return new ResponseEntity<CrmCategoria>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmCategoria> modificar(@Valid @RequestBody CrmCategoria CrmCategoria1) throws Exception{
		CrmCategoria obj=service.modificar(CrmCategoria1);
		return new ResponseEntity<CrmCategoria>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmCategoria obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
