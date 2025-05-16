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
import com.jaimetorres.model.gestor.Motivo;
import com.jaimetorres.service.gestor.IMotivoService;

@RestController
@RequestMapping("/motivos")
public class MotivoController {


	@Autowired
	private IMotivoService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<Motivo>> listar() throws Exception{
		List<Motivo> lista=service.listar();
		return new ResponseEntity<List<Motivo>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Motivo listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<Motivo> registrar(@Valid @RequestBody Motivo Motivo) throws Exception{
		Motivo obj=service.registrar(Motivo);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMotivo()).toUri();
		return new ResponseEntity<Motivo>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Motivo> modificar(@Valid @RequestBody Motivo Motivo) throws Exception{
		Motivo obj=service.modificar(Motivo);
		return new ResponseEntity<Motivo>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Motivo obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
