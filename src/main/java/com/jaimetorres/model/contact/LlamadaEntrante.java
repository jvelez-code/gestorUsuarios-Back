package com.jaimetorres.model.contact;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "llamada_entrante")
public class LlamadaEntrante implements Serializable {
	
	private static final long serialVersionUID = 7272987181261978804L;

	@Id
	@Column(name = "id_llamada_entrante", nullable = false)
	private Integer idLlamadaEntrante;
	
	@Column(name = "id_asterisk", nullable = false)
	private String idExtension;
	
	@Column(name = "ruta_entrante", nullable = false)
	private Integer ruta_entrante;
	
	@Column(name = "fecha_hora", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fecha_hora;
	
	@Column(name = "fecha_hora_asterisk", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fecha_hora_asterisk;
	
	@Column(name = "tipo_documento", nullable = false)
	private Integer tipo_documento;
	
	@Column(name = "numero_documento", nullable = false)
	private String numero_documento;
	
	@Column(name = "tipo_cliente", nullable = false)
	private Integer tipo_cliente;
	
	@Column(name = "clase_cliente", nullable = false)
	private Integer clase_cliente;
	
	@Column(name = "numero_origen", nullable = false)
	private Integer numero_origen;
	
	@Column(name = "desea_devolucion", nullable = false)
	private boolean desea_devolucion;
		
	@Column(name = "numero_devolucion", nullable = false)
	private Integer numero_devolucion;
	
	@Column(name = "id_detalle_gestion", nullable = false)
	private Integer id_detalle_gestion;
	
	@Column(name = "numero_de_intentos_fallidos", nullable = false)
	private Integer numero_de_intentos_fallidos;
	
	@Column(name = "id_agente", nullable = false)
	private Integer id_agente;
	
	@Column(name = "fecha_devolucion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fecha_devolucion;
	
	@Column(name = "opcion_entrante", nullable = false)
	private Integer opcion_entrante;
	
	@Column(name = "empresa", nullable = false)
	private String empresa;
	
	@Column(name = "intento1", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date intento1;
	
	@Column(name = "intento2", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date intento2;
	
	@Column(name = "intento3", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date intento3;

	public LlamadaEntrante(Integer idLlamadaEntrante, String idExtension, Integer ruta_entrante, Date fecha_hora,
			Date fecha_hora_asterisk, Integer tipo_documento, String numero_documento, Integer tipo_cliente,
			Integer clase_cliente, Integer numero_origen, boolean desea_devolucion, Integer numero_devolucion,
			Integer id_detalle_gestion, Integer numero_de_intentos_fallidos, Integer id_agente, Date fecha_devolucion,
			Integer opcion_entrante, String empresa, Date intento1, Date intento2, Date intento3) {
		super();
		this.idLlamadaEntrante = idLlamadaEntrante;
		this.idExtension = idExtension;
		this.ruta_entrante = ruta_entrante;
		this.fecha_hora = fecha_hora;
		this.fecha_hora_asterisk = fecha_hora_asterisk;
		this.tipo_documento = tipo_documento;
		this.numero_documento = numero_documento;
		this.tipo_cliente = tipo_cliente;
		this.clase_cliente = clase_cliente;
		this.numero_origen = numero_origen;
		this.desea_devolucion = desea_devolucion;
		this.numero_devolucion = numero_devolucion;
		this.id_detalle_gestion = id_detalle_gestion;
		this.numero_de_intentos_fallidos = numero_de_intentos_fallidos;
		this.id_agente = id_agente;
		this.fecha_devolucion = fecha_devolucion;
		this.opcion_entrante = opcion_entrante;
		this.empresa = empresa;
		this.intento1 = intento1;
		this.intento2 = intento2;
		this.intento3 = intento3;
	}

	public LlamadaEntrante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdLlamadaEntrante() {
		return idLlamadaEntrante;
	}

	public void setIdLlamadaEntrante(Integer idLlamadaEntrante) {
		this.idLlamadaEntrante = idLlamadaEntrante;
	}

	public String getIdExtension() {
		return idExtension;
	}

	public void setIdExtension(String idExtension) {
		this.idExtension = idExtension;
	}

	public Integer getRuta_entrante() {
		return ruta_entrante;
	}

	public void setRuta_entrante(Integer ruta_entrante) {
		this.ruta_entrante = ruta_entrante;
	}

	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public Date getFecha_hora_asterisk() {
		return fecha_hora_asterisk;
	}

	public void setFecha_hora_asterisk(Date fecha_hora_asterisk) {
		this.fecha_hora_asterisk = fecha_hora_asterisk;
	}

	public Integer getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(Integer tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public Integer getTipo_cliente() {
		return tipo_cliente;
	}

	public void setTipo_cliente(Integer tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}

	public Integer getClase_cliente() {
		return clase_cliente;
	}

	public void setClase_cliente(Integer clase_cliente) {
		this.clase_cliente = clase_cliente;
	}

	public Integer getNumero_origen() {
		return numero_origen;
	}

	public void setNumero_origen(Integer numero_origen) {
		this.numero_origen = numero_origen;
	}

	public boolean isDesea_devolucion() {
		return desea_devolucion;
	}

	public void setDesea_devolucion(boolean desea_devolucion) {
		this.desea_devolucion = desea_devolucion;
	}

	public Integer getNumero_devolucion() {
		return numero_devolucion;
	}

	public void setNumero_devolucion(Integer numero_devolucion) {
		this.numero_devolucion = numero_devolucion;
	}

	public Integer getId_detalle_gestion() {
		return id_detalle_gestion;
	}

	public void setId_detalle_gestion(Integer id_detalle_gestion) {
		this.id_detalle_gestion = id_detalle_gestion;
	}

	public Integer getNumero_de_intentos_fallidos() {
		return numero_de_intentos_fallidos;
	}

	public void setNumero_de_intentos_fallidos(Integer numero_de_intentos_fallidos) {
		this.numero_de_intentos_fallidos = numero_de_intentos_fallidos;
	}

	public Integer getId_agente() {
		return id_agente;
	}

	public void setId_agente(Integer id_agente) {
		this.id_agente = id_agente;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public Integer getOpcion_entrante() {
		return opcion_entrante;
	}

	public void setOpcion_entrante(Integer opcion_entrante) {
		this.opcion_entrante = opcion_entrante;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Date getIntento1() {
		return intento1;
	}

	public void setIntento1(Date intento1) {
		this.intento1 = intento1;
	}

	public Date getIntento2() {
		return intento2;
	}

	public void setIntento2(Date intento2) {
		this.intento2 = intento2;
	}

	public Date getIntento3() {
		return intento3;
	}

	public void setIntento3(Date intento3) {
		this.intento3 = intento3;
	}
	
	
	
	

}
