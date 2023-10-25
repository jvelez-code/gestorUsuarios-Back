package com.jaimetorres.service.contact.impl;

import static java.util.stream.Collectors.toMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


@Service
public class UploadService {
	

    public void readCsvFile(MultipartFile file) throws IOException, CsvValidationException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            
            while ((nextRecord = csvReader.readNext()) != null) {
                // Aquí puedes procesar cada registro del archivo CSV
                // nextRecord es un arreglo de Strings que contiene los valores de cada columna del archivo
                for (String value : nextRecord) {
                    System.out.print(value + "**");
                }
                System.out.println("hola");
            }
        }
    }




}
