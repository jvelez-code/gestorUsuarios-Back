package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.contact.AskEstadoExtension;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.service.contact.IAskEstadoExtensionService;

@RestController
@RequestMapping("/askEstadoExtensiones")
public class AskEstadoExtensionController {


	@Autowired
	private IAskEstadoExtensionService service;
	
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<AskEstadoExtension>> listar() throws Exception{
		List<AskEstadoExtension> lista=service.listar();
		return new ResponseEntity<List<AskEstadoExtension>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public AskEstadoExtension listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}
	
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<AskEstadoExtension> registrar(@Valid @RequestBody AskEstadoExtension AskEstadoExtension) throws Exception{
			AskEstadoExtension obj=service.registrar(AskEstadoExtension);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExtension()).toUri();
			return new ResponseEntity<AskEstadoExtension>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<AskEstadoExtension> modificar(@Valid @RequestBody AskEstadoExtension AskEstadoExtension) throws Exception{
			AskEstadoExtension obj=service.modificar(AskEstadoExtension);
			return new ResponseEntity<AskEstadoExtension>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			AskEstadoExtension obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		//@RequestBody json a objeto  java
				@PostMapping("/buscar")
				public ResponseEntity<AskEstadoExtension> buscarAgente(@RequestBody FiltroEntranteDTO filtro) throws Exception{
							
							AskEstadoExtension askEstadoExtension = new AskEstadoExtension();
							askEstadoExtension = service.buscar(filtro);
							
							return new ResponseEntity<AskEstadoExtension>(askEstadoExtension, HttpStatus.OK);
				}
		
}
