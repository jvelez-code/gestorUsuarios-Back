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
import com.jaimetorres.model.gestor.AgenteCampana;
import com.jaimetorres.model.gestor.Campana;
import com.jaimetorres.service.gestor.IAgenteCampanaService;

@RestController
@RequestMapping("/agenteCampanas")
public class AgenteCampanaController {


	@Autowired
	private IAgenteCampanaService service;


	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<AgenteCampana>> listar() throws Exception{
		List<AgenteCampana> lista=service.listar();
		return new ResponseEntity<List<AgenteCampana>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public AgenteCampana listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}


	//@RequestBody json a objeto  java
	@PostMapping
	public ResponseEntity<AgenteCampana> registrar(@Valid @RequestBody AgenteCampana agenteCampana) throws Exception{
		AgenteCampana obj=service.registrar(agenteCampana);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAgenteCampana()).toUri();
		return new ResponseEntity<AgenteCampana>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<AgenteCampana> modificar(@Valid @RequestBody AgenteCampana agenteCampana) throws Exception{
		AgenteCampana obj=service.modificar(agenteCampana);
		return new ResponseEntity<AgenteCampana>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		AgenteCampana obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/asignarAgente")
	public ResponseEntity <Void> asignarCampana(@Valid @RequestBody ParametrosDTO filtro) throws Exception{
		service.eliminarCampana(filtro);
		service.guardarCampana(filtro);
		return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
	}

	@PostMapping("/validarAsignacion")
	public ResponseEntity<List<AgenteCampana>> validarAsignacion(@Valid @RequestBody ParametrosDTO filtro) throws Exception{
		List<AgenteCampana> agentesCampana = service.validarAsignacion(filtro); 
		if (agentesCampana.isEmpty()) {
		    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(agentesCampana); // Respuesta 204 si no hay resultados
		    }
		    return ResponseEntity.status(HttpStatus.OK).body(agentesCampana);
	}



}
