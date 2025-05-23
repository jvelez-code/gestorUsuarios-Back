package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "gestion")
public class Gestion implements Serializable {
	
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
	private Boolean flagGestionSucursal;
	
	@ManyToOne()
	@JoinColumn(name = "id_estado_gestion")
	private EstadoGestion estadoGestion;
	
	@ManyToOne()
	@JoinColumn(name = "id_agente")
	private Usuario agente;
	
		
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
	
//	@OneToMany(fetch = FetchType.EAGER)
//	//@OneToMany(mappedBy = "gestion")
//	@OrderBy("nroDocumento")	
//	private List<Empleado> listaEmpleado;
	
	@OneToMany(mappedBy = "gestion", cascade = { CascadeType.ALL }, orphanRemoval = true )	
	private List<DetalleGestion> listaDetalleGestion;
	
	@OneToMany(mappedBy = "gestion", cascade = { CascadeType.ALL }, orphanRemoval = true)	
	private List<DetalleGestionComercial> listaDetalleGestionComercial;

	@OneToMany(mappedBy = "gestion", cascade = { CascadeType.ALL }, orphanRemoval = true)	
	private List<SeguimientoComercial> listaSeguimientoComercial;
	
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

	public Gestion() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public Gestion(Integer idGestion, Archivo archivo, Campana campana, Cliente cliente, Boolean flagGestionSucursal,
			EstadoGestion estadoGestion, Usuario agente, Date fechaGestion, BigInteger valorCotizacion,
			String usuarioAct, String ipAct, List<Contacto> listaContacto, List<DetalleGestion> listaDetalleGestion,
			List<DetalleGestionComercial> listaDetalleGestionComercial,
			List<SeguimientoComercial> listaSeguimientoComerciall, Archivo archivoExclusion, Date fechaAgenda,
			Integer idGestionPadre, Date fechaHoraSis, String callid) {
		super();
		this.idGestion = idGestion;
		this.archivo = archivo;
		this.campana = campana;
		this.cliente = cliente;
		this.flagGestionSucursal = flagGestionSucursal;
		this.estadoGestion = estadoGestion;
		this.agente = agente;
		this.fechaGestion = fechaGestion;
		this.valorCotizacion = valorCotizacion;
		this.usuarioAct = usuarioAct;
		this.ipAct = ipAct;
		this.listaContacto = listaContacto;
		this.listaDetalleGestion = listaDetalleGestion;
		this.listaDetalleGestionComercial = listaDetalleGestionComercial;
		this.listaSeguimientoComercial = listaSeguimientoComercial;
		this.archivoExclusion = archivoExclusion;
		this.fechaAgenda = fechaAgenda;
		this.idGestionPadre = idGestionPadre;
		this.fechaHoraSis = fechaHoraSis;
		this.callid = callid;
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

	public Boolean getFlagGestionSucursal() {
		return flagGestionSucursal;
	}

	public void setFlagGestionSucursal(Boolean flagGestionSucursal) {
		this.flagGestionSucursal = flagGestionSucursal;
	}

	public EstadoGestion getEstadoGestion() {
		return estadoGestion;
	}

	public void setEstadoGestion(EstadoGestion estadoGestion) {
		this.estadoGestion = estadoGestion;
	}

	public Usuario getAgente() {
		return agente;
	}

	public void setAgente(Usuario agente) {
		this.agente = agente;
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

	public List<DetalleGestion> getListaDetalleGestion() {
		return listaDetalleGestion;
	}

	public void setListaDetalleGestion(List<DetalleGestion> listaDetalleGestion) {
		this.listaDetalleGestion = listaDetalleGestion;
	}

	public List<DetalleGestionComercial> getListaDetalleGestionComercial() {
		return listaDetalleGestionComercial;
	}

	public void setListaDetalleGestionComercial(List<DetalleGestionComercial> listaDetalleGestionComercial) {
		this.listaDetalleGestionComercial = listaDetalleGestionComercial;
	}

	public List<SeguimientoComercial> getListaSeguimientoComercial() {
		return listaSeguimientoComercial;
	}

	public void setListaSeguimientoComerciall(List<SeguimientoComercial> listaSeguimientoComercial) {
		this.listaSeguimientoComercial = listaSeguimientoComercial;
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
	
		
}
