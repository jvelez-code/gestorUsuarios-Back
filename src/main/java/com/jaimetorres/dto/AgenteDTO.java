package com.jaimetorres.dto;


public class AgenteDTO {
	
	private Integer idUsuario;
	private String usuario;
	private String nroDocumento;
	private String primerNombre;
	private String primerApellido;
	private Integer idEmpresa;
	private String pseudonimo;
	private String descripcion;
	private Integer idCampanaE;
	private String nombreCamE;
	private String tipoLlamadaCamE;
	private Integer idCampanaS;
	private String nombreCamS;
	private String tipoLlamadaCamS;
	private String hostIp;
	
	
	public AgenteDTO(Integer idUsuario, String usuario, String nroDocumento, String primerNombre, String primerApellido,
			Integer idEmpresa, String pseudonimo, String descripcion, Integer idCampanaE, String nombreCamE,
			String tipoLlamadaCamE, Integer idCampanaS, String nombreCamS, String tipoLlamadaCamS, String hostIp) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.nroDocumento = nroDocumento;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.idEmpresa = idEmpresa;
		this.pseudonimo = pseudonimo;
		this.descripcion = descripcion;
		this.idCampanaE = idCampanaE;
		this.nombreCamE = nombreCamE;
		this.tipoLlamadaCamE = tipoLlamadaCamE;
		this.idCampanaS = idCampanaS;
		this.nombreCamS = nombreCamS;
		this.tipoLlamadaCamS = tipoLlamadaCamS;
		this.hostIp = hostIp;
	}
	public AgenteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getPseudonimo() {
		return pseudonimo;
	}
	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdCampanaE() {
		return idCampanaE;
	}
	public void setIdCampanaE(Integer idCampanaE) {
		this.idCampanaE = idCampanaE;
	}
	public String getNombreCamE() {
		return nombreCamE;
	}
	public void setNombreCamE(String nombreCamE) {
		this.nombreCamE = nombreCamE;
	}
	public String getTipoLlamadaCamE() {
		return tipoLlamadaCamE;
	}
	public void setTipoLlamadaCamE(String tipoLlamadaCamE) {
		this.tipoLlamadaCamE = tipoLlamadaCamE;
	}
	public Integer getIdCampanaS() {
		return idCampanaS;
	}
	public void setIdCampanaS(Integer idCampanaS) {
		this.idCampanaS = idCampanaS;
	}
	public String getNombreCamS() {
		return nombreCamS;
	}
	public void setNombreCamS(String nombreCamS) {
		this.nombreCamS = nombreCamS;
	}
	public String getTipoLlamadaCamS() {
		return tipoLlamadaCamS;
	}
	public void setTipoLlamadaCamS(String tipoLlamadaCamS) {
		this.tipoLlamadaCamS = tipoLlamadaCamS;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	
	
	
	}
