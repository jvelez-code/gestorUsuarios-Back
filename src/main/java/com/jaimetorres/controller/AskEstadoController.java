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
import com.jaimetorres.model.contact.AskEstado;
import com.jaimetorres.service.contact.IAskEstadoService;

@RestController
@RequestMapping("/askEstados")
public class AskEstadoController {


	@Autowired
	private IAskEstadoService service;
	
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<AskEstado>> listar() throws Exception{
		List<AskEstado> lista=service.listar();
		return new ResponseEntity<List<AskEstado>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public AskEstado listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}
	
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<AskEstado> registrar(@Valid @RequestBody AskEstado AskEstado) throws Exception{
			AskEstado obj=service.registrar(AskEstado);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEstado()).toUri();
			return new ResponseEntity<AskEstado>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<AskEstado> modificar(@Valid @RequestBody AskEstado AskEstado) throws Exception{
			AskEstado obj=service.modificar(AskEstado);
			return new ResponseEntity<AskEstado>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			AskEstado obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
						
		@GetMapping("/buscar")
		public ResponseEntity<List<AskEstado>> listarActivos() throws Exception{
			List<AskEstado> lista=service.buscar();
			return new ResponseEntity<List<AskEstado>>(lista, HttpStatus.OK);
		}

	
}
