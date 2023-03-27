package com.jaimetorres.model.gestor;

import javax.persistence.*;

@Entity
@Table(name = "lista")
public class Lista {
	
	
	@Id	
	@Column(name = "id_lista")
	private Integer idLista;
	
	@Column(name = "id_lista_padre")
	private Integer idListaPadre;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdLista() {
		return idLista;
	}

	public void setIdLista(Integer idLista) {
		this.idLista = idLista;
	}

	public Integer getIdListaPadre() {
		return idListaPadre;
	}

	public void setIdListaPadre(Integer idListaPadre) {
		this.idListaPadre = idListaPadre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	


}
