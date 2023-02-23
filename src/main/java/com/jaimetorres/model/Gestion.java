package com.jaimetorres.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "gestion")
public class Gestion implements Serializable{
	
	private static final long serialVersionUID = 6374638625076330423L;

	@Id
	@SequenceGenerator(name = "Gestion.sequence", sequenceName = "gestion_id_gestion_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Gestion.sequence")
	@Column(name = "id_gestion")
	private Integer idGestion;
	
	@ManyToOne
	@JoinColumn(name = "id_archivo")
	private Archivo archivo;
	
	@ManyToOne()
	@JoinColumn(name = "id_campana")
	private Campana campana;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
		
	@ManyToOne
	@JoinColumn(name = "id_estado_gestion")
	private EstadoGestion estadoGestion;	
	
	@Column(name = "fecha_gestion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaGestion;
	
	@Column(name = "id_archivo_exclusion")
	private Integer idArchivoExclusion;
	
	@ManyToOne
	@JoinColumn(name = "id_agente")
	private Usuario usuario;

	@Column(name = "ip_act")
	private String ipAct;
	
	@Column(name = "fecha_hora_sis")
	private String fechaHoraSis;
	
	@Column(name = "flag_gestion_sucursal")
	private String flagGestionSucursal;
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "valor_cotizacion")
	private String valorCotizacion;
	
	@Column(name = "fecha_agenda")
	private String fechaAgenda;
	
	
	public Gestion() {
		
	}
	
	public Gestion(Integer idGestion  ) {
		this.idGestion = idGestion;
		
	}
	
	
	

	public Integer getIdGestion() {
		return idGestion;
	}

	public void setIdGestion(Integer idGestion) {
		this.idGestion = idGestion;
	}

	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

	public Campana getCampana() {
		return campana;
	}

	public void setCampana(Campana campana) {
		this.campana = campana;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoGestion getEstadoGestion() {
		return estadoGestion;
	}

	public void setEstadoGestion(EstadoGestion estadoGestion) {
		this.estadoGestion = estadoGestion;
	}

	public Date getFechaGestion() {
		return fechaGestion;
	}

	public void setFechaGestion(Date fechaGestion) {
		this.fechaGestion = fechaGestion;
	}

	public Integer getIdArchivoExclusion() {
		return idArchivoExclusion;
	}

	public void setIdArchivoExclusion(Integer idArchivoExclusion) {
		this.idArchivoExclusion = idArchivoExclusion;
	}

	public Usuario getAgente() {
		return usuario;
	}

	public void setAgente(Usuario agente) {
		this.usuario = agente;
	}

	public String getIpAct() {
		return ipAct;
	}

	public void setIpAct(String ipAct) {
		this.ipAct = ipAct;
	}

	public String getFechaHoraSis() {
		return fechaHoraSis;
	}

	public void setFechaHoraSis(String fechaHoraSis) {
		this.fechaHoraSis = fechaHoraSis;
	}

	public String getFlagGestionSucursal() {
		return flagGestionSucursal;
	}

	public void setFlagGestionSucursal(String flagGestionSucursal) {
		this.flagGestionSucursal = flagGestionSucursal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValorCotizacion() {
		return valorCotizacion;
	}

	public void setValorCotizacion(String valorCotizacion) {
		this.valorCotizacion = valorCotizacion;
	}

	public String getFechaAgenda() {
		return fechaAgenda;
	}

	public void setFechaAgenda(String fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
}