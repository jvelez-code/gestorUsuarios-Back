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
import com.jaimetorres.model.Contacto;
import com.jaimetorres.service.IContactoService;

@RestController
@RequestMapping("/contactos")
public class ContactoController {


	@Autowired
	private IContactoService service;
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Contacto>> listar() throws Exception{
		List<Contacto> lista=service.listar();
		return new ResponseEntity<List<Contacto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Contacto listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}
	
//	@GetMapping("/hateoas/{id}")
//	public EntityModel<Contacto> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
//		Contacto obj=service.listarPorId(id);
//		
//		if(obj==null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
//		}
//		
//		
//		
//		//localhost:8080/Contacto/{id}
//		EntityModel<Contacto> recurso=EntityModel.of(obj);
//		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));
//		
//		//return new ResponseEntity<Contacto>(obj, HttpStatus.OK);
//		
//		recurso.add(linkTo.withRel("Contacto-recurso"));
//		return recurso;
//	}
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<Contacto> registrar(@Valid @RequestBody Contacto Contacto) throws Exception{
			Contacto obj=service.registrar(Contacto);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdContacto()).toUri();
			return new ResponseEntity<Contacto>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<Contacto> modificar(@Valid @RequestBody Contacto Contacto) throws Exception{
			Contacto obj=service.modificar(Contacto);
			return new ResponseEntity<Contacto>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			Contacto obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		//@RequestBody json a objeto  java
		@PostMapping("/buscar")
		public ResponseEntity<List<Contacto>> buscar(@RequestBody FiltroEntranteDTO filtro) throws Exception{
			
			List<Contacto> Contacto = new ArrayList<>();
			Contacto = service.buscar(filtro);
			
			return new ResponseEntity<List<Contacto>>(Contacto, HttpStatus.OK);
		}
		
}
