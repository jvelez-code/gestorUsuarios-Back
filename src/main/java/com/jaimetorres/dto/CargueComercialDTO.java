package com.jaimetorres.dto;

public class CargueComercialDTO {


	private String tipoDocumento;
	private String nroDocumento;
	private String nombreEmpresa;
	private String razonSocial;
	private String telefonoMovi;
	private String telefonoTrab;
	private String correo;
	private String direccion;
	private Integer codMunicipio;	
	private String regProyec;
	private Integer idCliente;
	
	
	public CargueComercialDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public CargueComercialDTO(String tipoDocumento, String nroDocumento, String nombreEmpresa, String razonSocial,
			String telefonoMovi, String telefonoTrab, String correo, String direccion, Integer codMunicipio,
			String regProyec, Integer idCliente) {
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreEmpresa = nombreEmpresa;
		this.razonSocial = razonSocial;
		this.telefonoMovi = telefonoMovi;
		this.telefonoTrab = telefonoTrab;
		this.correo = correo;
		this.direccion = direccion;
		this.codMunicipio = codMunicipio;
		this.regProyec = regProyec;
		this.idCliente = idCliente;
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


	public String getNombreEmpresa() {
		return nombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getTelefonoMovi() {
		return telefonoMovi;
	}


	public void setTelefonoMovi(String telefonoMovi) {
		this.telefonoMovi = telefonoMovi;
	}


	public String getTelefonoTrab() {
		return telefonoTrab;
	}


	public void setTelefonoTrab(String telefonoTrab) {
		this.telefonoTrab = telefonoTrab;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getCodMunicipio() {
		return codMunicipio;
	}


	public void setCodMunicipio(Integer codMunicipio) {
		this.codMunicipio = codMunicipio;
	}


	public String getRegProyec() {
		return regProyec;
	}


	public void setRegProyec(String regProyec) {
		this.regProyec = regProyec;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer integer) {
		this.idCliente = integer;
	}
	

}



