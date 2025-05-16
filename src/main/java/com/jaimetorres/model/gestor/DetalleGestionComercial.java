package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_gestion_comercial")
public class DetalleGestionComercial implements Serializable {

	private static final long serialVersionUID = -8781622354829743392L;

	
	@Id
	@SequenceGenerator(name = "DetalleGestionComercial.sequence", sequenceName = "detalle_gestion_comercial_id_detalle_gestion_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleGestionComercial.sequence")	
	@Column(name = "id_detalle_gestion_comercial")
	private Integer idDetalleGestionComercial;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_gestion", nullable = false, foreignKey = @ForeignKey(name = "fk_contacto_gestion") )
	private Gestion gestion;	
	
	@Column(name = "fecha_gestion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaGestion;
	
	@ManyToOne()
	@JoinColumn(name = "id_motivo", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_gestion_comercial_motivo") )
	private Motivo motivo;
	
	@Column(name = "reg_obtenidos")
	private String regObtenidos;
	
	@Column(name = "reg_proyectados")
	private String regProyectados;	
	
	@Column(name = "activar")
	private boolean activar;
	
	@Column(name = "nom_archivo")
	private String nomArchivo;
	
	

	public DetalleGestionComercial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleGestionComercial(Integer idDetalleGestionComercial, Gestion gestion, Date fechaGestion, Motivo motivo,
			String regObtenidos, String regProyectados, boolean activar, String nomArchivo) {
		super();
		this.idDetalleGestionComercial = idDetalleGestionComercial;
		this.gestion = gestion;
		this.fechaGestion = fechaGestion;
		this.motivo = motivo;
		this.regObtenidos = regObtenidos;
		this.regProyectados = regProyectados;
		this.activar = activar;
		this.nomArchivo = nomArchivo;
	}

	public Integer getIdDetalleGestionComercial() {
		return idDetalleGestionComercial;
	}

	public void setIdDetalleGestionComercial(Integer idDetalleGestionComercial) {
		this.idDetalleGestionComercial = idDetalleGestionComercial;
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

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public String getRegObtenidos() {
		return regObtenidos;
	}

	public void setRegObtenidos(String regObtenidos) {
		this.regObtenidos = regObtenidos;
	}

	public String getRegProyectados() {
		return regProyectados;
	}

	public void setRegProyectados(String regProyectados) {
		this.regProyectados = regProyectados;
	}

	public boolean isActivar() {
		return activar;
	}

	public void setActivar(boolean activar) {
		this.activar = activar;
	}

	public String getNomArchivo() {
		return nomArchivo;
	}

	public void setNomArchivo(String nomArchivo) {
		this.nomArchivo = nomArchivo;
	}
	
	
	

	
}
