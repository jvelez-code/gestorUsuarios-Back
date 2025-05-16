package com.jaimetorres.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/recaptcha")
public class tokenGoogleController {
	
	@Value("${recaptcha.secretKey}")  // Usamos la clave secreta desde el archivo application.properties
    private String secretKey;

    private static final String RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    @PostMapping("/verify")
    public String verifyRecaptcha(@RequestParam("response") String token) {
        String url = UriComponentsBuilder.fromHttpUrl(RECAPTCHA_VERIFY_URL)
                .queryParam("secret", secretKey)
                .queryParam("response", token)
                .toUriString();
        
        RestTemplate restTemplate = new RestTemplate();
        
        // Hacer la solicitud GET a Google para verificar el token reCAPTCHA
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        // Retornar el cuerpo de la respuesta de Google (que es un JSON con el resultado de la verificación)
        return response.getBody();
    }

	}
