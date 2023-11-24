package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.FidelizacionComercial;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.repo.gestor.IFidelizacionComercialRepo;
import com.jaimetorres.service.gestor.IFidelizacionComercialService;

@RestController
@RequestMapping("/fidelizacionComerciales")

public class FidelizacionComercialController {


	@Autowired
	private IFidelizacionComercialService service;
	

	@GetMapping
	public ResponseEntity<List<FidelizacionComercial>> listar() throws Exception{
		List<FidelizacionComercial> lista=service.listar();
		return new ResponseEntity<List<FidelizacionComercial>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public FidelizacionComercial listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<FidelizacionComercial> registrar(@Valid @RequestBody FidelizacionComercial FidelizacionComercial) throws Exception{
		FidelizacionComercial obj=service.registrar(FidelizacionComercial);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdFidelizacion()).toUri();
		return new ResponseEntity<FidelizacionComercial>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<FidelizacionComercial> modificar(@Valid @RequestBody FidelizacionComercial FidelizacionComercial) throws Exception{
		FidelizacionComercial obj=service.modificar(FidelizacionComercial);
		return new ResponseEntity<FidelizacionComercial>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		FidelizacionComercial obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/buscar")
	public ResponseEntity<List<FidelizacionComercial>> listarFidelizacion(@RequestBody ParametrosDTO filtro) throws Exception{
		List<FidelizacionComercial> lista=service.buscarFidelizacionS(filtro);
		return new ResponseEntity<List<FidelizacionComercial>>(lista, HttpStatus.OK);
	}



}
