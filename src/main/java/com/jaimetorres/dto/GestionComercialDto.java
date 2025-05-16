package com.jaimetorres.dto;

public class GestionComercialDto {

	private Integer idDetalleComercial;
	private String fechaGestionCargue;
	private String tipoDocumento;
	private String nroDocumento;
	private String razonSocial;	
	private String numeroContacto;
	private String telefonoCelular;
	private String correoElectronico;
	private String ciudad;
	private String direccion;	
	private String regProyectados;	
	private String observacion;
	private String fechaGestion;
	private String usuario;
	private String contactoNombre;
	private String motivoNombre;
	private String estadoNombre;
	

	public GestionComercialDto() {
		super();
		
	}


	public GestionComercialDto(Integer idDetalleComercial, String fechaGestionCargue, String tipoDocumento,
			String nroDocumento, String razonSocial, String numeroContacto, String telefonoCelular,
			String correoElectronico, String ciudad, String direccion, String regProyectados, String observacion,
			String fechaGestion, String usuario, String contactoNombre, String motivoNombre, String estadoNombre) {
		super();
		this.idDetalleComercial = idDetalleComercial;
		this.fechaGestionCargue = fechaGestionCargue;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.razonSocial = razonSocial;
		this.numeroContacto = numeroContacto;
		this.telefonoCelular = telefonoCelular;
		this.correoElectronico = correoElectronico;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.regProyectados = regProyectados;
		this.observacion = observacion;
		this.fechaGestion = fechaGestion;
		this.usuario = usuario;
		this.contactoNombre = contactoNombre;
		this.motivoNombre = motivoNombre;
		this.estadoNombre = estadoNombre;
	}


	public Integer getIdDetalleComercial() {
		return idDetalleComercial;
	}


	public void setIdDetalleComercial(Integer idDetalleComercial) {
		this.idDetalleComercial = idDetalleComercial;
	}


	public String getFechaGestionCargue() {
		return fechaGestionCargue;
	}


	public void setFechaGestionCargue(String fechaGestionCargue) {
		this.fechaGestionCargue = fechaGestionCargue;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getNumeroContacto() {
		return numeroContacto;
	}


	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}


	public String getTelefonoCelular() {
		return telefonoCelular;
	}


	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getRegProyectados() {
		return regProyectados;
	}


	public void setRegProyectados(String regProyectados) {
		this.regProyectados = regProyectados;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getFechaGestion() {
		return fechaGestion;
	}


	public void setFechaGestion(String fechaGestion) {
		this.fechaGestion = fechaGestion;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContactoNombre() {
		return contactoNombre;
	}


	public void setContactoNombre(String contactoNombre) {
		this.contactoNombre = contactoNombre;
	}


	public String getMotivoNombre() {
		return motivoNombre;
	}


	public void setMotivoNombre(String motivoNombre) {
		this.motivoNombre = motivoNombre;
	}


	public String getEstadoNombre() {
		return estadoNombre;
	}


	public void setEstadoNombre(String estadoNombre) {
		this.estadoNombre = estadoNombre;
	}

	


}
