package com.jaimetorres.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.ResetToken;
import com.jaimetorres.model.gestor.Usuarios;
import com.jaimetorres.service.gestor.ILoginService;
import com.jaimetorres.service.gestor.IResetTokenService;
import com.jaimetorres.util.EmailUtil;
import com.jaimetorres.util.Mail;



@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ILoginService service;
	
	@Autowired	
	private IResetTokenService tokenService;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Value("${url_correo}")
    private String urlCorreo;
	
	@PostMapping(value = "/enviarCorreo", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Integer> enviarCorreo(@RequestBody String correo) throws Exception {
		int rpta = 0; 
		
		Usuarios us = service.verificarNombreUsuario(correo);
		if(us != null && us.getIdUsuario() > 0) {
			ResetToken token = new ResetToken();
			token.setToken(UUID.randomUUID().toString());
			token.setUser(us);
			token.setExpiracion(10);
			tokenService.guardar(token);
			
			Mail mail = new Mail();
			mail.setFrom("JAIME_TORRES");
			mail.setTo(us.getEmail());
			mail.setSubject("RESTABLECER CONTRASEÑA GESTOR");
			
			Map<String, Object> model = new HashMap<>();
			//String url = "https://gestorcoordinador.enlace-apb.com/gestorfront/#/recuperar/" + token.getToken();
			String url = urlCorreo + "/#/recuperar/" + token.getToken();
			//String url = "http://127.0.0.1/#/recuperar/" + token.getToken();
			//String url = "https://10.1.1.218/gestorfront/#/recuperar/" + token.getToken();
			model.put("user", token.getUser().getUsername());
			model.put("resetUrl", url);
			mail.setModel(model);
			emailUtil.enviarMail(mail);
			
			rpta = 1;			
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@GetMapping(value = "/restablecer/verificar/{token}")
	public ResponseEntity<ParametrosDTO> verificarToken(@PathVariable("token") String token) {
		
		int rpta = 0;
		int usua = 0;
		
		ParametrosDTO para =new ParametrosDTO();
		para.setIdCliente(rpta);
		para.setIdUsuario(usua);
		try {
			if (token != null && !token.isEmpty()) {
				ResetToken rt = tokenService.findByToken(token);
				if (rt != null && rt.getId() > 0) {
					if (!rt.estaExpirado()) {
						rpta = 1;
						usua = rt.getUser().getIdUsuario();
					}
				}
			}
		} catch (Exception e) {
			return new ResponseEntity<ParametrosDTO>(para, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		para.setIdCliente(rpta);
		para.setIdUsuario(usua);
		return new ResponseEntity<ParametrosDTO>(para, HttpStatus.OK);
	}
	
	@PostMapping(value = "/restablecer/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> restablecerClave(@PathVariable("token") String token, @RequestBody String clave) {		
		try {
			ResetToken rt = tokenService.findByToken(token);			
			service.cambiarClave(clave, rt.getUser().getUsername());
			tokenService.eliminar(rt);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/actualizarIntento")
	public ResponseEntity<Void> actualizarIntento(@RequestBody ParametrosDTO filtro) {
		service.cambiarIntento(filtro.getLoginAgente());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
