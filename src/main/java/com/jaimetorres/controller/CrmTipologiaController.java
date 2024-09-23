package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.CrmTipologia;
import com.jaimetorres.model.gestor.CrmTipologia;
import com.jaimetorres.service.gestor.ICrmTipologiaService;

@RestController
@RequestMapping("/crmTipologia")
public class CrmTipologiaController {


	@Autowired
	private ICrmTipologiaService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmTipologia>> listar() throws Exception{
		List<CrmTipologia> lista=service.listar();
		return new ResponseEntity<List<CrmTipologia>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmTipologia listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmTipologia> registrar(@Valid @RequestBody CrmTipologia CrmTipologia) throws Exception{
		CrmTipologia obj=service.registrar(CrmTipologia);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSubcategoria()).toUri();
		return new ResponseEntity<CrmTipologia>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmTipologia> modificar(@Valid @RequestBody CrmTipologia CrmTipologia) throws Exception{
		CrmTipologia obj=service.modificar(CrmTipologia);
		return new ResponseEntity<CrmTipologia>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmTipologia obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("listarPorSub/{id}")
	public ResponseEntity<List<CrmTipologia>> listarPorSub(@PathVariable("id")Integer id) throws Exception{
		List<CrmTipologia> crmTipologia = new ArrayList<>();
		crmTipologia = service.buscarTipoS(id);
		return new ResponseEntity<List<CrmTipologia>>(crmTipologia, HttpStatus.OK);
	}
	

}
