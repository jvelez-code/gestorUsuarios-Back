package com.jaimetorres.service.gestor.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jaimetorres.service.gestor.IStorageService;


@Service
public class FileSystemStorageServiceImpl implements IStorageService {
	
	@Value("${media.location}")
	private String mediaLocation;
	
	private Path rootLocation;

	@Override
	@PostConstruct
	public void init() throws IOException {
		rootLocation = Paths.get(mediaLocation);		
		Files.createDirectories(rootLocation);
	}

	@Override
	public String store(MultipartFile file)  {
		if(file.isEmpty()) {
			throw new RuntimeException("fallo no se encuentra el archivo");
		}
		String filename = file.getOriginalFilename();
		Path destinationFile = rootLocation.resolve(Paths.get(filename))
				.normalize().toAbsolutePath();
		try(InputStream inputStream = file.getInputStream()){
			Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("Fallo subir el archivo");
		}
		return filename;
	}

	@Override
	public Resource loadAsResource(String filename) {
	try {
		Path file = rootLocation.resolve(filename);
		Resource resource = new UrlResource((file.toUri()));
		
		if( resource.exists() || resource.isReadable()) {
			return resource;
		} else {
			throw new RuntimeException("No puede leer el archivo" + filename);
		}
	} catch(MalformedURLException e) {
		throw new RuntimeException("No puede leer Archivo" + filename);
		
	}
	}

			
}


