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
import com.jaimetorres.model.gestor.SeguimientoComercial;
import com.jaimetorres.service.gestor.ISeguimientoComercialService;

@RestController
@RequestMapping("/seguimientoComerciales")
public class SeguimientoComercialController {

	@Autowired
	private ISeguimientoComercialService service;

	// ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<SeguimientoComercial>> listar() throws Exception {
		List<SeguimientoComercial> lista = service.listar();
		return new ResponseEntity<List<SeguimientoComercial>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public SeguimientoComercial listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	// @RequestBody json a objeto java
	@PostMapping
	public ResponseEntity<SeguimientoComercial> registrar(@Valid @RequestBody SeguimientoComercial SeguimientoComercial)
			throws Exception {
		SeguimientoComercial obj = service.registrar(SeguimientoComercial);
		// localhost:8080/pacientes/7
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdSeguimiento()).toUri();
		return new ResponseEntity<SeguimientoComercial>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<SeguimientoComercial> modificar(@Valid @RequestBody SeguimientoComercial SeguimientoComercial)
			throws Exception {
		SeguimientoComercial obj = service.modificar(SeguimientoComercial);
		return new ResponseEntity<SeguimientoComercial>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		SeguimientoComercial obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
