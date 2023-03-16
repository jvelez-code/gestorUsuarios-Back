package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "data_ia_cliente")
public class DataIACliente implements Serializable {
	
	@Id	
	@SequenceGenerator(name = "DataIACliente.sequence", sequenceName = "data_ia_cliente_id_data_ia_cliente_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DataIACliente.sequence")
	@Column(name = "id_data_ia_cliente")
	private Integer idDataIACliente;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "id_ia_cliente")
	private IACliente iaCliente;
	
	private String valor;

	

}
