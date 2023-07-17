package com.jaimetorres.dto;

import java.util.Date;

public class tmoGestionDto {
	
	private  Date fecha;
	private  String agent;
	private  String agente;
	private  Date duracionllamadas;
	private  Integer cantidadgrabaciones;
	private  String segundos;
	
	public tmoGestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public tmoGestionDto(Date fecha, String agent, String agente, Date duracionllamadas, Integer cantidadgrabaciones,
			String segundos) {
		super();
		this.fecha = fecha;
		this.agent = agent;
		this.agente = agente;
		this.duracionllamadas = duracionllamadas;
		this.cantidadgrabaciones = cantidadgrabaciones;
		this.segundos = segundos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public Date getDuracionllamadas() {
		return duracionllamadas;
	}

	public void setDuracionllamadas(Date duracionllamadas) {
		this.duracionllamadas = duracionllamadas;
	}

	public Integer getCantidadgrabaciones() {
		return cantidadgrabaciones;
	}

	public void setCantidadgrabaciones(Integer cantidadgrabaciones) {
		this.cantidadgrabaciones = cantidadgrabaciones;
	}

	public String getSegundos() {
		return segundos;
	}

	public void setSegundos(String segundos) {
		this.segundos = segundos;
	}

	
	
}
