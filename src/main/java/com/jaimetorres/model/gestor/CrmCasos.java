package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "crm_casos")
public class CrmCasos implements Serializable {
	

	private static final long serialVersionUID = 8601154209813494999L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_caso")
	private Integer idCaso;	

    @Column(name = "nro_realmarcado", length = 32, nullable = false)
	private String nroRealmarcado;
    
    @Column(name = "fecha_gestion")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fechaGestion;
        
    @Column(name = "fecha_vencimiento")
 	@Temporal(TemporalType.TIMESTAMP)	
 	private Date fechaVencimiento;
	
    @ManyToOne
    @JoinColumn(name = "Id_Tipologia", referencedColumnName = "Id_Tipologia", foreignKey = @ForeignKey(name = "crm_categoria_casos_fkey"))
   	private CrmTipologia crmTipologia;
    
    @ManyToOne
    @JoinColumn(name = "Id_estado", referencedColumnName = "Id_estado", foreignKey = @ForeignKey(name = "crm_estado_casos_fkey"))
   	private CrmEstado crmEstado;
    
    @ManyToOne
    @JoinColumn(name = "Id_nivel", referencedColumnName = "Id_nivel", foreignKey = @ForeignKey(name = "crm_nivel_casos_fkey"))
   	private CrmNivel crmNivel;
    
    @ManyToOne
    @JoinColumn(name = "Id_departamento", referencedColumnName = "Id_departamento", foreignKey = @ForeignKey(name = "crm_departamento_casos_fkey"))
   	private CrmDepartamento crmDepartamento;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", foreignKey = @ForeignKey(name = "crm_cliente_casos_fkey"))
   	private Cliente cliente;   
    
    @JsonIgnore
    @OneToMany(mappedBy = "idCaso", cascade = { CascadeType.ALL }, orphanRemoval = true)	
	private List<CrmCasos> listaDetalle;


	public Integer getIdCaso() {
		return idCaso;
	}


	public void setIdCaso(Integer idCaso) {
		this.idCaso = idCaso;
	}


	public String getNroRealmarcado() {
		return nroRealmarcado;
	}


	public void setNroRealmarcado(String nroRealmarcado) {
		this.nroRealmarcado = nroRealmarcado;
	}


	public Date getFechaGestion() {
		return fechaGestion;
	}


	public void setFechaGestion(Date fechaGestion) {
		this.fechaGestion = fechaGestion;
	}

	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public CrmTipologia getCrmTipologia() {
		return crmTipologia;
	}


	public void setCrmTipologia(CrmTipologia crmTipologia) {
		this.crmTipologia = crmTipologia;
	}


	public CrmEstado getCrmEstado() {
		return crmEstado;
	}


	public void setCrmEstado(CrmEstado crmEstado) {
		this.crmEstado = crmEstado;
	}


	public CrmNivel getCrmNivel() {
		return crmNivel;
	}


	public void setCrmNivel(CrmNivel crmNivel) {
		this.crmNivel = crmNivel;
	}


	public CrmDepartamento getCrmDepartamento() {
		return crmDepartamento;
	}


	public void setCrmDepartamento(CrmDepartamento crmDepartamento) {
		this.crmDepartamento = crmDepartamento;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<CrmCasos> getListaDetalle() {
		return listaDetalle;
	}


	public void setListaDetalle(List<CrmCasos> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

	}
