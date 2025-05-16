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
import com.jaimetorres.model.gestor.Extension;
import com.jaimetorres.service.gestor.IExtensionService;

@RestController
@RequestMapping("/extensiones")
public class ExtensionController {


	@Autowired
	private IExtensionService service;

	//ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Extension>> listar() throws Exception{
		List<Extension> lista=service.listar();
		return new ResponseEntity<List<Extension>>(lista, HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public Extension listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}


	@PostMapping
	public ResponseEntity<Extension> registrar(@Valid @RequestBody Extension Extension) throws Exception{
		Extension obj=service.registrar(Extension);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getExtension()).toUri();
		return new ResponseEntity<Extension>(obj, HttpStatus.CREATED);
	}


	@PutMapping
	public ResponseEntity<Extension> modificar(@Valid @RequestBody Extension Extension) throws Exception{
		Extension obj=service.modificar(Extension);
		return new ResponseEntity<Extension>(obj, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Extension obj=service.listarPorId(id);
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
		}
		service.eliminar(id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	
	@PostMapping("/crearExt")
	public ResponseEntity<Integer> crearExt(@Valid @RequestBody Extension Extension) throws Exception{
		Integer obj=service.crearExt(Extension);
		return new ResponseEntity<Integer>(obj, HttpStatus.CREATED);
	}
	
	@PostMapping("/extEmpresa")
	public ResponseEntity<List<Extension>> extEmpresa(@Valid @RequestBody ParametrosDTO filtro) throws Exception{
		List<Extension> obj=service.extEmpresa(filtro);
		return new ResponseEntity<List<Extension>>(obj, HttpStatus.CREATED);
	}
	
	@PostMapping("/buscarExt")
	public ResponseEntity<Extension> buscarExt(@Valid @RequestBody ParametrosDTO filtro) throws Exception{
		Extension obj=service.buscarExt(filtro);
		return new ResponseEntity<Extension>(obj, HttpStatus.CREATED);
	}

	@PostMapping("/removeExtension")
	public ResponseEntity <Void> removeExtension(@RequestBody ParametrosDTO filtro) throws Exception{
		service.removeExtension(filtro);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/addExtension")
	public ResponseEntity <Void> addExtension(@RequestBody ParametrosDTO filtro) throws Exception{
		service.addExtension(filtro);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
