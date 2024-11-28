package com.jaimetorres.model.gestor;

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
	@JoinColumn(name = "id_agente", nullable = false, foreignKey = @ForeignKey(name ="fk_agentecampana_agente"))
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_campana", nullable = false, foreignKey = @ForeignKey(name ="fk_agentecampana_campana"))
	private Campana campana;
	
	@Column(name = "activo")
	private Boolean activo;

	public AgenteCampana() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgenteCampana(Integer idAgenteCampana, Usuario usuario, Campana campana, Boolean activo) {
		super();
		this.idAgenteCampana = idAgenteCampana;
		this.usuario = usuario;
		this.campana = campana;
		this.activo = activo;
	}




	public Integer getIdAgenteCampana() {
		return idAgenteCampana;
	}

	public void setIdAgenteCampana(Integer idAgenteCampana) {
		this.idAgenteCampana = idAgenteCampana;
	}

	public Usuario getAgente() {
		return usuario;
	}

	public void setAgente(Usuario agente) {
		this.usuario = agente;
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
