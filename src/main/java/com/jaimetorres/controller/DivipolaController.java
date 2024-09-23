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

import com.jaimetorres.dto.DivipolaDto;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.Divipola;
import com.jaimetorres.service.gestor.IDivipolaService;

@RestController
@RequestMapping("/divipolas")
public class DivipolaController {


	@Autowired
	private IDivipolaService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<Divipola>> listar() throws Exception{
		List<Divipola> lista=service.listar();
		return new ResponseEntity<List<Divipola>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Divipola listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<Divipola> registrar(@Valid @RequestBody Divipola Divipola) throws Exception{
		Divipola obj=service.registrar(Divipola);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdZona()).toUri();
		return new ResponseEntity<Divipola>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Divipola> modificar(@Valid @RequestBody Divipola Divipola) throws Exception{
		Divipola obj=service.modificar(Divipola);
		return new ResponseEntity<Divipola>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Divipola obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


	@GetMapping("/buscar")
	public ResponseEntity<List<DivipolaDto>> listarDivipolas() throws Exception{
		List<DivipolaDto> lista=service.listaCiudades();
		return new ResponseEntity<List<DivipolaDto>>(lista, HttpStatus.OK);
	}

	@PostMapping("/buscarCargue")
	public ResponseEntity<List<Divipola>> buscarCargue(@RequestBody DivipolaDto filtro) throws Exception {
		List<Divipola> divi = service.cargueCampana(filtro);
		return new ResponseEntity<List<Divipola>>(divi, HttpStatus.OK);
	}


}
