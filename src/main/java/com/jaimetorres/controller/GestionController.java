package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.service.gestor.IGestionService;

@RestController
@RequestMapping("/gestiones")
public class GestionController {


	@Autowired
	private IGestionService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Gestion>> listar() throws Exception{
		List<Gestion> lista=service.listar();
		return new ResponseEntity<List<Gestion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Gestion listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}
	
//	@GetMapping("/hateoas/{id}")
//	public EntityModel<Gestion> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
//		Gestion obj=service.listarPorId(id);
//		
//		if(obj==null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
//		}
//		
//		
//		
//		//localhost:8080/Gestion/{id}
//		EntityModel<Gestion> recurso=EntityModel.of(obj);
//		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));
//		
//		//return new ResponseEntity<Gestion>(obj, HttpStatus.OK);
//		
//		recurso.add(linkTo.withRel("Gestion-recurso"));
//		return recurso;
//	}
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<Gestion> registrar(@Valid @RequestBody Gestion Gestion) throws Exception{
			Gestion obj=service.registrarTransaccional(Gestion);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestion()).toUri();
			return new ResponseEntity<Gestion>(obj, HttpStatus.CREATED);
		}
		
		@PostMapping("/comercial")
		public ResponseEntity<Gestion> registrarComercial(@Valid @RequestBody Gestion Gestion) throws Exception{
			Gestion obj=service.registrarTransaccionalComercial(Gestion);
			service.actuaGestionComer(obj.getIdGestion(), obj.getListaDetalleGestion().get(0));
			
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestion()).toUri();
			return new ResponseEntity<Gestion>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<Gestion> modificar(@Valid @RequestBody Gestion Gestion) throws Exception{
			Gestion obj=service.modificar(Gestion);
			return new ResponseEntity<Gestion>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			Gestion obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		//@RequestBody json a objeto  java
		@PostMapping("/buscar")
		public ResponseEntity<Gestion> buscarA(@RequestBody ParametrosDTO filtro) throws Exception{
			
			Gestion gestion= service.buscarM(filtro);			
			return new ResponseEntity<Gestion>(gestion, HttpStatus.OK);
		}
		
				
		@PostMapping("/saliente")
		public ResponseEntity<ParametrosDTO> registrarSaliente(@RequestBody ParametrosDTO filtro) throws Exception{
			Integer idges=service.gestionSaliente(filtro);
			service.cambioEstadoGestion(idges);
			ParametrosDTO obj= service.buscarGestioSaliente(idges);
			
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestion()).toUri();
			return new ResponseEntity<ParametrosDTO>(obj, HttpStatus.CREATED);
		}
		
		
		@PatchMapping("/{id}")
	    public ResponseEntity<Void> actualizarContacto(@PathVariable Integer id, @Valid @RequestBody Gestion gestion) {
			service.actualizarGestion(id, gestion);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }

}