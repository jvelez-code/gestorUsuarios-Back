package com.jaimetorres.dto;

public class FiltroCrmCasosDTO {


	private Integer idCaso;
	private String tipoDocumento;
	private String nroDocumento;
	private String nroRealmarcado;
	private String fechaCaso;
	private String fechaVencimiento;
	private String fechaCierre;
	private String nombreCategoria;
	private String nombreSubcategoria;
	private String nombreTipologia;
	private String nombreEstado;
	private String nombreNivel;
	private String nombreDepartamento;
	
	public FiltroCrmCasosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FiltroCrmCasosDTO(Integer idCaso, String tipoDocumento, String nroDocumento, String nroRealmarcado,
			String fechaCaso, String fechaVencimiento, String fechaCierre, String nombreCategoria,
			String nombreSubcategoria, String nombreTipologia, String nombreEstado, String nombreNivel,
			String nombreDepartamento) {
		super();
		this.idCaso = idCaso;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nroRealmarcado = nroRealmarcado;
		this.fechaCaso = fechaCaso;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaCierre = fechaCierre;
		this.nombreCategoria = nombreCategoria;
		this.nombreSubcategoria = nombreSubcategoria;
		this.nombreTipologia = nombreTipologia;
		this.nombreEstado = nombreEstado;
		this.nombreNivel = nombreNivel;
		this.nombreDepartamento = nombreDepartamento;
	}

	public Integer getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(Integer idCaso) {
		this.idCaso = idCaso;
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

	public String getNroRealmarcado() {
		return nroRealmarcado;
	}

	public void setNroRealmarcado(String nroRealmarcado) {
		this.nroRealmarcado = nroRealmarcado;
	}

	public String getFechaCaso() {
		return fechaCaso;
	}

	public void setFechaCaso(String fechaCaso) {
		this.fechaCaso = fechaCaso;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getNombreSubcategoria() {
		return nombreSubcategoria;
	}

	public void setNombreSubcategoria(String nombreSubcategoria) {
		this.nombreSubcategoria = nombreSubcategoria;
	}

	public String getNombreTipologia() {
		return nombreTipologia;
	}

	public void setNombreTipologia(String nombreTipologia) {
		this.nombreTipologia = nombreTipologia;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public String getNombreNivel() {
		return nombreNivel;
	}

	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	
	
	
}



