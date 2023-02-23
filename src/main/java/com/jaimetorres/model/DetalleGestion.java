package com.jaimetorres.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "detalle_gestion")
public class DetalleGestion implements Serializable {
	
	private static final long serialVersionUID = -5006418581209204590L;

	@Id
	@SequenceGenerator(name = "DetalleGestion.sequence", sequenceName = "detalle_gestion_id_detalle_gestion_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleGestion.sequence")	
	@Column(name = "id_detalle_gestion")
	private Integer idDetalleGestion;
	
	@OneToOne
	@JoinColumn(name = "id_gestion")
	private Gestion gestion;

	
	@Column(name = "fecha_gestion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaGestion;
	
	@Column(name = "observacion")
	private String observacion;
	
	@Column(name = "ip_act")
	private String ip;
	
	@Column(name = "usuario_act")
	private String usuarioAct;
	
	@Column(name = "num_real_marcado")
	private String numRealMarcado;
	
	@ManyToOne
	@JoinColumn(name = "id_agente")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_estado_gestion")
	private EstadoGestion estadoGestion;
	
	@ManyToOne
	@JoinColumn(name = "extension")
	private Extension extension;

	@Column(name = "archivo")
	private String archivo;	
	
	@Column(name = "estados")
	private String estados;
	
	@Column(name = "radicado")
	private String radicado;
	
	@Column(name = "fuente")
	private String fuente;
	
	@Column(name = "ciclo")
	private String ciclo;

	public Integer getIdDetalleGestion() {
		return idDetalleGestion;
	}

	public void setIdDetalleGestion(Integer idDetalleGestion) {
		this.idDetalleGestion = idDetalleGestion;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public Date getFechaGestion() {
		return fechaGestion;
	}

	public void setFechaGestion(Date fechaGestion) {
		this.fechaGestion = fechaGestion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsuarioAct() {
		return usuarioAct;
	}

	public void setUsuarioAct(String usuarioAct) {
		this.usuarioAct = usuarioAct;
	}

	public String getNumRealMarcado() {
		return numRealMarcado;
	}

	public void setNumRealMarcado(String numRealMarcado) {
		this.numRealMarcado = numRealMarcado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EstadoGestion getEstadoGestion() {
		return estadoGestion;
	}

	public void setEstadoGestion(EstadoGestion estadoGestion) {
		this.estadoGestion = estadoGestion;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getEstados() {
		return estados;
	}

	public void setEstados(String estados) {
		this.estados = estados;
	}

	public String getRadicado() {
		return radicado;
	}

	public void setRadicado(String radicado) {
		this.radicado = radicado;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
