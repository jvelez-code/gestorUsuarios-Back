package com.jaimetorres.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "dia_horario")
public class DiaHorario implements Serializable {

	private static final long serialVersionUID = 5516549532587619758L;

	
	@Id
	@SequenceGenerator(name = "DiaHorario.sequence", sequenceName = "dia_horario_id_dia_horario_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DiaHorario.sequence")	
	@Column(name="id_dia_horario")
	private Integer idDiaHorario;
	
	@Column
	private String descripcion;
	
	@Column
	private String horas;
	
	@Column
	private String fin_semana;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "diaHorario")
    private List<DetalleHorario> detalleHorarioList;

	public Integer getIdDiaHorario() {
		return idDiaHorario;
	}

	public void setIdDiaHorario(Integer idDiaHorario) {
		this.idDiaHorario = idDiaHorario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getFin_semana() {
		return fin_semana;
	}

	public void setFin_semana(String fin_semana) {
		this.fin_semana = fin_semana;
	}

	public List<DetalleHorario> getDetalleHorarioList() {
		return detalleHorarioList;
	}

	public void setDetalleHorarioList(List<DetalleHorario> detalleHorarioList) {
		this.detalleHorarioList = detalleHorarioList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
