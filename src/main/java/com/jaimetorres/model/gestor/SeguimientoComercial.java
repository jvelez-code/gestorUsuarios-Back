package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seguimiento_comercial", schema = "public")
public class SeguimientoComercial implements Serializable{
	
    private static final long serialVersionUID = 618066847470552562L;

    @Id
	@SequenceGenerator(name = "SeguimientoComercial.sequence", sequenceName = "seguimiento_comercial_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeguimientoComercial.sequence")	
	@Column(name = "id_seguimiento")
	private Integer idSeguimiento;

    @JsonIgnore
    @ManyToOne
	@JoinColumn(name = "id_gestion", nullable = false, foreignKey = @ForeignKey(name = "fk_gestion_seguimiento"))
    private Gestion gestion; 
    
    @Column(name = "fecha_ingreso_visita")
    private LocalDateTime fechaIngresoVisita;

    @Column(name = "fecha_salida_visita")
    private LocalDateTime fechaSalidaVisita;

    @Column(name = "operador_actual", length = 100)
    private String operadorActual;
    
	@Column(name = "fecha_gestion_seguimiento")
 	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaGestionSeguimiento;

    @Column(name = "encuesta_n1", length = 5)
    private String encuestaN1;

    @Column(name = "encuesta_n2", length = 5)
    private String encuestaN2;

    @Column(name = "encuesta_n3", length = 5)
    private String encuestaN3;

    @Column(name = "encuesta_n4", length = 5)
    private String encuestaN4;

    @Column(name = "encuesta_n5", length = 5)
    private String encuestaN5;

    @Column(name = "encuesta_n6", length = 5)
    private String encuestaN6;

    @Column(name = "encuesta_f1", length = 5)
    private String encuestaF1;

    @Column(name = "encuesta_f2", length = 5)
    private String encuestaF2;

    @Column(name = "encuesta_f3", length = 5)
    private String encuestaF3;

    @Column(name = "encuesta_f4", length = 5)
    private String encuestaF4;

    @Column(name = "encuesta_f5", length = 5)
    private String encuestaF5;

    @Column(name = "encuesta_observaciones", columnDefinition = "text")
    private String encuestaObservaciones;

    @Column(name = "control_compromiso", columnDefinition = "text")
    private String controlCompromiso;

    @Column(name = "control_responsable", length = 100)
    private String controlResponsable;

    @Column(name = "control_fecha")
 	@Temporal(TemporalType.TIMESTAMP)
    private Date controlFecha;

    @Column(name = "referidos_empresa", length = 200)
    private String referidosEmpresa;

    @Column(name = "referidos_contacto", length = 100)
    private String referidosContacto;

    @Column(name = "referidos_email", length = 100)
    private String referidosEmail;

    @Column(name = "referidos_telefono", length = 20)
    private String referidosTelefono;
    
    @Column(name = "fecha_liquidacion_pago")
   	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaLiquidacionPago;
    
    @OneToMany(mappedBy = "seguimientoComercial", cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.LAZY)	
	private List<CompromisoComercial> listaCompromisoComercial;

	public Integer getIdSeguimiento() {
		return idSeguimiento;
	}

