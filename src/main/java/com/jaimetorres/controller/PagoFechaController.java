package com.jaimetorres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.mongo.PagoFecha;
import com.jaimetorres.service.mongo.IPagoFechaService;

@RestController
@RequestMapping("/pagos")
public class PagoFechaController {

    @Autowired
    private IPagoFechaService service;

    @PostMapping("/rangoFechas")
	public ResponseEntity <List<PagoFecha>> rangoFechas(@RequestBody ParametrosDTO filtro) {
		List<PagoFecha> lista = service.obtenerPagos(filtro);
		return new ResponseEntity<List<PagoFecha>>(lista, HttpStatus.OK);
	}

    @PostMapping("/pagoDocumento")
	public ResponseEntity <PagoFecha> pagoDocumento(@RequestBody ParametrosDTO filtro) {
		PagoFecha pago = service.pagoDocumento(filtro);
		return new ResponseEntity<PagoFecha>(pago, HttpStatus.OK);
	}

}
