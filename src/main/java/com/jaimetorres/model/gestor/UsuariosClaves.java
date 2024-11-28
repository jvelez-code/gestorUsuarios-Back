package com.jaimetorres.model.gestor;



import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "usuarios_claves")
public class UsuariosClaves implements Serializable {
	

	private static final long serialVersionUID = -5751219392582881956L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuarioclave")
	private Integer idusuarioclave;	
	
	@Column(name = "fechaactualizacion")
	private LocalDateTime fechaactualizacion;
	
	@Column(name = "clave", nullable = false)
	private String password;
	
	@Column(name = "id_usuario", nullable = false)
	private Integer idUsuario;	

	public UsuariosClaves() {
		
	}

	public UsuariosClaves(Integer idusuarioclave, LocalDateTime fechaactualizacion, String password,
			Integer idUsuario) {
		super();
		this.idusuarioclave = idusuarioclave;
		this.fechaactualizacion = fechaactualizacion;
		this.password = password;
		this.idUsuario = idUsuario;
	}

	public Integer getIdusuarioclave() {
		return idusuarioclave;
	}

	public void setIdusuarioclave(Integer idusuarioclave) {
		this.idusuarioclave = idusuarioclave;
	}

	public LocalDateTime getFechaactualizacion() {
		return fechaactualizacion;
	}

	public void setFechaactualizacion(LocalDateTime fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	
		

	}
