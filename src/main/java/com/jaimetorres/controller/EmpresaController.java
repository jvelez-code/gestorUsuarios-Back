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
import com.jaimetorres.model.contact.LlamadaEntrante;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.Empresa;
import com.jaimetorres.service.contact.ILlamadaEntranteService;
import com.jaimetorres.service.gestor.IEmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {


	@Autowired
	private IEmpresaService service;

	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Empresa>> listar() throws Exception{
		System.out.print("Hola Mundo");
		List<Empresa> lista=service.listar();
		return new ResponseEntity<List<Empresa>>(lista, HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public Empresa listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	
	@PostMapping
	public ResponseEntity<Empresa> registrar(@Valid @RequestBody Empresa Empresa) throws Exception{
		Empresa obj=service.registrar(Empresa);


		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEmpresa()).toUri();
		return new ResponseEntity<Empresa>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Empresa> modificar(@Valid @RequestBody Empresa Empresa) throws Exception{
		Empresa obj=service.modificar(Empresa);
		return new ResponseEntity<Empresa>(obj, HttpStatus.OK);
	}

		
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Empresa obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/modificar")
	public ResponseEntity<Void> listarPorId(@RequestBody FiltroEntranteDTO filtro) throws Exception {
		service.modificar(filtro);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

		
	}
