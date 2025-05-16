package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "extension")
public class Extension implements Serializable {
	
	private static final long serialVersionUID = 2048625916134304305L;

	@Id
	@Column(unique = true, nullable = false, length = 20)
	private String extension;
	
	@Column(name = "fechaestado", nullable = false)
	private LocalDateTime fechaestado;

	@Column(name = "duracionultimoestado", nullable = false)
	private LocalDateTime duracionultimoestado;

	@Column(name = "disponible")
	private String disponible;	
	
	
    @ManyToOne
    @JoinColumn(name = "empresa" , nullable = false, foreignKey =  @ForeignKey(name = "fk_ext_empresa"))
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario" , referencedColumnName = "id_usuario", foreignKey =  @ForeignKey(name = "fk_ext_usuario"))
    private Usuario usuario;
	
	
//	@Column(nullable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date fechaultimoestado;
//	
//	@Column(nullable = true)
//	private String extensionconectado;
//	
//	@Column(nullable = true)
//	private Long espera;
//	
//	@Column
//	private String monitoreo;
//	
	
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "extension")
//    private List<DetalleHorario> detalleHorarioList;
//	
//	@Transient
//	private String labelDuracion;
//	@Transient
//	private String numeroLlamante;
//	@Transient
//	private String numeroLlamado;
	


	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	public LocalDateTime getDuracionultimoestado() {
		return duracionultimoestado;
	}

	public void setDuracionultimoestado(LocalDateTime duracionultimoestado) {
		this.duracionultimoestado = duracionultimoestado;
	}

	public LocalDateTime getFechaestado() {
		return fechaestado;
	}

	public void setFechaestado(LocalDateTime fechaestado) {
		this.fechaestado = fechaestado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
