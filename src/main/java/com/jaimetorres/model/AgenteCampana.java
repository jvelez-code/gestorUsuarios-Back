package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "agente_campana")
public class AgenteCampana implements Serializable {

	private static final long serialVersionUID = -7278472665892121344L;
	
	@Id
	@SequenceGenerator(name = "AgenteCampana.sequence", sequenceName = "agente_campana_id_agente_campana_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AgenteCampana.sequence")	
	@Column(name = "id_agente_campana")
	private Integer idAgenteCampana;
	
	@ManyToOne
	@JoinColumn(name = "id_agente")
	private Usuario agente;
	
	@ManyToOne
	@JoinColumn(name = "id_campana")
	private Campana campana;
	
	@Column(name = "activo")
	private Boolean activo;

	public Integer getIdAgenteCampana() {
		return idAgenteCampana;
	}

	public void setIdAgenteCampana(Integer idAgenteCampana) {
		this.idAgenteCampana = idAgenteCampana;
	}

	public Usuario getAgente() {
		return agente;
	}

	public void setAgente(Usuario agente) {
		this.agente = agente;
	}

	public Campana getCampana() {
		return campana;
	}

	public void setCampana(Campana campana) {
		this.campana = campana;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
