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
import com.jaimetorres.model.DetalleGestion;
import com.jaimetorres.service.IDetalleGestionService;

@RestController
@RequestMapping("/detallegestiones")
public class DetalleGestionController {


	@Autowired
	private IDetalleGestionService service;
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<DetalleGestion>> listar() throws Exception{
		List<DetalleGestion> lista=service.listar();
		return new ResponseEntity<List<DetalleGestion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public DetalleGestion listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}
	
//	@GetMapping("/hateoas/{id}")
//	public EntityModel<DetalleGestion> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
//		DetalleGestion obj=service.listarPorId(id);
//		
//		if(obj==null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
//		}
//		
//		
//		
//		//localhost:8080/DetalleGestion/{id}
//		EntityModel<DetalleGestion> recurso=EntityModel.of(obj);
//		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));
//		
//		//return new ResponseEntity<DetalleGestion>(obj, HttpStatus.OK);
//		
//		recurso.add(linkTo.withRel("DetalleGestion-recurso"));
//		return recurso;
//	}
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<DetalleGestion> registrar(@Valid @RequestBody DetalleGestion DetalleGestion) throws Exception{
			DetalleGestion obj=service.registrar(DetalleGestion);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDetalleGestion()).toUri();
			return new ResponseEntity<DetalleGestion>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<DetalleGestion> modificar(@Valid @RequestBody DetalleGestion DetalleGestion) throws Exception{
			DetalleGestion obj=service.modificar(DetalleGestion);
			return new ResponseEntity<DetalleGestion>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			DetalleGestion obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		//@RequestBody json a objeto  java
		@PostMapping("/buscar")
		public ResponseEntity<List<DetalleGestion>> buscar(@RequestBody FiltroEntranteDTO filtro) throws Exception{
			
			List<DetalleGestion> DetalleGestion = new ArrayList<>();
			DetalleGestion = service.buscar(filtro);
			
			return new ResponseEntity<List<DetalleGestion>>(DetalleGestion, HttpStatus.OK);
		}
	
}
