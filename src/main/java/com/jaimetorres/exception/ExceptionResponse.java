package com.jaimetorres.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	
	//pojo
	//No van @ no va con base de datos solo logica de progra
	private LocalDateTime fecha;
	private String mensaje;
	private String detalles;	
	
	

	public ExceptionResponse(LocalDateTime fechaHora, String mensaje, String detalles) {
		this.fecha = fechaHora;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}
		
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	

}
