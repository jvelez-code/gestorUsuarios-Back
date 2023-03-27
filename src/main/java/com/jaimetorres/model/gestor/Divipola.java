package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "divipola")
public class Divipola implements Serializable{
	
	
	private static final long serialVersionUID = 4858131739463130864L;

	@Id
	@Column(name = "id_zona")
	private Integer idZona;

	@Column(name = "indicativo")
	private Integer indicativo;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "tipo_zona")
	private String tipoZona;
	
	@Column(name = "tipo_et")
	private String tipoEt;
	
	@Column(name = "nombre")
	private String nombre;

//	@Column(name = "id_zona_padre")
//	private Integer idZonapadre;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_zona_padre")
	private Divipola idZonapadre;
	

	@Column(name = "dv")
	private String dv;

	@Column(name = "zona_especial")
	private Boolean zonaEspecial;

	public Integer getIdZona() {
		return idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

	public Integer getIndicativo() {
		return indicativo;
	}

	public void setIndicativo(Integer indicativo) {
		this.indicativo = indicativo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipoZona() {
		return tipoZona;
	}

	public void setTipoZona(String tipoZona) {
		this.tipoZona = tipoZona;
	}

	public String getTipoEt() {
		return tipoEt;
	}

	public void setTipoEt(String tipoEt) {
		this.tipoEt = tipoEt;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Divipola getIdZonapadre() {
		return idZonapadre;
	}

	public void setIdZonapadre(Divipola idZonapadre) {
		this.idZonapadre = idZonapadre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public Boolean getZonaEspecial() {
		return zonaEspecial;
	}

	public void setZonaEspecial(Boolean zonaEspecial) {
		this.zonaEspecial = zonaEspecial;
	}
	
		

}
