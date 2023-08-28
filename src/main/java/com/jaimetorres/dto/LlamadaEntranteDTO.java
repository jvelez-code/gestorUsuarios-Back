package com.jaimetorres.dto;


public class LlamadaEntranteDTO {
	
	private String id_asterisk;
	private String numero_documento;
	private String tipo_doc;
	
	public LlamadaEntranteDTO(String id_asterisk, String numero_documento, String tipo_doc) {
		super();
		this.id_asterisk = id_asterisk;
		this.numero_documento = numero_documento;
		this.tipo_doc = tipo_doc;
	}

	public LlamadaEntranteDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId_asterisk() {
		return id_asterisk;
	}

	public void setId_asterisk(String id_asterisk) {
		this.id_asterisk = id_asterisk;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	
	
	
	
		}