	public void setIdSeguimiento(Integer idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public LocalDateTime getFechaIngresoVisita() {
		return fechaIngresoVisita;
	}

	public void setFechaIngresoVisita(LocalDateTime fechaIngresoVisita) {
		this.fechaIngresoVisita = fechaIngresoVisita;
	}

	public LocalDateTime getFechaSalidaVisita() {
		return fechaSalidaVisita;
	}

	public void setFechaSalidaVisita(LocalDateTime fechaSalidaVisita) {
		this.fechaSalidaVisita = fechaSalidaVisita;
	}

	public String getOperadorActual() {
		return operadorActual;
	}

	public void setOperadorActual(String operadorActual) {
		this.operadorActual = operadorActual;
	}

	public Date getFechaGestionSeguimiento() {
		return fechaGestionSeguimiento;
	}

	public void setFechaGestionSeguimiento(Date fechaGestionSeguimiento) {
		this.fechaGestionSeguimiento = fechaGestionSeguimiento;
	}

	public String getEncuestaN1() {
		return encuestaN1;
	}

	public void setEncuestaN1(String encuestaN1) {
		this.encuestaN1 = encuestaN1;
	}

	public String getEncuestaN2() {
		return encuestaN2;
	}

	public void setEncuestaN2(String encuestaN2) {
		this.encuestaN2 = encuestaN2;
	}

	public String getEncuestaN3() {
		return encuestaN3;
	}

	public void setEncuestaN3(String encuestaN3) {
		this.encuestaN3 = encuestaN3;
	}

	public String getEncuestaN4() {
		return encuestaN4;
	}

	public void setEncuestaN4(String encuestaN4) {
		this.encuestaN4 = encuestaN4;
	}

	public String getEncuestaN5() {
		return encuestaN5;
	}

	public void setEncuestaN5(String encuestaN5) {
		this.encuestaN5 = encuestaN5;
	}

	public String getEncuestaN6() {
		return encuestaN6;
	}

	public void setEncuestaN6(String encuestaN6) {
		this.encuestaN6 = encuestaN6;
	}

	public String getEncuestaF1() {
		return encuestaF1;
	}

	public void setEncuestaF1(String encuestaF1) {
		this.encuestaF1 = encuestaF1;
	}

	public String getEncuestaF2() {
		return encuestaF2;
	}

	public void setEncuestaF2(String encuestaF2) {
		this.encuestaF2 = encuestaF2;
	}

	public String getEncuestaF3() {
		return encuestaF3;
	}

	public void setEncuestaF3(String encuestaF3) {
		this.encuestaF3 = encuestaF3;
	}

	public String getEncuestaF4() {
		return encuestaF4;
	}

	public void setEncuestaF4(String encuestaF4) {
		this.encuestaF4 = encuestaF4;
	}

	public String getEncuestaF5() {
		return encuestaF5;
	}

	public void setEncuestaF5(String encuestaF5) {
		this.encuestaF5 = encuestaF5;
	}

	public String getEncuestaObservaciones() {
		return encuestaObservaciones;
	}

	public void setEncuestaObservaciones(String encuestaObservaciones) {
		this.encuestaObservaciones = encuestaObservaciones;
	}

	public String getControlCompromiso() {
		return controlCompromiso;
	}

	public void setControlCompromiso(String controlCompromiso) {
		this.controlCompromiso = controlCompromiso;
	}

	public String getControlResponsable() {
		return controlResponsable;
	}

	public void setControlResponsable(String controlResponsable) {
		this.controlResponsable = controlResponsable;
	}

	public Date getControlFecha() {
		return controlFecha;
	}

	public void setControlFecha(Date controlFecha) {
		this.controlFecha = controlFecha;
	}

	public String getReferidosEmpresa() {
		return referidosEmpresa;
	}

	public void setReferidosEmpresa(String referidosEmpresa) {
		this.referidosEmpresa = referidosEmpresa;
	}

	public String getReferidosContacto() {
		return referidosContacto;
	}

	public void setReferidosContacto(String referidosContacto) {
		this.referidosContacto = referidosContacto;
	}

	public String getReferidosEmail() {
		return referidosEmail;
	}

	public void setReferidosEmail(String referidosEmail) {
		this.referidosEmail = referidosEmail;
	}

	public String getReferidosTelefono() {
		return referidosTelefono;
	}

	public void setReferidosTelefono(String referidosTelefono) {
		this.referidosTelefono = referidosTelefono;
	}

	public Date getFechaLiquidacionPago() {
		return fechaLiquidacionPago;
	}

	public void setFechaLiquidacionPago(Date fechaLiquidacionPago) {
		this.fechaLiquidacionPago = fechaLiquidacionPago;
	}

	public List<CompromisoComercial> getListaCompromisoComercial() {
		return listaCompromisoComercial;
	}

	public void setListaCompromisoComercial(List<CompromisoComercial> listaCompromisoComercial) {
		this.listaCompromisoComercial = listaCompromisoComercial;
	}
	
    

	}
