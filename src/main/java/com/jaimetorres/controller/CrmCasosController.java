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

import com.jaimetorres.dto.FiltroCrmCasosDTO;
import com.jaimetorres.dto.FiltroCrmDetallesDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.CrmCasos;
import com.jaimetorres.service.gestor.ICrmCasosService;

@RestController
@RequestMapping("/crmCasos")
public class CrmCasosController {


	@Autowired
	private ICrmCasosService service;

	//ResponseEntity Para capturar excepciones
	//@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listarId')")
	@GetMapping
	public ResponseEntity<List<CrmCasos>> listar() throws Exception{
		List<CrmCasos> lista=service.listar();
		return new ResponseEntity<List<CrmCasos>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmCasos listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmCasos> registrar(@Valid @RequestBody CrmCasos CrmCasos) throws Exception{
		CrmCasos obj=service.registrarTransaccional(CrmCasos);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCaso()).toUri();
		return new ResponseEntity<CrmCasos>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmCasos> modificar(@Valid @RequestBody CrmCasos CrmCasos) throws Exception{
		CrmCasos obj=service.modificar(CrmCasos);
		return new ResponseEntity<CrmCasos>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmCasos obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/casosCliente")
	public ResponseEntity<List<FiltroCrmCasosDTO>> casosCliente(@RequestBody ParametrosDTO filtro) throws Exception{
		List<FiltroCrmCasosDTO> casos = new ArrayList<>();
		casos = service.buscarCasosS(filtro);
		return new ResponseEntity<List<FiltroCrmCasosDTO>>(casos, HttpStatus.OK);
	}
	
	@GetMapping("/casosEstado")
	public ResponseEntity<List<FiltroCrmCasosDTO>> casosEstado() throws Exception{
		List<FiltroCrmCasosDTO> lista=service.buscarEstadoR();
		return new ResponseEntity<List<FiltroCrmCasosDTO>>(lista, HttpStatus.OK);
	}
	
	@PostMapping("/actualizaCaso")
	public ResponseEntity<Void> actualizaCaso(@RequestBody FiltroCrmDetallesDTO filtro) throws Exception{
		service.actuEstadoR(filtro);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	


}
