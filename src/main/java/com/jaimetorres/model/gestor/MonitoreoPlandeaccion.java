package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "monitoreo_plandeaccion")
public class MonitoreoPlandeaccion implements Serializable {

	
	

	private static final long serialVersionUID = -7530084529129310679L;
	@Id
	@SequenceGenerator(name = "MonitoreoPlandeaccion.sequence", sequenceName = "monitoteo_plandeaccion_id_plan_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MonitoreoPlandeaccion.sequence")
	@Column(name = "id_plan")
	private Integer idPlan;
	
	@Column(name = "plandeaccion")
	private String plandeAccion;

	public MonitoreoPlandeaccion() {
		super();
	}

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getPlandeAccion() {
		return plandeAccion;
	}

	public void setPlandeAccion(String plandeAccion) {
		this.plandeAccion = plandeAccion;
	}	
	
	
	
	

}
