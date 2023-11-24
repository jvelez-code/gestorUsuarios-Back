package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.GestionComercialDto;

import com.jaimetorres.exception.ModeloNotFoundException;

import com.jaimetorres.model.gestor.DetalleGestionComercial;

import com.jaimetorres.service.gestor.IDetalleGestionComercialService;

@RestController
@RequestMapping("/gestionesComerciales")
public class DetalleGestionComercialController {


	@Autowired
	private IDetalleGestionComercialService service;
	
		

	@GetMapping
	public ResponseEntity<List<DetalleGestionComercial>> listar() throws Exception{
		List<DetalleGestionComercial> lista=service.listar();
		return new ResponseEntity<List<DetalleGestionComercial>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public DetalleGestionComercial listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}

	
	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<DetalleGestionComercial> registrar(@Valid @RequestBody DetalleGestionComercial DetalleGestionComercial) throws Exception{
		DetalleGestionComercial obj=service.registrar(DetalleGestionComercial);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDetalleGestionComercial()).toUri();
		return new ResponseEntity<DetalleGestionComercial>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<DetalleGestionComercial> modificar(@Valid @RequestBody DetalleGestionComercial DetalleGestionComercial) throws Exception{
		DetalleGestionComercial obj=service.modificar(DetalleGestionComercial);
		return new ResponseEntity<DetalleGestionComercial>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		DetalleGestionComercial obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/gestionComercial")
	public ResponseEntity<List<GestionComercialDto>> buscarClienteId(@RequestBody ParametrosDTO filtro) throws Exception{
		List<GestionComercialDto> gestion = new ArrayList<>();
		gestion = service.buscarGC(filtro);
		return new ResponseEntity<List<GestionComercialDto>>(gestion, HttpStatus.OK);
	}

			}
