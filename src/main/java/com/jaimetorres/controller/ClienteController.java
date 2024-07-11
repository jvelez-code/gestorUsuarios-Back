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

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.contact.LlamadaEntrante;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.service.contact.ILlamadaEntranteService;
import com.jaimetorres.service.gestor.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


	@Autowired
	private IClienteService service;
	
	@Autowired
	private ILlamadaEntranteService serviceLlama;

	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() throws Exception{
		List<Cliente> lista=service.listar();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Cliente listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}
	
//	@GetMapping("/hateoas/{id}")
//	public EntityModel<Cliente> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
//		Cliente obj=service.listarPorId(id);
//		
//		if(obj==null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
//		}
//		
//		
//		
//		//localhost:8080/Cliente/{id}
//		EntityModel<Cliente> recurso=EntityModel.of(obj);
//		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));
//		
//		//return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
//		
//		recurso.add(linkTo.withRel("Cliente-recurso"));
//		return recurso;
//	}
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente Cliente) throws Exception{
			Cliente obj=service.registrar(Cliente);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
			return new ResponseEntity<Cliente>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente Cliente) throws Exception{
			Cliente obj=service.modificar(Cliente);
			return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			Cliente obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		//@RequestBody json a objeto  java
		@PostMapping("/buscar")
		public ResponseEntity<List<Cliente>> buscar(@RequestBody ParametrosDTO filtro) throws Exception {
			
			List<Cliente> cliente = new ArrayList<>();
			cliente = service.buscar(filtro);			
			return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
		}
		
		
		//@RequestBody json a objeto  java
		@GetMapping("/buscar")
		public ResponseEntity<List<Cliente>> buscarp(@RequestBody ParametrosDTO filtro) throws Exception{
					
			List<Cliente> cliente = new ArrayList<>();
			cliente = service.buscarByCliente(filtro);		
			return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
		}
		
		@PostMapping("/buscarId")
		public ResponseEntity<List<Cliente>> buscarId(@RequestBody ParametrosDTO filtro) throws Exception{
			
			List<Cliente> cliente = new ArrayList<>();
			cliente = service.buscarByClientes(filtro);
			return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
		}
		

		@PostMapping("/buscarAsterisk")
		public ResponseEntity<Cliente> buscarIdAsterisk(@RequestBody ParametrosDTO filtro) throws Exception{
			LlamadaEntrante obj = serviceLlama.buscarIdAsterisk(filtro);
			Cliente cli = service.buscarIdAsterisk(obj.getTipoDocumento().getId(), obj.getNumeroDocumento());
			return new ResponseEntity<Cliente>(cli, HttpStatus.OK);
		}
		
	
}
