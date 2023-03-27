package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -4307797340137401202L;

	@Id
	@SequenceGenerator(name = "Usuario.sequence", sequenceName = "usuario_id_usuario_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usuario.sequence")	
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(name = "usuario")
	private String usuario;
	
	@ManyToOne
	@JoinColumn(name = "tipo_documento")
	private TipoDocumento tipoDocumento;
	
	@Column(name = "nro_documento")
	private String nroDocumento;
	
	@Column(name = "primer_nombre")
	private String primerNombre;
	
	@Column(name = "segundo_nombre")
	private String segundoNombre;
	
	@Column(name = "primer_apellido")
	private String primerApellido;
	
	@Column(name = "segundo_apellido")
	private String segundoApellido;

	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;
	
	
	@ManyToOne
	@JoinColumn(name = "empresa")
    private Empresa empresa;
	
	@Column(name = "estado")
	private Integer estado;
//	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
//    private List<DetalleHorario> detalleHorarioList;
	
//	@OneToMany(mappedBy =  "agente")
//	private List<AgenteCampana> agenteCampanaList;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

//	public List<DetalleHorario> getDetalleHorarioList() {
//		return detalleHorarioList;
//	}
//
//	public void setDetalleHorarioList(List<DetalleHorario> detalleHorarioList) {
//		this.detalleHorarioList = detalleHorarioList;
//	}

//	public List<AgenteCampana> getAgenteCampanaList() {
//		return agenteCampanaList;
//	}
//
//	public void setAgenteCampanaList(List<AgenteCampana> agenteCampanaList) {
//		this.agenteCampanaList = agenteCampanaList;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
	
	


}
