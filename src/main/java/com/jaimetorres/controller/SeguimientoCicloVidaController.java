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
import com.jaimetorres.model.gestor.SeguimientoCicloVida;
import com.jaimetorres.service.gestor.ISeguimientoCicloVidaService;

@RestController
@RequestMapping("/seguimientoCicloVidas")
public class SeguimientoCicloVidaController {


	@Autowired
	private ISeguimientoCicloVidaService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<SeguimientoCicloVida>> listar() throws Exception{
		List<SeguimientoCicloVida> lista=service.listar();
		return new ResponseEntity<List<SeguimientoCicloVida>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public SeguimientoCicloVida listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<SeguimientoCicloVida> registrar(@Valid @RequestBody SeguimientoCicloVida SeguimientoCicloVida) throws Exception{
		SeguimientoCicloVida obj=service.registrar(SeguimientoCicloVida);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSeguimientoCicloVida()).toUri();
		return new ResponseEntity<SeguimientoCicloVida>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<SeguimientoCicloVida> modificar(@Valid @RequestBody SeguimientoCicloVida SeguimientoCicloVida) throws Exception{
		SeguimientoCicloVida obj=service.modificar(SeguimientoCicloVida);
		return new ResponseEntity<SeguimientoCicloVida>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		SeguimientoCicloVida obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
