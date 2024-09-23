package com.jaimetorres.dto;


public class LlamadaEntranteDTO {
	
	private String idAsterisk;
	private String numeroDocumento;
	private String tipoDoc;
	private String tmoUsuario;
	private String empresa;
	private Integer idLlamadaEntrante;
	private Integer idAgente;

	public LlamadaEntranteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public LlamadaEntranteDTO(String idAsterisk, String numeroDocumento, String tipoDoc, String tmoUsuario,
			String empresa, Integer idLlamadaEntrante, Integer idAgente) {
		super();
		this.idAsterisk = idAsterisk;
		this.numeroDocumento = numeroDocumento;
		this.tipoDoc = tipoDoc;
		this.tmoUsuario = tmoUsuario;
		this.empresa = empresa;
		this.idLlamadaEntrante = idLlamadaEntrante;
		this.idAgente = idAgente;
	}


	public String getidAsterisk() {
		return idAsterisk;
	}

	public void setidAsterisk(String idAsterisk) {
		this.idAsterisk = idAsterisk;
	}

	public String getnumeroDocumento() {
		return numeroDocumento;
	}

	public void setnumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String gettipoDoc() {
		return tipoDoc;
	}

	public void settipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getTmoUsuario() {
		return tmoUsuario;
	}

	public void setTmoUsuario(String tmoUsuario) {
		this.tmoUsuario = tmoUsuario;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	public Integer getIdLlamadaEntrante() {
		return idLlamadaEntrante;
	}

	public void setIdLlamadaEntrante(Integer idLlamadaEntrante) {
		this.idLlamadaEntrante = idLlamadaEntrante;
	}

	public Integer getIdAgente() {
		return idAgente;
	}
	
	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}
	
	
	}
