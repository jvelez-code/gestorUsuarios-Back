package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fidelizacion_comercial")
public class FidelizacionComercial implements Serializable {
	
	private static final long serialVersionUID = -909396822758302932L;

	@Id
	@SequenceGenerator(name = "FidelizacionComercial.sequence", sequenceName = "fidelizacion_comercial_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FidelizacionComercial.sequence")	
	@Column(name = "id_fidelizacion")
	private Integer idFidelizacion;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_detalle_gestion_comercial", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_gestion_comercial"))
	//@Column(name = "id_detalle_gestion_comercial")
	private DetalleGestionComercial idDetalleGestionComercial;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente"))
	//@Column(name = "id_cliente")
	private Cliente idCliente;
	
	
	@ManyToOne
	@JoinColumn(name = "id_agente", nullable = false, foreignKey = @ForeignKey(name = "fk_agente_fidelizacion"))
	//@Column(name = "id_agente")
	private Usuario idUsuario;
	
	@Column(name = "cod_caja")
	private String codCaja;
	
	@Column(name = "registros_nuevos")
	private Integer registrosNuevos;
	
	@Column(name = "registros_recuperados")
	private Integer registrosRecuperados;
	
	@Column(name = "fecha_pago")
	private String fechaPago;
	
	@Column(name = "numero_planilla")
	private String numeroPlanilla;
	
	@Column(name = "observacion")
	private String observacion;
	
	@Column(name = "migracion")
	private String migracion;
	
	@Column(name = "sucursal")
	private String sucursal;
	
	@Column(name = "fecha_gestion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaGestion;

	public FidelizacionComercial() {
		super();
		// TODO Auto-generated constructor stub
	}

     

	public FidelizacionComercial(Integer idFidelizacion, DetalleGestionComercial idDetalleGestionComercial,
			Cliente idCliente, Usuario idUsuario, String codCaja, Integer registrosNuevos,
			Integer registrosRecuperados, String fechaPago, String numeroPlanilla, String observacion, String migracion,
			String sucursal, Date fechaGestion) {
		super();
		this.idFidelizacion = idFidelizacion;
		this.idDetalleGestionComercial = idDetalleGestionComercial;
		this.idCliente = idCliente;
		this.idUsuario = idUsuario;
		this.codCaja = codCaja;
		this.registrosNuevos = registrosNuevos;
		this.registrosRecuperados = registrosRecuperados;
		this.fechaPago = fechaPago;
		this.numeroPlanilla = numeroPlanilla;
		this.observacion = observacion;
		this.migracion = migracion;
		this.sucursal = sucursal;
		this.fechaGestion = fechaGestion;
	}



	public Integer getIdFidelizacion() {
		return idFidelizacion;
	}

	public void setIdFidelizacion(Integer idFidelizacion) {
		this.idFidelizacion = idFidelizacion;
	}

	public DetalleGestionComercial getIdDetalleGestionComercial() {
		return idDetalleGestionComercial;
	}

	public void setIdDetalleGestionComercial(DetalleGestionComercial idDetalleGestionComercial) {
		this.idDetalleGestionComercial = idDetalleGestionComercial;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodCaja() {
		return codCaja;
	}

	public void setCodCaja(String codCaja) {
		this.codCaja = codCaja;
	}

	public Integer getRegistrosNuevos() {
		return registrosNuevos;
	}

	public void setRegistrosNuevos(Integer registrosNuevos) {
		this.registrosNuevos = registrosNuevos;
	}

	public Integer getRegistrosRecuperados() {
		return registrosRecuperados;
	}

	public void setRegistrosRecuperados(Integer registrosRecuperados) {
		this.registrosRecuperados = registrosRecuperados;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getNumeroPlanilla() {
		return numeroPlanilla;
	}

	public void setNumeroPlanilla(String numeroPlanilla) {
		this.numeroPlanilla = numeroPlanilla;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getMigracion() {
		return migracion;
	}

	public void setMigracion(String migracion) {
		this.migracion = migracion;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Date getFechaGestion() {
		return fechaGestion;
	}

	public void setFechaGestion(Date fechaGestion) {
		this.fechaGestion = fechaGestion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	}
