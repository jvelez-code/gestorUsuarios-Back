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
import com.jaimetorres.dto.estadoComercialDto;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.EstadoGestion;
import com.jaimetorres.service.gestor.IEstadoGestionService;

@RestController
@RequestMapping("/estadoGestiones")
public class EstadoGestionController {


	@Autowired
	private IEstadoGestionService service;
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<EstadoGestion>> listar() throws Exception{
		List<EstadoGestion> lista=service.listar();
		return new ResponseEntity<List<EstadoGestion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public EstadoGestion listarPorId(@PathVariable("id") Integer id) throws Exception{
		return service.listarPorId(id);
	}
	
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<EstadoGestion> registrar(@Valid @RequestBody EstadoGestion EstadoGestion) throws Exception{
			EstadoGestion obj=service.registrar(EstadoGestion);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEstadoGestion()).toUri();
			return new ResponseEntity<EstadoGestion>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<EstadoGestion> modificar(@Valid @RequestBody EstadoGestion EstadoGestion) throws Exception{
			EstadoGestion obj=service.modificar(EstadoGestion);
			return new ResponseEntity<EstadoGestion>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			EstadoGestion obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		//@RequestBody json a objeto  java
		@PostMapping("/buscar")
		public ResponseEntity<List<EstadoGestion>> buscar(@RequestBody ParametrosDTO filtro) throws Exception{
					
					List<EstadoGestion> estadoGestion = new ArrayList<>();
					estadoGestion = service.buscar(filtro);
					
					return new ResponseEntity<List<EstadoGestion>>(estadoGestion, HttpStatus.OK);
		}
		
		@PostMapping("/buscarEstado")
		public ResponseEntity<List<EstadoGestion>> buscarEstadoH(@RequestBody ParametrosDTO filtro) throws Exception{
					
					List<EstadoGestion> estadoGestion = new ArrayList<>();
					estadoGestion = service.buscarEstadoH(filtro);
					
					return new ResponseEntity<List<EstadoGestion>>(estadoGestion, HttpStatus.OK);
		}
		
		
		@PostMapping("/gestionComercial")
		public ResponseEntity<List<estadoComercialDto>> gestionComercial(@RequestBody ParametrosDTO filtro) throws Exception{
					
					List<estadoComercialDto> estadoComercial = new ArrayList<>();
					estadoComercial = service.gestionComercial(filtro);
					
					return new ResponseEntity<List<estadoComercialDto>>(estadoComercial, HttpStatus.OK);
		}
		
		
		
}
