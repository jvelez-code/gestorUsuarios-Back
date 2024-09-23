package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "crm_proceso")
public class CrmProceso implements Serializable {	

	
	private static final long serialVersionUID = -2724082272343122553L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proceso")
	private Integer idProceso;	

    @Column(name = "nombre_proceso", length = 32, nullable = false)
	private String nombreProceso;

	public Integer getidProceso() {
		return idProceso;
	}

	public void setidProceso(Integer idProceso) {
		this.idProceso = idProceso;
	}

	public String getnombreProceso() {
		return nombreProceso;
	}

	public void setnombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	

    

}
