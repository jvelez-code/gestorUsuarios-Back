package com.jaimetorres.dto;

public class CargueArchivoDTO {


	private String tipoDocumento;
	private String nroDocumento;
	private String razonSocial;
	private String codMunicipio;
	private String telefonoMovi;
	private String telefonoTrab;
	private String telefonoResi;
	private String correo;
	private Integer idCliente;
	
	
	public CargueArchivoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CargueArchivoDTO(String tipoDocumento, String nroDocumento, String razonSocial, String codMunicipio,
			String telefonoMovi, String telefonoTrab, String telefonoResi, String correo,
			Integer idCliente) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.razonSocial = razonSocial;
		this.codMunicipio = codMunicipio;
		this.telefonoMovi = telefonoMovi;
		this.telefonoTrab = telefonoTrab;
		this.telefonoResi = telefonoResi;
		this.correo = correo;
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


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getCodMunicipio() {
		return codMunicipio;
	}


	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
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


	public String getTelefonoResi() {
		return telefonoResi;
	}


	public void setTelefonoResi(String telefonoResi) {
		this.telefonoResi = telefonoResi;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer integer) {
		this.idCliente = integer;
	}

	

}



