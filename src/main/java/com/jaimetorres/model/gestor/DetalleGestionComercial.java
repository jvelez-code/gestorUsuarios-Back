package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_gestion_comercial")
public class DetalleGestionComercial implements Serializable {

	private static final long serialVersionUID = -8781622354829743392L;

	
	@Id
	@SequenceGenerator(name = "DetalleGestionComercial.sequence", sequenceName = "detalle_gestion_comercial_id_detalle_gestion_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleGestionComercial.sequence")	
	@Column(name = "id_detalle_gestion_comercial")
	private Integer idDetalleGestionComercial;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_gestion", nullable = false, foreignKey = @ForeignKey(name = "fk_contacto_gestion") )
	private Gestion gestion;
	
	
	@Column(name = "id_detalle_gestion")
	private Integer detalleGestion;
	
	@Column(name = "fecha_gestion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaGestion;
	
	@OneToOne
	@JoinColumn(name = "id_motivo")
	private Motivo motivo;

	@Column(name = "gestion_realizada")
	private String gestionRealizada;
	
	@Column(name = "nro_gestion_realizada")
	private String nroGestionRealizada;
	
	@Column(name = "compromisos")
	private String compromisos;

	@ManyToOne
	@JoinColumn(name = "id_agente")
	private Usuario usuario;	
	
	@Column(name = "reg_proyectados")
	private String regProyectados;
	
	@Column(name = "reg_obtenidos")
	private String regObtenidos;
	
	//@Column(name = "ciclo_vida")
	@ManyToOne
	@JoinColumn(name = "ciclo_vida")
	private CicloDeVida cicloVida;
	
	@Column(name = "activar")
	private boolean activarMod;
	
	@Column(name = "nom_archivo")
	private String nomArchivo;

	public Integer getIdDetalleGestionComercial() {
		return idDetalleGestionComercial;
	}

	public void setIdDetalleGestionComercial(Integer idDetalleGestionComercial) {
		this.idDetalleGestionComercial = idDetalleGestionComercial;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public Integer getDetalleGestion() {
		return detalleGestion;
	}

	public void setDetalleGestion(Integer detalleGestion) {
		this.detalleGestion = detalleGestion;
	}

	public Date getFechaGestion() {
		return fechaGestion;
	}

	public void setFechaGestion(Date fechaGestion) {
		this.fechaGestion = fechaGestion;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public String getGestionRealizada() {
		return gestionRealizada;
	}

	public void setGestionRealizada(String gestionRealizada) {
		this.gestionRealizada = gestionRealizada;
	}

	public String getNroGestionRealizada() {
		return nroGestionRealizada;
	}

	public void setNroGestionRealizada(String nroGestionRealizada) {
		this.nroGestionRealizada = nroGestionRealizada;
	}

	public String getCompromisos() {
		return compromisos;
	}

	public void setCompromisos(String compromisos) {
		this.compromisos = compromisos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRegProyectados() {
		return regProyectados;
	}

	public void setRegProyectados(String regProyectados) {
		this.regProyectados = regProyectados;
	}

	public String getRegObtenidos() {
		return regObtenidos;
	}

	public void setRegObtenidos(String regObtenidos) {
		this.regObtenidos = regObtenidos;
	}

	public CicloDeVida getCicloVida() {
		return cicloVida;
	}

	public void setCicloVida(CicloDeVida cicloVida) {
		this.cicloVida = cicloVida;
	}

	public boolean isActivarMod() {
		return activarMod;
	}

	public void setActivarMod(boolean activarMod) {
		this.activarMod = activarMod;
	}

	public String getNomArchivo() {
		return nomArchivo;
	}

	public void setNomArchivo(String nomArchivo) {
		this.nomArchivo = nomArchivo;
	}	
 
	
	




}
