package com.jaimetorres.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Archivo;
import com.jaimetorres.service.gestor.IArchivoService;

@RestController
@RequestMapping("/archivos")
public class ArchivoController {


	@Autowired
	private IArchivoService service;


	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Archivo>> listar() throws Exception{
		List<Archivo> lista=service.listar();
		return new ResponseEntity<List<Archivo>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Archivo listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<Archivo> registrar(@Valid @RequestBody Archivo Archivo) throws Exception{
		Archivo obj=service.registrar(Archivo);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdArchivo()).toUri();
		return new ResponseEntity<Archivo>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Archivo> modificar(@Valid @RequestBody Archivo Archivo) throws Exception{
		Archivo obj=service.modificar(Archivo);
		return new ResponseEntity<Archivo>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Archivo obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}




}
