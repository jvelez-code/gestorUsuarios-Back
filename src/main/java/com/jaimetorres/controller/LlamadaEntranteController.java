package com.jaimetorres.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.TmoGestionUsuarioDto;
import com.jaimetorres.dto.LlamadaEntranteDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.contact.LlamadaEntrante;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.EstadoGestion;
import com.jaimetorres.service.contact.ILlamadaEntranteService;
import com.jaimetorres.service.gestor.IGestionService;

@RestController
@RequestMapping("/LlamadasEntrantes")
public class LlamadaEntranteController {


	@Autowired
	private ILlamadaEntranteService service;
	
	@Autowired
	private IGestionService serviceGes;
	
	
	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<LlamadaEntrante>> listar() throws Exception{
		List<LlamadaEntrante> lista=service.listar();
		return new ResponseEntity<List<LlamadaEntrante>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public LlamadaEntrante listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}
	
	
	//@RequestBody json a objeto  java
		@PostMapping
		public ResponseEntity<LlamadaEntrante> registrar(@Valid @RequestBody LlamadaEntrante LlamadaEntrante) throws Exception{
			LlamadaEntrante obj=service.registrar(LlamadaEntrante);
			
			//localhost:8080/pacientes/7
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdLlamadaEntrante()).toUri();
			return new ResponseEntity<LlamadaEntrante>(obj, HttpStatus.CREATED);
		}
		
		
		@PutMapping
		public ResponseEntity<LlamadaEntrante> modificar(@Valid @RequestBody LlamadaEntrante LlamadaEntrante) throws Exception{
			LlamadaEntrante obj=service.modificar(LlamadaEntrante);
			return new ResponseEntity<LlamadaEntrante>(obj, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
			LlamadaEntrante obj=service.listarPorId(id);
			if(obj==null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
			}
			service.eliminar(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		@PostMapping("/buscarAsterisk")
		public ResponseEntity<Boolean> buscarAsterisk(@RequestBody ParametrosDTO filtro) throws Exception{
			    Boolean logueo;	
		    	String evento = service.validarAsterisk(filtro);		    	
				if (evento.equals("AGENTLOGOFF")) {
					logueo=false;
				}
				else {
					logueo=true;
				}
			
					return new ResponseEntity<Boolean>(logueo, HttpStatus.OK);
		}
		
		@PostMapping("/buscarLlamada")
		public ResponseEntity<Boolean> buscarLlamada(@RequestBody ParametrosDTO filtro) throws Exception{
			    
				Boolean logueo= false;				    
		    	String evento = service.validarAsterisk(filtro);
		    	if (evento != null && evento.equals("CONNECT")) {
					
					logueo=true;
		        }
				return new ResponseEntity<Boolean>(logueo, HttpStatus.OK);
		}
		
		@PostMapping("/llamadaEntrante")
		public ResponseEntity<LlamadaEntranteDTO> buscarIdAsterisk(@RequestBody ParametrosDTO filtro) throws Exception{
			LlamadaEntranteDTO obj = service.entranteSinRegistro(filtro);
			return new ResponseEntity<LlamadaEntranteDTO>(obj, HttpStatus.OK);
		}
		
		
		@PostMapping("/tmoUsuario")
		public ResponseEntity<TmoGestionUsuarioDto> tmoUsuario(@RequestBody ParametrosDTO filtro) throws Exception{
			TmoGestionUsuarioDto obj = service.validarTmo(filtro);
			return new ResponseEntity<TmoGestionUsuarioDto>(obj, HttpStatus.OK);
		}

		@PostMapping("/llamadaSecretaria")
		public ResponseEntity<LlamadaEntrante> llamadaSecretaria(@RequestBody LlamadaEntranteDTO filtro) throws Exception{
				
			LlamadaEntrante obj = service.buscarSecreVirt(filtro);
			if (obj == null) {
		        return null;
		    }
			filtro.setIdLlamadaEntrante(obj.getIdLlamadaEntrante());
			filtro.setnumeroDocumento(obj.getNumeroDocumento());
			Integer ges = serviceGes.buscarSecre(filtro);
			if (ges >0) {
				obj.setOpcionEntrante(555);
		    }	
			service.actualSecreVirt(filtro);
			service.limpiarSecre(filtro);
			return new ResponseEntity<LlamadaEntrante>(obj, HttpStatus.OK);
		}

	
		@PostMapping("/devolSecretaria")
		public ResponseEntity<Void> devolSecretaria(@RequestBody LlamadaEntranteDTO filtro) throws Exception {
		    service.devoluSecreVirt(filtro);
		    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		

	
}
