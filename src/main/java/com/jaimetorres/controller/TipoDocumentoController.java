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


import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.TipoDocumento;
import com.jaimetorres.service.gestor.ITipoDocumentoService;

@RestController
@RequestMapping("/tipoDocumentos")
public class TipoDocumentoController {


	@Autowired
	private ITipoDocumentoService service;
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<TipoDocumento>> listar() throws Exception{
		List<TipoDocumento> lista=service.listar();
		return new ResponseEntity<List<TipoDocumento>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public TipoDocumento listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}
	
//	@GetMapping("/hateoas/{id}")
//	public EntityModel<TipoDocumento> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
//		TipoDocumento obj=service.listarPorId(id);
//		
//		if(obj==null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
//		}
//		
//		
//		
//		//localhost:8080/TipoDocumento/{id}
//		EntityModel<TipoDocumento> recurso=EntityModel.of(obj);
//		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));
//		
//		//return new ResponseEntity<TipoDocumento>(obj, HttpStatus.OK);
//		
//		recurso.add(linkTo.withRel("TipoDocumento-recurso"));
//		return recurso;
//	}
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<TipoDocumento> registrar(@Valid @RequestBody TipoDocumento TipoDocumento) throws Exception{
			TipoDocumento obj=service.registrar(TipoDocumento);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return new ResponseEntity<TipoDocumento>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<TipoDocumento> modificar(@Valid @RequestBody TipoDocumento TipoDocumento) throws Exception{
			TipoDocumento obj=service.modificar(TipoDocumento);
			return new ResponseEntity<TipoDocumento>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			TipoDocumento obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
	
}
