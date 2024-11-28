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

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.contact.LlamadaEntrante;
import com.jaimetorres.model.gestor.Campana;
import com.jaimetorres.service.contact.ILlamadaEntranteService;
import com.jaimetorres.service.gestor.ICampanaService;

@RestController
@RequestMapping("/campanas")
public class CampanaController {


	@Autowired
	private ICampanaService service;

	@Autowired
	private ILlamadaEntranteService serviceLlama;


	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Campana>> listar() throws Exception{
		List<Campana> lista=service.listar();
		return new ResponseEntity<List<Campana>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Campana listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<Campana> registrar(@Valid @RequestBody Campana Campana) throws Exception{
		Campana obj=service.registrar(Campana);
		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCampana()).toUri();
		return new ResponseEntity<Campana>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Campana> modificar(@Valid @RequestBody Campana Campana) throws Exception{
		Campana obj=service.modificar(Campana);
		return new ResponseEntity<Campana>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Campana obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/listarAsignacion")
	public ResponseEntity<List<Campana>> listarAsignacion(@Valid @RequestBody ParametrosDTO filtro) throws Exception{
		List<Campana> obj=service.asignarCampana(filtro);
		return new ResponseEntity<>(obj,  HttpStatus.OK);
	}




}
