package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "compromiso_comercial", schema = "public")
public class CompromisoComercial implements Serializable {

	private static final long serialVersionUID = -1310154173385038867L;

	@Id
	@SequenceGenerator(name = "CompromisoComercial.sequence", sequenceName = "compromiso_comercial_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CompromisoComercial.sequence")
	@Column(name = "id_compromiso")
	private Integer idCompromiso;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_seguimiento_comercial", nullable = false, foreignKey = @ForeignKey(name = "fk_seguimiento_comercial"))
	private SeguimientoComercial seguimientoComercial;

	@Column(name = "compromiso", columnDefinition = "text")
	private String compromiso;

	@Column(name = "responsable", length = 100)
	private String responsable;
	
    @Column(name = "fecha_compromiso")
 	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompromiso;

	@Column(name = "id_gestion_agendada")
	private Integer idGestionAgendada;

	public Integer getIdCompromiso() {
		return idCompromiso;
	}

	public void setIdCompromiso(Integer idCompromiso) {
		this.idCompromiso = idCompromiso;
	}

	public SeguimientoComercial getSeguimientoComercial() {
		return seguimientoComercial;
	}

	public void setSeguimientoComercial(SeguimientoComercial seguimientoComercial) {
		this.seguimientoComercial = seguimientoComercial;
	}

	public String getCompromiso() {
		return compromiso;
	}

	public void setCompromiso(String compromiso) {
		this.compromiso = compromiso;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public Date getFechaCompromiso() {
		return fechaCompromiso;
	}

	public void setFechaCompromiso(Date fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	public Integer getIdGestionAgendada() {
		return idGestionAgendada;
	}

	public void setIdGestionAgendada(Integer idGestionAgendada) {
		this.idGestionAgendada = idGestionAgendada;
	}
	
	

}
