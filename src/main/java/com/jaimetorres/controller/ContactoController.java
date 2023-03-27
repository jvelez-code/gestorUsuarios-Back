package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.FiltroContactoDTO;
import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.service.IContactoService;

@RestController
@RequestMapping("/contactos")

public class ContactoController {


	@Autowired
	private IContactoService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Contacto>> listar() throws Exception{
		List<Contacto> lista=service.listar();
		return new ResponseEntity<List<Contacto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Contacto listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}
	
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
				
//		@PostMapping("/buscar")
//		public ResponseEntity<FiltroContactoDTO> post(@RequestBody FiltroEntranteDTO filtro) throws Exception {	
//			Integer idContactoMax=service.buscarMax(filtro);
//			
//			System.out.println(service.buscarMax(filtro));
//			List<Contacto> post = (List<Contacto>) service.buscar(idContactoMax);
//			// convert entity to DTO
//			FiltroContactoDTO postResponse = modelMapper.map(post, FiltroContactoDTO.class);
//
//			return ResponseEntity.ok().body(postResponse);
//		}
//	

		@PostMapping("/buscar")
		public ResponseEntity<Contacto> listarPorId(@RequestBody FiltroEntranteDTO filtro) throws Exception{
			Integer idContactoMax=service.buscarMax(filtro);
			System.out.println(service.buscarMax(filtro));
			Contacto lista=service.buscar(idContactoMax);
			return new ResponseEntity<Contacto>(lista, HttpStatus.OK);
		}
		
		
		@PostMapping("/{id}")
		public ResponseEntity<FiltroContactoDTO> getPostById(@PathVariable(name = "id") Integer id) throws Exception {
			Contacto post = service.listarPorId(id);
			// convert entity to DTO
			FiltroContactoDTO postResponse = modelMapper.map(post, FiltroContactoDTO.class);
			return ResponseEntity.ok().body(postResponse);
		}
		
}
