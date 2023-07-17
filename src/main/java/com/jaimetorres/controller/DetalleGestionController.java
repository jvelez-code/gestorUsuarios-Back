package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.CantidadGestionDto;
import com.jaimetorres.dto.FiltroContactoDTO;
import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.dto.tmoGestionDto;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.Menu;
import com.jaimetorres.service.gestor.IDetalleGestionService;

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


	//		//@RequestBody json a objeto  java
	@PostMapping("/buscar")
	public ResponseEntity<List<Gestion>> listarPorIdPrueba(@RequestBody FiltroEntranteDTO filtro) throws Exception{

		List<Gestion> obj=service.buscarHisto(filtro);
		return new ResponseEntity<List<Gestion>>(obj, HttpStatus.OK);
	}

	@PostMapping("/buscarCliente")
	public ResponseEntity<List<FiltroDetalleGestionDTO>> buscarClienteId(@RequestBody FiltroEntranteDTO filtro) throws Exception{
		List<FiltroDetalleGestionDTO> menus = new ArrayList<>();
		menus = service.buscarM(filtro);
		return new ResponseEntity<List<FiltroDetalleGestionDTO>>(menus, HttpStatus.OK);
	}

	@PostMapping("/catidadGestion")
	public ResponseEntity<List<CantidadGestionDto>> catidadGestion(@RequestBody FiltroEntranteDTO filtro) throws Exception{
		List<CantidadGestionDto> cant = new ArrayList<>();
		cant = service.cantidadGestion(filtro);
		return new ResponseEntity<List<CantidadGestionDto>>(cant, HttpStatus.OK);
	}
	
	@PostMapping("/tmoGestion")
	public ResponseEntity<List<tmoGestionDto>> tmoGestion(@RequestBody FiltroEntranteDTO filtro) throws Exception{
		List<tmoGestionDto> cant = new ArrayList<>();
		cant = service.tmoGestion(filtro);
		return new ResponseEntity<List<tmoGestionDto>>(cant, HttpStatus.OK);
	}
		
		
		}
