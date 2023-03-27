package com.jaimetorres.model.contact;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ask_estado_extension")
public class AskEstadoExtension implements Serializable {
	
	private static final long serialVersionUID = 4227710170810091193L;

	@Id
	@Column(name = "id_extension")
	private Integer idExtension;
	
	
	@Column(name="login_agente", nullable = false, unique = true)
	private String loginAgente;
	
	@Column(name="estado", nullable = false)
	private Integer estadoAsk;
	
	@Column(name="numero_origen", nullable = false)
	private String numeroOrigen;
	
	@Column(name="fechahora_ultima_llamada", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fechahoraUltimaLlamada;
	
	@Column(name="fechahora_inicio_estado", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fechahoraInicioEstado;
	
	@Column(name="nro_documento", nullable = false)
	private String nroDocumento;
	
	@Column(name="empresa", nullable = false)
	private String empresaAsk;
	
	@Column(name="activo", nullable = false)
	private boolean activoAsk;	
	

	public Integer getIdExtension() {
		return idExtension;
	}

	public void setIdExtension(Integer idExtension) {
		this.idExtension = idExtension;
	}

	public Integer getEstadoAsk() {
		return estadoAsk;
	}

	public void setEstadoAsk(Integer estadoAsk) {
		this.estadoAsk = estadoAsk;
	}

	public String getLoginAgente() {
		return loginAgente;
	}

	public void setLoginAgente(String loginAgente) {
		this.loginAgente = loginAgente;
	}

	public String getNumeroOrigen() {
		return numeroOrigen;
	}

	public void setNumeroOrigen(String numeroOrigen) {
		this.numeroOrigen = numeroOrigen;
	}

	public Date getFechahoraUltimaLlamada() {
		return fechahoraUltimaLlamada;
	}

	public void setFechahoraUltimaLlamada(Date fechahoraUltimaLlamada) {
		this.fechahoraUltimaLlamada = fechahoraUltimaLlamada;
	}

	public Date getFechahoraInicioEstado() {
		return fechahoraInicioEstado;
	}

	public void setFechahoraInicioEstado(Date fechahoraInicioEstado) {
		this.fechahoraInicioEstado = fechahoraInicioEstado;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getEmpresaAsk() {
		return empresaAsk;
	}

	public void setEmpresaAsk(String empresaAsk) {
		this.empresaAsk = empresaAsk;
	}

	public boolean getActivoAsk() {
		return activoAsk;
	}

	public void setActivoAsk(boolean activoAsk) {
		this.activoAsk = activoAsk;
	}
	
	
	

}
