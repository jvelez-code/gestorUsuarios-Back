package com.jaimetorres.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

//Captura las variables del front para gestion Entrante
public class ParametrosDTO {
	
	private String tipo;
	private String tipoDoc;
	private String loginAgente;
	private Integer idUsuario;
	private List<Integer> idUsuarios;
	private String nroDocumento;
	private Integer idCliente;
	private Integer idEmpresa;
	private Integer idTipoCampana;
	private Integer idEstadoPadre;
	private Integer tipoLlamada;
	private Integer idDetalleComer;
	private Integer cicloVida;
	private Integer campanaSal;
	private Integer idGestion;
	private String nombreArchivo;
	private Integer clienteNuevo;
	private Integer gestionNuevo;
	private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaInicial;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaFinal;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime ultimoLogin;
	//CRM
	private Integer idCrmDetalle;
	private Integer idCrmCaso;
	private Integer idCrmEstado;
	private Integer idExtension;
	
	
	public ParametrosDTO() {
	}
	
	public ParametrosDTO(String tipo, String tipoDoc, String loginAgente, Integer idUsuario, List<Integer> idUsuarios,
			String nroDocumento, Integer idCliente, Integer idEmpresa, Integer idTipoCampana, Integer idEstadoPadre,
			Integer tipoLlamada, Integer idDetalleComer, Integer cicloVida, Integer campanaSal, Integer idGestion,
			String nombreArchivo, Integer clienteNuevo, Integer gestionNuevo, LocalDateTime fechaInicial,
			LocalDateTime fechaFinal, LocalDateTime ultimoLogin, Integer idCrmDetalle, Integer idCrmCaso,
			Integer idCrmEstado, Integer idExtension,String password) {
		super();
		this.tipo = tipo;
		this.tipoDoc = tipoDoc;
		this.loginAgente = loginAgente;
		this.idUsuario = idUsuario;
		this.idUsuarios = idUsuarios;
		this.nroDocumento = nroDocumento;
		this.idCliente = idCliente;
		this.idEmpresa = idEmpresa;
		this.idTipoCampana = idTipoCampana;
		this.idEstadoPadre = idEstadoPadre;
		this.tipoLlamada = tipoLlamada;
		this.idDetalleComer = idDetalleComer;
		this.cicloVida = cicloVida;
		this.campanaSal = campanaSal;
		this.idGestion = idGestion;
		this.nombreArchivo = nombreArchivo;
		this.clienteNuevo = clienteNuevo;
		this.gestionNuevo = gestionNuevo;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.ultimoLogin = ultimoLogin;
		this.idCrmDetalle = idCrmDetalle;
		this.idCrmCaso = idCrmCaso;
		this.idCrmEstado = idCrmEstado;
		this.idExtension = idExtension;
		this.password = password;
	}





	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public String getLoginAgente() {
		return loginAgente;
	}

	public void setLoginAgente(String loginAgente) {
		this.loginAgente = loginAgente;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public Integer getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public Integer getIdTipoCampana() {
		return idTipoCampana;
	}


	public void setIdTipoCampana(Integer idTipoCampana) {
		this.idTipoCampana = idTipoCampana;
	}


	public Integer getIdEstadoPadre() {
		return idEstadoPadre;
	}


	public void setIdEstadoPadre(Integer idEstadoPadre) {
		this.idEstadoPadre = idEstadoPadre;
	}


	public Integer getTipoLlamada() {
		return tipoLlamada;
	}


	public void setTipoLlamada(Integer tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}


	public Integer getIdDetalleComer() {
		return idDetalleComer;
	}


	public void setIdDetalleComer(Integer idDetalleComer) {
		this.idDetalleComer = idDetalleComer;
	}


	public Integer getCicloVida() {
		return cicloVida;
	}


	public void setCicloVida(Integer cicloVida) {
		this.cicloVida = cicloVida;
	}


	public LocalDateTime getFechaInicial() {
		return fechaInicial;
	}


	public void setFechaInicial(LocalDateTime fechaInicial) {
		this.fechaInicial = fechaInicial;
	}


	public LocalDateTime getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(LocalDateTime fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public Integer getCampanaSal() {
		return campanaSal;
	}


	public void setCampanaSal(Integer campanaSal) {
		this.campanaSal = campanaSal;
	}


	public Integer getIdGestion() {
		return idGestion;
	}


	public void setIdGestion(Integer idGestion) {
		this.idGestion = idGestion;
	}


	public Integer getIdCrmDetalle() {
		return idCrmDetalle;
	}


	public void setIdCrmDetalle(Integer idCrmDetalle) {
		this.idCrmDetalle = idCrmDetalle;
	}


	public Integer getIdCrmCaso() {
		return idCrmCaso;
	}


	public void setIdCrmCaso(Integer idCrmCaso) {
		this.idCrmCaso = idCrmCaso;
	}


	public LocalDateTime getUltimoLogin() {
		return ultimoLogin;
	}


	public void setUltimoLogin(LocalDateTime ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}


	public Integer getIdCrmEstado() {
		return idCrmEstado;
	}


	public void setIdCrmEstado(Integer idCrmEstado) {
		this.idCrmEstado = idCrmEstado;
	}



	public String getNombreArchivo() {
		return nombreArchivo;
	}



	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}


	public Integer getClienteNuevo() {
		return clienteNuevo;
	}


	public void setClienteNuevo(Integer clienteNuevo) {
		this.clienteNuevo = clienteNuevo;
	}


	public Integer getGestionNuevo() {
		return gestionNuevo;
	}


	public void setGestionNuevo(Integer gestionNuevo) {
		this.gestionNuevo = gestionNuevo;
	}
	
	public Integer getIdExtension() {
		return idExtension;
	}

	public void setIdExtension(Integer idExtension) {
		this.idExtension = idExtension;
	}

	public List<Integer> getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(List<Integer> idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    	

	
}
