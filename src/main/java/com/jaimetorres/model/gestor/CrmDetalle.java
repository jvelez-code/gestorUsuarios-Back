package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "crm_detalle")
public class CrmDetalle implements Serializable {
	
	
	private static final long serialVersionUID = 8385775048374067489L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle")
	private Integer idDetalle;	   
    
    @Column(name = "fecha_detalle")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fecha_detalle;
    
    @Column(name = "observacion", nullable = false)
   	private String observacion;
    
    @ManyToOne
    @JoinColumn(name = "id_caso", referencedColumnName = "id_caso", foreignKey = @ForeignKey(name = "crm_detalle_casos_fkey"))
   	private CrmCasos crmCasos;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", foreignKey = @ForeignKey(name = "crm_detalle_usuario_fkey"))
   	private Usuario usuario;

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Date getFecha_detalle() {
		return fecha_detalle;
	}

	public void setFecha_detalle(Date fecha_detalle) {
		this.fecha_detalle = fecha_detalle;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public CrmCasos getCrmCasos() {
		return crmCasos;
	}

	public void setCrmCasos(CrmCasos crmCasos) {
		this.crmCasos = crmCasos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

	}
