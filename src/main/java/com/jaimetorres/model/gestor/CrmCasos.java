package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    
    @Column(name = "fecha_caso")	
	private String fechaCaso;
        
    @Column(name = "fecha_vencimiento")
 	private String fechaVencimiento;
    
    @Column(name = "fecha_cierre")	
	private String fechaCierre;
    
    @ManyToOne
    @JoinColumn(name = "Id_Tipologia", referencedColumnName = "Id_Tipologia", foreignKey = @ForeignKey(name = "crm_categoria_casos_fkey"))
   	private CrmTipologia crmTipologia;
    
    @ManyToOne
    @JoinColumn(name = "Id_estado", referencedColumnName = "Id_estado", foreignKey = @ForeignKey(name = "crm_estado_casos_fkey"))
   	private CrmEstado crmEstado;
    
    @ManyToOne
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel", foreignKey = @ForeignKey(name = "crm_nivel_casos_fkey"))
   	private CrmNivel crmNivel;
    
    @ManyToOne
    @JoinColumn(name = "id_origen", referencedColumnName = "id_origen", foreignKey = @ForeignKey(name = "crm_origen_casos_fkey"))
   	private CrmOrigen crmOrigen;
    
    @ManyToOne
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso", foreignKey = @ForeignKey(name = "crm_proceso_casos_fkey"))
   	private CrmProceso crmProceso;
    
    @ManyToOne
    @JoinColumn(name = "id_fuente", referencedColumnName = "id_fuente", foreignKey = @ForeignKey(name = "crm_fuente_casos_fkey"))
   	private CrmFuente crmFuente;
    
    @ManyToOne
    @JoinColumn(name = "Id_departamento", referencedColumnName = "Id_departamento", foreignKey = @ForeignKey(name = "crm_departamento_casos_fkey"))
   	private CrmDepartamento crmDepartamento;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", foreignKey = @ForeignKey(name = "crm_cliente_casos_fkey"))
   	private Cliente cliente;   
    
    //@JsonIgnore
    @OneToMany(mappedBy = "crmCasos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CrmDetalle> listaDetalle;

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

	public String getFechaCaso() {
		return fechaCaso;
	}

	public void setFechaCaso(String fechaCaso) {
		this.fechaCaso = fechaCaso;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
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

	public CrmOrigen getCrmOrigen() {
		return crmOrigen;
	}

	public void setCrmOrigen(CrmOrigen crmOrigen) {
		this.crmOrigen = crmOrigen;
	}

	public CrmFuente getCrmFuente() {
		return crmFuente;
	}

	public void setCrmFuente(CrmFuente crmFuente) {
		this.crmFuente = crmFuente;
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

	public List<CrmDetalle> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<CrmDetalle> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public CrmProceso getCrmProceso() {
		return crmProceso;
	}

	public void setCrmProceso(CrmProceso crmProceso) {
		this.crmProceso = crmProceso;
	}
    
    

}
