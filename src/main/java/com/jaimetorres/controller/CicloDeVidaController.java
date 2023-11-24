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

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.CicloDeVida;
import com.jaimetorres.service.gestor.ICicloDeVidaService;

@RestController
@RequestMapping("/cicloDeVidas")
public class CicloDeVidaController {


	@Autowired
	private ICicloDeVidaService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CicloDeVida>> listar() throws Exception{
		List<CicloDeVida> lista=service.listar();
		return new ResponseEntity<List<CicloDeVida>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CicloDeVida listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CicloDeVida> registrar(@Valid @RequestBody CicloDeVida CicloDeVida) throws Exception{
		CicloDeVida obj=service.registrar(CicloDeVida);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCiclo()).toUri();
		return new ResponseEntity<CicloDeVida>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CicloDeVida> modificar(@Valid @RequestBody CicloDeVida CicloDeVida) throws Exception{
		CicloDeVida obj=service.modificar(CicloDeVida);
		return new ResponseEntity<CicloDeVida>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CicloDeVida obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/modificar")
	public ResponseEntity<Void> actualizaCiclos(@RequestBody ParametrosDTO filtro) throws Exception {
		service.actualizaCiclo(filtro);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
