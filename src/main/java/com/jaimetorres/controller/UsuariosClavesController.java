package com.jaimetorres.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.UsuariosClaves;
import com.jaimetorres.service.gestor.IUsuariosClavesService;

@RestController
@RequestMapping("/UsuariosClaves")
public class UsuariosClavesController {


	@Autowired
	private IUsuariosClavesService service;

	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<UsuariosClaves>> listar() throws Exception{
		List<UsuariosClaves> lista=service.listar();
		return new ResponseEntity<List<UsuariosClaves>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public UsuariosClaves listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<UsuariosClaves> registrar(@Valid @RequestBody UsuariosClaves UsuariosClaves) throws Exception{
		UsuariosClaves obj=service.registrar(UsuariosClaves);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdusuarioclave()).toUri();
		return new ResponseEntity<UsuariosClaves>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<UsuariosClaves> modificar(@Valid @RequestBody UsuariosClaves UsuariosClaves) throws Exception{
		UsuariosClaves obj=service.modificar(UsuariosClaves);
		return new ResponseEntity<UsuariosClaves>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		UsuariosClaves obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


	@PostMapping("/listarClaves")
	public ResponseEntity <Boolean>  listarClaves(@RequestBody ParametrosDTO filtro) throws Exception{
		boolean obj = service.buscarClaves(filtro);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

}
