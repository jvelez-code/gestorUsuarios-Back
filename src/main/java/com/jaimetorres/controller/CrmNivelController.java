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
import com.jaimetorres.model.gestor.CrmNivel;
import com.jaimetorres.service.gestor.ICrmNivelService;

@RestController
@RequestMapping("/crmNiveles")
public class CrmNivelController {


	@Autowired
	private ICrmNivelService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmNivel>> listar() throws Exception{
		List<CrmNivel> lista=service.listar();
		return new ResponseEntity<List<CrmNivel>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmNivel listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmNivel> registrar(@Valid @RequestBody CrmNivel CrmNivel) throws Exception{
		CrmNivel obj=service.registrar(CrmNivel);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdNivel()).toUri();
		return new ResponseEntity<CrmNivel>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmNivel> modificar(@Valid @RequestBody CrmNivel CrmNivel) throws Exception{
		CrmNivel obj=service.modificar(CrmNivel);
		return new ResponseEntity<CrmNivel>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmNivel obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
