package com.jaimetorres.model.contact;

import java.io.Serializable;
import java.time.LocalDateTime;
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
	private String rutaEntrante;
	
	@Column(name = "fecha_hora", nullable = false)
	private LocalDateTime fechaHora;
	
	@Column(name = "fecha_hora_asterisk", nullable = false)
	private LocalDateTime fechaHoraAsterisk;
	
	@ManyToOne
	@JoinColumn(name = "tipo_documento", referencedColumnName ="id")
	private tipoDocumento tipoDocumento;
	
	@Column(name = "numero_documento", nullable = false)
	private String numeroDocumento;
	
	@Column(name = "tipo_cliente", nullable = false)
	private Integer tipoCliente;
	
	@Column(name = "clase_cliente", nullable = false)
	private Integer claseCliente;
	
	@Column(name = "numero_origen", nullable = false)
	private String numeroOrigen;
	
	@Column(name = "desea_devolucion", nullable = false)
	private boolean deseaDevolucion;
		
	@Column(name = "numero_devolucion", nullable = false)
	private String numeroDevolucion;
	
	@Column(name = "id_detalle_gestion", nullable = false)
	private Integer idDetalleGestion;
	
	@Column(name = "numero_de_intentos_fallidos", nullable = false)
	private Integer numeroIntentosFallidos;
	
	@Column(name = "id_agente", nullable = false)
	private Integer idAgente;
	
	@Column(name = "fecha_devolucion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fechaDevolucion;
	
	@Column(name = "opcion_entrante", nullable = false)
	private Integer opcionEntrante;
	
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
	
	public LlamadaEntrante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LlamadaEntrante(Integer idLlamadaEntrante, String idExtension, String rutaEntrante, LocalDateTime fechaHora,
			LocalDateTime fechaHoraAsterisk, com.jaimetorres.model.contact.tipoDocumento tipoDocumento,
			String numeroDocumento, Integer tipoCliente, Integer claseCliente, String numeroOrigen,
			boolean deseaDevolucion, String numeroDevolucion, Integer idDetalleGestion, Integer numeroIntentosFallidos,
			Integer idAgente, Date fechaDevolucion, Integer opcionEntrante, String empresa, Date intento1,
			Date intento2, Date intento3) {
		super();
		this.idLlamadaEntrante = idLlamadaEntrante;
		this.idExtension = idExtension;
		this.rutaEntrante = rutaEntrante;
		this.fechaHora = fechaHora;
		this.fechaHoraAsterisk = fechaHoraAsterisk;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.tipoCliente = tipoCliente;
		this.claseCliente = claseCliente;
		this.numeroOrigen = numeroOrigen;
		this.deseaDevolucion = deseaDevolucion;
		this.numeroDevolucion = numeroDevolucion;
		this.idDetalleGestion = idDetalleGestion;
		this.numeroIntentosFallidos = numeroIntentosFallidos;
		this.idAgente = idAgente;
		this.fechaDevolucion = fechaDevolucion;
		this.opcionEntrante = opcionEntrante;
		this.empresa = empresa;
		this.intento1 = intento1;
		this.intento2 = intento2;
		this.intento3 = intento3;
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

	public String getRutaEntrante() {
		return rutaEntrante;
	}

	public void setRutaEntrante(String rutaEntrante) {
		this.rutaEntrante = rutaEntrante;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public LocalDateTime getFechaHoraAsterisk() {
		return fechaHoraAsterisk;
	}

	public void setFechaHoraAsterisk(LocalDateTime fechaHoraAsterisk) {
		this.fechaHoraAsterisk = fechaHoraAsterisk;
	}

	public tipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(tipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Integer getClaseCliente() {
		return claseCliente;
	}

	public void setClaseCliente(Integer claseCliente) {
		this.claseCliente = claseCliente;
	}

	public String getNumeroOrigen() {
		return numeroOrigen;
	}

	public void setNumeroOrigen(String numeroOrigen) {
		this.numeroOrigen = numeroOrigen;
	}

	public boolean isDeseaDevolucion() {
		return deseaDevolucion;
	}

	public void setDeseaDevolucion(boolean deseaDevolucion) {
		this.deseaDevolucion = deseaDevolucion;
	}

	public String getNumeroDevolucion() {
		return numeroDevolucion;
	}

	public void setNumeroDevolucion(String numeroDevolucion) {
		this.numeroDevolucion = numeroDevolucion;
	}

	public Integer getIdDetalleGestion() {
		return idDetalleGestion;
	}

	public void setIdDetalleGestion(Integer idDetalleGestion) {
		this.idDetalleGestion = idDetalleGestion;
	}

	public Integer getNumeroIntentosFallidos() {
		return numeroIntentosFallidos;
	}

	public void setNumeroIntentosFallidos(Integer numeroIntentosFallidos) {
		this.numeroIntentosFallidos = numeroIntentosFallidos;
	}

	public Integer getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Integer getOpcionEntrante() {
		return opcionEntrante;
	}

	public void setOpcionEntrante(Integer opcionEntrante) {
		this.opcionEntrante = opcionEntrante;
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
