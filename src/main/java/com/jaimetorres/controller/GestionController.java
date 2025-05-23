package com.jaimetorres.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.exception.ModeloNotFoundException;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.service.gestor.IClienteService;
import com.jaimetorres.service.gestor.IGestionService;
import com.opencsv.exceptions.CsvValidationException;

@RestController
@RequestMapping("/gestiones")
public class GestionController {

	@Autowired
	private IGestionService service;

	// @Autowired
	// private ModelMapper modelMapper;

	@Autowired
	private IClienteService serviceCli;

	// ResponseEntity Para capturar excepciones
	@GetMapping
	public ResponseEntity<List<Gestion>> listar() throws Exception {
		List<Gestion> lista = service.listar();
		return new ResponseEntity<List<Gestion>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Gestion listarPorId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	// @GetMapping("/hateoas/{id}")
	// public EntityModel<Gestion> listarPorIdHateoas(@PathVariable("id") Integer
	// id) throws Exception{
	// Gestion obj=service.listarPorId(id);
	//
	// if(obj==null) {
	// throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
	// }
	//
	//
	//
	// //localhost:8080/Gestion/{id}
	// EntityModel<Gestion> recurso=EntityModel.of(obj);
	// WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));
	//
	// //return new ResponseEntity<Gestion>(obj, HttpStatus.OK);
	//
	// recurso.add(linkTo.withRel("Gestion-recurso"));
	// return recurso;
	// }

	// @RequestBody json a objeto java
	@PostMapping
	public ResponseEntity<Gestion> registrar(@Valid @RequestBody Gestion Gestion) throws Exception {
		Gestion obj = service.registrarTransaccional(Gestion);

		// localhost:8080/pacientes/7
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestion())
				.toUri();
		return new ResponseEntity<Gestion>(obj, HttpStatus.CREATED);
	}

	@PostMapping("/comercial")
	public ResponseEntity<Gestion> registrarComercial(@Valid @RequestBody Gestion Gestion) throws Exception {
		Gestion obj = service.registrarTransaccionalComercial(Gestion);
		service.actuaGestionComer(obj.getIdGestion(), obj.getListaDetalleGestion().get(0));

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestion())
				.toUri();
		return new ResponseEntity<Gestion>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Gestion> modificar(@Valid @RequestBody Gestion Gestion) throws Exception {
		Gestion obj = service.modificar(Gestion);
		return new ResponseEntity<Gestion>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Gestion obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// @RequestBody json a objeto java
	@PostMapping("/buscar")
	public ResponseEntity<Gestion> buscarA(@RequestBody ParametrosDTO filtro) throws Exception {

		Gestion gestion = service.buscarM(filtro);
		return new ResponseEntity<Gestion>(gestion, HttpStatus.OK);
	}

	@PostMapping("/saliente")
	public ResponseEntity<ParametrosDTO> registrarSaliente(@RequestBody ParametrosDTO filtro) throws Exception {
		Integer idges = service.gestionSaliente(filtro);
		ParametrosDTO obj = new ParametrosDTO();

		if (idges > 0) {
			service.cambioEstadoGestion(idges);
			obj = service.buscarGestioSaliente(idges);
		}

		// URI
		// location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestion()).toUri();
		return new ResponseEntity<ParametrosDTO>(obj, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Void> actualizarContacto(HttpServletRequest request, @PathVariable Integer id,
			@Valid @RequestBody Gestion gestion) {
		String clientIp = service.getClientIp(request);
		gestion.setIpAct(clientIp);
		service.actualizarGestion(id, gestion);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// CARGUE CAMPANA
	@PostMapping("/cargueArchivo")
	public ResponseEntity<ParametrosDTO> cargueArchivo(@RequestParam("file") MultipartFile file,
			@RequestParam("idUsuario") String idUsuario, @RequestParam("idEmpresa") String idEmpresa,
			HttpServletRequest request) throws IOException, CsvValidationException {

		if (file.isEmpty()) {
			throw new RuntimeException("Fallo no se encuentra el archivo 11");
		}

		System.out.println(idEmpresa + file + "");
		ParametrosDTO cargue = service.readCsvFile(file, idUsuario, idEmpresa, request);
		return new ResponseEntity<ParametrosDTO>(cargue, HttpStatus.OK);
	}

	@PostMapping("/registrarCargue")
	public ResponseEntity<Gestion> registrarCargue(@Valid @RequestBody Gestion Gestion) throws Exception {
		Gestion obj = service.registrarTransaccionalCargue(Gestion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestion())
				.toUri();
		return new ResponseEntity<Gestion>(obj, HttpStatus.CREATED);
	}

	@PostMapping("/gestionCampana")
	public ResponseEntity<Integer> gestionCampana(@RequestBody ParametrosDTO filtro) throws Exception {
		Integer idGestion = service.contarGestiones(filtro);
		return new ResponseEntity<Integer>(idGestion, HttpStatus.OK);
	}

	@PostMapping("/gestionCampanaFal")
	public ResponseEntity<Integer> gestionCampanaFal(@RequestBody ParametrosDTO filtro) throws Exception {
		Integer idGestion = service.contarGestionesfalt(filtro);
		return new ResponseEntity<Integer>(idGestion, HttpStatus.OK);
	}

	// CARGUE CAMPANA
	@PostMapping("/cargueComercial")
	public ResponseEntity<ParametrosDTO> cargueComercial(@RequestParam("file") MultipartFile file,
			@RequestParam("idUsuario") Integer idUsuario, @RequestParam("idCampana") Integer idCampana,
			HttpServletRequest request) throws IOException, CsvValidationException {

		if (file.isEmpty()) {
			throw new RuntimeException("Fallo no se encuentra el archivo comercial");
		}
		ParametrosDTO result = service.comercialFile(file, idUsuario, idCampana, request);
		return new ResponseEntity<ParametrosDTO>(result, HttpStatus.OK);
	}

	@PostMapping("/registrarVisita")
	public ResponseEntity<Gestion> registrarVisita(@RequestBody Gestion Gestion, @RequestParam boolean necesitaTransaccion) throws Exception {
		System.out.println(necesitaTransaccion + "validaController");
		Gestion obj = service.registrarTransaccionalVisita(Gestion,necesitaTransaccion );
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGestion())
				.toUri();
		System.out.println("jaime velez: " + location);
		return new ResponseEntity<Gestion>(obj, HttpStatus.CREATED);
	}
}
