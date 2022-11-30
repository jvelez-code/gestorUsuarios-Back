package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "contacto")
public class Contacto  implements Serializable {

	private static final long serialVersionUID = -5757644254483773808L;
	
	@Id
	@SequenceGenerator(name = "Contacto.sequence", sequenceName = "contacto_id_contacto_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Contacto.sequence")	
	@Column(name = "id_contacto")
	private Integer idContacto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gestion")
	private Gestion gestion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_zona")
	private Divipola divipola;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agente")
	private Usuario usuario;
	
	@Column(name = "numero_contacto")
	private String numeroContacto;
	
	@Column(name = "correo_electronico")
	private String correoElectronico;
	
	@Column(name = "telefono_directo")
	private String telefonoDirecto;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "estrategia")
	private String estrategia;
	
	@Column(name = "indicativo_pais")
	private Integer indicativoPais;
	
	@Column(name = "telefono_celular")
	private String telefonoCelular;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "principal")
	private Boolean principal;
	
	@Column(name = "indicativo_area")
	private Integer indicativoArea;
	
	@Column(name = "estado")
	private Integer estado;
	
	@Column(name = "nro_empleado")
	private Integer nroEmpleado;

	public Integer getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public Divipola getDivipola() {
		return divipola;
	}

	public void setDivipola(Divipola divipola) {
		this.divipola = divipola;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefonoDirecto() {
		return telefonoDirecto;
	}

	public void setTelefonoDirecto(String telefonoDirecto) {
		this.telefonoDirecto = telefonoDirecto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}

	public Integer getIndicativoPais() {
		return indicativoPais;
	}

	public void setIndicativoPais(Integer indicativoPais) {
		this.indicativoPais = indicativoPais;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public Integer getIndicativoArea() {
		return indicativoArea;
	}

	public void setIndicativoArea(Integer indicativoArea) {
		this.indicativoArea = indicativoArea;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(Integer nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
