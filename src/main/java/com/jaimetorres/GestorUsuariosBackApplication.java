package com.jaimetorres;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@SpringBootApplication

public class GestorUsuariosBackApplication extends SpringBootServletInitializer {
	
	 private static final String ALGORITHM = "AES";
	 private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(GestorUsuariosBackApplication.class, args);
		System.out.println("Hola Mundo homeOfice:v1");	
//		// Generar la clave AES
//        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//        keyGen.init(256); // Puedes usar 128, 192 o 256 bits
//        SecretKey secretKey = keyGen.generateKey(); 
//        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
//        System.out.println("Clave AES en Base64: " + encodedKey);
//        
//        // Reemplaza con tu clave secreta en Base64
//        SecretKeySpec keySpec = new SecretKeySpec(Base64.getDecoder().decode(encodedKey), ALGORITHM);
//        String password = "V3l3z24*";
//        String encryptedPassword = encrypt(password, keySpec);
//        System.out.println("Contraseña encriptada: " + encryptedPassword);
	}
	
	private static String encrypt(String data, SecretKeySpec keySpec) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GestorUsuariosBackApplication.class);	
    }

}
