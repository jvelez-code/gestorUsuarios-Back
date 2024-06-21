package com.jaimetorres.model.gestor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name = "estado", nullable = false)
	private boolean enabled;
	
	@Column(name = "fecha_cambio")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/New_York")
	private Date fechaCambio;

	@Column(name = "clave", nullable = false)
	private String password;
	
	@Column(name = "correo" , nullable = false, unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), 
	inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;
	
	@Column(name = "nombre", nullable = false, unique = true)
	private String username;
	
	@Column(name = "intentos" ,columnDefinition = "integer default 0")
	private Integer failed;
	
	
	 @Column(nullable = false)
	 @Temporal(TemporalType.TIMESTAMP)
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/New_York")
	 private Date fechaActualizacion;
	 
	 @Column(nullable = false)
	 @Temporal(TemporalType.TIMESTAMP)
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/New_York")
	 private Date fechaCreacion;

	 @Column(name = "ultimo_log")
	 private LocalDateTime ultimoLog;

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	

	public Date getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Integer getFailed() {
		return failed;
	}

	public void setFailed(Integer failed) {
		this.failed = failed;
	}
	
	@PrePersist
    protected void onCreate() {
        fechaCreacion = new Date();
        fechaActualizacion = fechaCreacion;
    }

	@PreUpdate
    protected void onUpdate() {
        fechaActualizacion = new Date();
    }

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getUltimoLog() {
		return ultimoLog;
	}

	public void setUltimoLog(LocalDateTime ultimoLog) {
		this.ultimoLog = ultimoLog;
	}

	
		

}
