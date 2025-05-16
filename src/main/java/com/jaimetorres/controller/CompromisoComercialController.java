package com.jaimetorres.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.CompromisoComercial;
import com.jaimetorres.service.gestor.ICompromisoComercialService;

@RestController
@RequestMapping("/compromisoComerciales")
public class CompromisoComercialController {


	@Autowired
	private ICompromisoComercialService service;

	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<CompromisoComercial>> listar() throws Exception{
		List<CompromisoComercial> lista=service.listar();
		return new ResponseEntity<List<CompromisoComercial>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CompromisoComercial listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CompromisoComercial> registrar(@Valid @RequestBody CompromisoComercial CompromisoComercial) throws Exception{
		CompromisoComercial obj=service.registrar(CompromisoComercial);
		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCompromiso()).toUri();
		return new ResponseEntity<CompromisoComercial>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CompromisoComercial> modificar(@Valid @RequestBody CompromisoComercial CompromisoComercial) throws Exception{
		CompromisoComercial obj=service.modificar(CompromisoComercial);
		return new ResponseEntity<CompromisoComercial>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CompromisoComercial obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	


}
