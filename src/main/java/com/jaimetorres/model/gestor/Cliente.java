package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 2777775720652507458L;

	@Id
	@SequenceGenerator(name = "Cliente.sequence", sequenceName = "cliente_id_cliente_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cliente.sequence")	
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	@ManyToOne()
	@JoinColumn(name = "tipo_documento")
	private TipoDocumento tipoDocumento;
	
	@Column(name = "nro_documento")
	private String nroDocumento;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "razon_social")
	private String razonSocial;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "cantidad_empleados")
	private String cantidadEmpleados;
	
	@Column(name = "fecha_hora_sis")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraSistema;
	
	@Column(name = "ip_act")
	private String ip;
	
	@Column(name = "usuario_act")
	private String usuario;
	
	@Column(name = "telefono_celular")
	private String telefonoCelular;
	
	@Column(name = "telefono_fijo")
	private String telefonoFijo;
	
	@Column(name = "ley_1581")
	private Boolean ley1581;
	
//	@Column(name = "id_zona")
//	private Integer idZona;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_zona")
	private Divipola divipola;	
//	
//	@OneToMany(mappedBy = "cliente")
//	private List<DataIACliente> listaDataIACliente; 
//	
	@Transient
	private String ubicacion;
	
	public Cliente(){}
	
	public Cliente(TipoDocumento tipoDoc, String nroDoc, String razonSocial,
			String direccion) {
		this.tipoDocumento = tipoDoc;
		this.nroDocumento = nroDoc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;	
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(String cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public Date getFechaHoraSistema() {
		return fechaHoraSistema;
	}

	public void setFechaHoraSistema(Date fechaHoraSistema) {
		this.fechaHoraSistema = fechaHoraSistema;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public Boolean getLey1581() {
		return ley1581;
	}

	public void setLey1581(Boolean ley1581) {
		this.ley1581 = ley1581;
	}

	public Divipola getDivipola() {
		return divipola;
	}

	public void setDivipola(Divipola divipola) {
		this.divipola = divipola;
	}

//	public List<DataIACliente> getListaDataIACliente() {
//		return listaDataIACliente;
//	}
//
//	public void setListaDataIACliente(List<DataIACliente> listaDataIACliente) {
//		this.listaDataIACliente = listaDataIACliente;
//	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
