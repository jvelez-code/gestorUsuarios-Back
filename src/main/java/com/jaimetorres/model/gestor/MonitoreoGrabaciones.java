package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "monitoreo_grabaciones")
public class MonitoreoGrabaciones implements Serializable {
	
	
	private static final long serialVersionUID = 771876561946988803L;
	@Id
	@SequenceGenerator(name = "MonitoreoGrabaciones.sequence", sequenceName = "monitoreo_grabaciones_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MonitoreoGrabaciones.sequence")
    @Column(name = "id_monitoreo")
	private Integer idMonitoreo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "fecha_monitoreo")
    private LocalDateTime fechaMonitoreo;
	
	@ManyToOne()
	@JoinColumn(name = "monitoreo_calidad", nullable = false, foreignKey =  @ForeignKey(name = "fk_monitoreo_calidad"))
	private Usuario usuarioc;
	
	@ManyToOne()
	@JoinColumn(name = "monitoreo_usuario", nullable = false, foreignKey =  @ForeignKey(name = "fk_monitoreo_usuario"))
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name = "monitoreo_cliente", nullable = false, foreignKey =  @ForeignKey(name = "fk_monitoreo_cliente"))
	private Cliente cliente;
	
	@ManyToOne()
	@JoinColumn(name = "plan_accion", nullable = false, foreignKey =  @ForeignKey(name = "fk_monitoreo_planaccion"))
	private MonitoreoPlandeaccion monitoreoPlandeaccion;
		
	@Column(name = "canal_comunicacion")    
	private String canalComunicacion;
	
	@Column(name = "monitoreo_observacion")   	
	private String monitoreoObservacion;	
	
	@Column(name = "calificacion_total")
    private Integer calificacionTotal;

	public MonitoreoGrabaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonitoreoGrabaciones(Integer idMonitoreo, LocalDateTime fechaMonitoreo, Usuario usuarioc, Usuario usuario,
			Cliente cliente, MonitoreoPlandeaccion monitoreoPlandeaccion, String canalComunicacion,
			String monitoreoObservacion, Integer calificacionTotal) {
		super();
		this.idMonitoreo = idMonitoreo;
		this.fechaMonitoreo = fechaMonitoreo;
		this.usuarioc = usuarioc;
		this.usuario = usuario;
		this.cliente = cliente;
		this.monitoreoPlandeaccion = monitoreoPlandeaccion;
		this.canalComunicacion = canalComunicacion;
		this.monitoreoObservacion = monitoreoObservacion;
		this.calificacionTotal = calificacionTotal;
	}

	public Integer getIdMonitoreo() {
		return idMonitoreo;
	}

	public void setIdMonitoreo(Integer idMonitoreo) {
		this.idMonitoreo = idMonitoreo;
	}

	public LocalDateTime getFechaMonitoreo() {
		return fechaMonitoreo;
	}

	public void setFechaMonitoreo(LocalDateTime fechaMonitoreo) {
		this.fechaMonitoreo = fechaMonitoreo;
	}

	public Usuario getUsuarioc() {
		return usuarioc;
	}

	public void setUsuarioc(Usuario usuarioc) {
		this.usuarioc = usuarioc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public MonitoreoPlandeaccion getMonitoreoPlandeaccion() {
		return monitoreoPlandeaccion;
	}

	public void setMonitoreoPlandeaccion(MonitoreoPlandeaccion monitoreoPlandeaccion) {
		this.monitoreoPlandeaccion = monitoreoPlandeaccion;
	}

	public String getCanalComunicacion() {
		return canalComunicacion;
	}

	public void setCanalComunicacion(String canalComunicacion) {
		this.canalComunicacion = canalComunicacion;
	}

	public String getMonitoreoObservacion() {
		return monitoreoObservacion;
	}

	public void setMonitoreoObservacion(String monitoreoObservacion) {
		this.monitoreoObservacion = monitoreoObservacion;
	}

	public Integer getCalificacionTotal() {
		return calificacionTotal;
	}

	public void setCalificacionTotal(Integer calificacionTotal) {
		this.calificacionTotal = calificacionTotal;
	}

	

}
