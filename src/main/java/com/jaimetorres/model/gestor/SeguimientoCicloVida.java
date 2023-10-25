package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seguimiento_ciclo_vida")
public class SeguimientoCicloVida implements Serializable {

	private static final long serialVersionUID = -8367598325486017152L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_seguimiento_ciclo_vida")
	private Integer idSeguimientoCicloVida;
	
	@Column(name = "id_detalle_gestion_comercial")
	private Integer idDetalleGestionComercial;
	
    //@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "ciclo", nullable = false, foreignKey = @ForeignKey(name = "fk_ciclodevida"))
	private CicloDeVida cicloVida;
	
	@Column(name = "fecha_seguimiento")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fecha_seguimiento;

	public SeguimientoCicloVida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeguimientoCicloVida(Integer idDetalleGestionComercial, CicloDeVida ciclo, Date fecha_seguimiento) {
		super();
		this.idDetalleGestionComercial = idDetalleGestionComercial;
		this.cicloVida = cicloVida;
		this.fecha_seguimiento = fecha_seguimiento;
	}

	public Integer getIdSeguimientoCicloVida() {
		return idSeguimientoCicloVida;
	}

	public void setIdSeguimientoCicloVida(Integer idSeguimientoCicloVida) {
		this.idSeguimientoCicloVida = idSeguimientoCicloVida;
	}

	public Integer getIdDetalleGestionComercial() {
		return idDetalleGestionComercial;
	}

	public void setIdDetalleGestionComercial(Integer idDetalleGestionComercial) {
		this.idDetalleGestionComercial = idDetalleGestionComercial;
	}

	public CicloDeVida getCiclo() {
		return cicloVida;
	}

	public void setCiclo(CicloDeVida ciclo) {
		this.cicloVida = ciclo;
	}

	public Date getFecha_seguimiento() {
		return fecha_seguimiento;
	}

	public void setFecha_seguimiento(Date fecha_seguimiento) {
		this.fecha_seguimiento = fecha_seguimiento;
	}
	
	
	

	 }
