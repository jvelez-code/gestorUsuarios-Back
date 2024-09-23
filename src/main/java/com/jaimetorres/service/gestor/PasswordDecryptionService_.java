package com.jaimetorres.service.gestor;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class PasswordDecryptionService_ {

    @Value("${encryption.secret.key}")
    private String secretKey;
    
    public String decryptPassword(String encryptedPassword) throws Exception {
    	System.out.println(secretKey +"hola mundo");
        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
        SecretKeySpec keySpec = new SecretKeySpec(decodedKey, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);

        byte[] decodedPassword = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedPasswordBytes = cipher.doFinal(decodedPassword);
        return new String(decryptedPasswordBytes);
    }
}
