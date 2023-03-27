package com.jaimetorres.model.contact;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "usuarioMigra")
public class UsuarioMigra {
	
	@Id
	private Integer idUsuario;
	
	@Column(name="nombre", nullable = false, unique = true)
	private String username;
	
	@Column(name="clave", nullable = false)
	private String password;
	
	@Column(name="estado", nullable = false)
	private String enabled;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	
	
}
