package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crm_categoria")
public class CrmCategoria implements Serializable {
	
	
	private static final long serialVersionUID = 7077287725021279571L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer idCategoria;	

    @Column(name = "nombre_categoria", length = 32, nullable = false)
	private String nombreCategoria;
	
	@Column(name = "dias_vencimiento")
	private Integer diasVencimiento;

	
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Integer getDiasVencimiento() {
		return diasVencimiento;
	}

	public void setDiasVencimiento(Integer diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}
	
	

}
