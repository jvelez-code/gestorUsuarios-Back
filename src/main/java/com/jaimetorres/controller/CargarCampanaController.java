package com.jaimetorres.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jaimetorres.service.contact.impl.UploadService;
import com.opencsv.exceptions.CsvValidationException;

@RestController
@RequestMapping("/cargarCampana")
public class CargarCampanaController {

	
	@Autowired
	private UploadService service;
	
	@PostMapping("/upload")
    public void readCsv(@RequestParam("file") MultipartFile file) throws IOException, CsvValidationException {
           
			System.out.println("Archivo Cargue");
			service.readCsvFile(file);
    }
}
