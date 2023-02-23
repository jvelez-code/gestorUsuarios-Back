package com.jaimetorres.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "detalle_horario")
public class DetalleHorario implements Serializable {

	private static final long serialVersionUID = 7148238601619759721L;
	
	@Id
    @SequenceGenerator(name = "DetalleHorario.sequence", sequenceName = "detalle_horario_id_detalle_horario_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleHorario.sequence")	
    @Column(name = "id_detalle_horario")
    private Long idDetalleHorario;
    @Basic(optional = false)
    
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Basic(optional = false)
    
    @Column(name = "fecha_activacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivacion;
    
    @Column(name = "fecha_inactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInactivacion;
    
    @JoinColumn(name = "id_agente", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    @JoinColumn(name = "extension", referencedColumnName = "extension")
    @ManyToOne(optional = false)
    private Extension extension;
    
    @JoinColumn(name = "dia", referencedColumnName = "id_dia_horario")
    @ManyToOne(optional = false)
    private DiaHorario diaHorario;

	public Long getIdDetalleHorario() {
		return idDetalleHorario;
	}

	public void setIdDetalleHorario(Long idDetalleHorario) {
		this.idDetalleHorario = idDetalleHorario;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public Date getFechaInactivacion() {
		return fechaInactivacion;
	}

	public void setFechaInactivacion(Date fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public DiaHorario getDiaHorario() {
		return diaHorario;
	}

	public void setDiaHorario(DiaHorario diaHorario) {
		this.diaHorario = diaHorario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    


}
