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

import com.jaimetorres.dto.FiltroCrmDetallesDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.CrmCasos;
import com.jaimetorres.model.gestor.CrmDetalle;
import com.jaimetorres.service.gestor.ICrmDetalleService;

@RestController
@RequestMapping("/crmDetalles")
public class CrmDetalleController {


	@Autowired
	private ICrmDetalleService service;

	@GetMapping
	public ResponseEntity<List<CrmDetalle>> listar() throws Exception{
		List<CrmDetalle> lista=service.listar();
		return new ResponseEntity<List<CrmDetalle>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CrmDetalle listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<CrmDetalle> registrar(@Valid @RequestBody CrmDetalle CrmDetalle) throws Exception{
		CrmDetalle obj=service.registrar(CrmDetalle);

		//localhost:8080/pacientes/7
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDetalle()).toUri();
		return new ResponseEntity<CrmDetalle>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<CrmDetalle> modificar(@Valid @RequestBody CrmDetalle CrmDetalle) throws Exception{
		CrmDetalle obj=service.modificar(CrmDetalle);
		return new ResponseEntity<CrmDetalle>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CrmDetalle obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/detalleCasos/{id}")
	public ResponseEntity<List<FiltroCrmDetallesDTO>> detalleCasosPorId(@PathVariable("id")Integer id) throws Exception{
		List<FiltroCrmDetallesDTO> crmdetalle = new ArrayList<>();
		crmdetalle = service.buscarDetalleS(id);
		return new ResponseEntity<List<FiltroCrmDetallesDTO>>(crmdetalle, HttpStatus.OK);
	}
	
	
	@PostMapping("/registrarDetalle")
	public ResponseEntity<Void> registrarDetalle(@Valid @RequestBody FiltroCrmDetallesDTO dto) throws Exception{
		service.registrarObser(dto);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

}
