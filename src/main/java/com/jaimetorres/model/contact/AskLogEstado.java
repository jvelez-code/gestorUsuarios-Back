package com.jaimetorres.model.contact;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jaimetorres.model.gestor.Cliente;

@Entity
@Table(name = "ask_log_estados")
public class AskLogEstado {
	
	@Id
	@Column(name = "id_log")
	private Integer idLogEstado;	
	
	@Column(name = "id_extension", nullable = false)
	private Integer idExtension;
	
	@Column(name = "fecha_ini", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraInicioEstado;
	
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraFinEstado;
	
	@ManyToOne
	@JoinColumn(name = "estado", referencedColumnName = "id_estado", foreignKey =  @ForeignKey(name = "fk_ask_estado_extension_estado"))
	private AskEstado askEstado;

	public Integer getIdLogEstado() {
		return idLogEstado;
	}

	public void setIdLogEstado(Integer idLogEstado) {
		this.idLogEstado = idLogEstado;
	}

	public Integer getIdExtension() {
		return idExtension;
	}

	public void setIdExtension(Integer idExtension) {
		this.idExtension = idExtension;
	}

	public Date getFechaHoraInicioEstado() {
		return fechaHoraInicioEstado;
	}

	public void setFechaHoraInicioEstado(Date fechaHoraInicioEstado) {
		this.fechaHoraInicioEstado = fechaHoraInicioEstado;
	}

	public Date getFechaHoraFinEstado() {
		return fechaHoraFinEstado;
	}

	public void setFechaHoraFinEstado(Date fechaHoraFinEstado) {
		this.fechaHoraFinEstado = fechaHoraFinEstado;
	}

	public AskEstado getAskEstado() {
		return askEstado;
	}

	public void setAskEstado(AskEstado askEstado) {
		this.askEstado = askEstado;
	}

	
	
	

}
