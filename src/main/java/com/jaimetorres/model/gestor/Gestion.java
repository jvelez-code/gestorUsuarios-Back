package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "gestion")
public class Gestion implements Serializable{
	
	private static final long serialVersionUID = 6374638625076330423L;
	@Id
	@SequenceGenerator(name = "Gestion.sequence", sequenceName = "gestion_id_gestion_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Gestion.sequence")

	@Column(name = "id_gestion")
	private Integer idGestion;
	
	@ManyToOne()
	@JoinColumn(name = "id_archivo")
	private Archivo archivo;
	
	@ManyToOne()
	@JoinColumn(name = "id_campana")
	private Campana campana;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_cliente", nullable = false, foreignKey =  @ForeignKey(name = "fk_gestion_cliente"))
	private Cliente cliente;
	
	@Column(name = "flag_gestion_sucursal")
	private String flagGestionSucursal;
	
	@ManyToOne()
	@JoinColumn(name = "id_estado_gestion")
	private EstadoGestion estadoGestion;
	
//	@JsonIgnore
//	@ManyToOne()
//	@JoinColumn(name = "id_agente")
//	private Usuario agente;
	
	@Column(name = "id_agente")   	
	private String idAgente;
	
	@Column(name = "fecha_gestion")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fechaGestion;
	
	@Column(name = "valor_cotizacion")    
	private BigInteger valorCotizacion;
	
	@Column(name = "usuario_act")    
	private String usuarioAct;
	
	@Column(name = "ip_act")   	
	private String ipAct;
	
	@OneToMany(mappedBy = "gestion", cascade = { CascadeType.ALL }, orphanRemoval = true)	
	private List<Contacto> listaContacto;
	
	@OneToMany(mappedBy = "gestion")
	@OrderBy("nroDocumento")	
	private List<Empleado> listaEmpleado;
	
	@OneToMany(mappedBy = "gestion", cascade = { CascadeType.ALL }, orphanRemoval = true )	
	private List<DetalleGestion> listaDetalleGestion;
	
	@OneToMany(mappedBy = "gestion", cascade = { CascadeType.ALL }, orphanRemoval = true)	
	private List<DetalleGestionComercial> listDetalleGestionComercial;
	
	@OneToMany(mappedBy = "gestion")	
	private List<DataIAGestion> listaDataIAGestion;
	
	@ManyToOne
	@JoinColumn(name = "id_archivo_exclusion")
	private Archivo archivoExclusion;
	
	@Column(name = "fecha_agenda")
 	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaAgenda;
	
	@Column(name = "id_gestion_padre")
    private Integer idGestionPadre;
	
	@Column(name = "fecha_hora_sis")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraSis;
	
	@Column(name = "callid")   	
	private String callid;

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

	public String getFlagGestionSucursal() {
		return flagGestionSucursal;
	}

	public void setFlagGestionSucursal(String flagGestionSucursal) {
		this.flagGestionSucursal = flagGestionSucursal;
	}

	public EstadoGestion getEstadoGestion() {
		return estadoGestion;
	}

	public void setEstadoGestion(EstadoGestion estadoGestion) {
		this.estadoGestion = estadoGestion;
	}

	
	public String getAgente() {
		return idAgente;
	}

	public void setAgente(String idAgente) {
		this.idAgente = idAgente;
	}

	public Date getFechaGestion() {
		return fechaGestion;
	}

	public void setFechaGestion(Date fechaGestion) {
		this.fechaGestion = fechaGestion;
	}

	public BigInteger getValorCotizacion() {
		return valorCotizacion;
	}

	public void setValorCotizacion(BigInteger valorCotizacion) {
		this.valorCotizacion = valorCotizacion;
	}

	public String getUsuarioAct() {
		return usuarioAct;
	}

	public void setUsuarioAct(String usuarioAct) {
		this.usuarioAct = usuarioAct;
	}

	public String getIpAct() {
		return ipAct;
	}

	public void setIpAct(String ipAct) {
		this.ipAct = ipAct;
	}

	public List<Contacto> getListaContacto() {
		return listaContacto;
	}

	public void setListaContacto(List<Contacto> listaContacto) {
		this.listaContacto = listaContacto;
	}

	public List<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}

	public void setListaEmpleado(List<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}

	public List<DetalleGestion> getListaDetalleGestion() {
		return listaDetalleGestion;
	}

	public void setListaDetalleGestion(List<DetalleGestion> listaDetalleGestion) {
		this.listaDetalleGestion = listaDetalleGestion;
	}

	public List<DetalleGestionComercial> getListDetalleGestionComercial() {
		return listDetalleGestionComercial;
	}

	public void setListDetalleGestionComercial(List<DetalleGestionComercial> listDetalleGestionComercial) {
		this.listDetalleGestionComercial = listDetalleGestionComercial;
	}

	public List<DataIAGestion> getListaDataIAGestion() {
		return listaDataIAGestion;
	}

	public void setListaDataIAGestion(List<DataIAGestion> listaDataIAGestion) {
		this.listaDataIAGestion = listaDataIAGestion;
	}

	public Archivo getArchivoExclusion() {
		return archivoExclusion;
	}

	public void setArchivoExclusion(Archivo archivoExclusion) {
		this.archivoExclusion = archivoExclusion;
	}

	public Date getFechaAgenda() {
		return fechaAgenda;
	}

	public void setFechaAgenda(Date fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}

	public Integer getIdGestionPadre() {
		return idGestionPadre;
	}

	public void setIdGestionPadre(Integer idGestionPadre) {
		this.idGestionPadre = idGestionPadre;
	}

	public Date getFechaHoraSis() {
		return fechaHoraSis;
	}

	public void setFechaHoraSis(Date fechaHoraSis) {
		this.fechaHoraSis = fechaHoraSis;
	}

	public String getCallid() {
		return callid;
	}

	public void setCallid(String callid) {
		this.callid = callid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
		
}