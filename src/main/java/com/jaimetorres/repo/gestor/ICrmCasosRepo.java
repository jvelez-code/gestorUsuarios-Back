package com.jaimetorres.repo.gestor;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.jaimetorres.model.gestor.CrmCasos;


public interface ICrmCasosRepo extends IGenericRepo < CrmCasos, Integer> {

	@Query(value = "SELECT cc.id_caso, c.tipo_documento, c.nro_documento, cc.nro_realmarcado, " +
			"cc.fecha_caso, cc.fecha_vencimiento,cc.fecha_cierre, cc2.nombre_categoria, " +
			"cs.nombre_subcategoria, ct.nombre_tipologia, ce.nombre_estado, " +
			"cn.nombre_nivel, cd.nombre_departamento " +
			"FROM crm_casos cc " +
			"JOIN crm_departamento cd ON cc.id_departamento = cd.id_departamento " +
			"JOIN crm_estado ce ON cc.id_estado = ce.id_estado " +
			"JOIN crm_nivel cn ON cc.id_nivel = cn.id_nivel " +
			"JOIN crm_tipologia ct ON cc.id_tipologia = ct.id_tipologia " +
			"JOIN crm_subcategoria cs ON ct.id_subcategoria = cs.id_subcategoria " +
			"JOIN crm_categoria cc2 ON cs.id_categoria = cc2.id_categoria " +
			"JOIN cliente c ON cc.id_cliente = c.id_cliente " +
			"WHERE cc.id_cliente= :idCliente " +
			"ORDER BY ce.nombre_estado, cc.id_caso DESC ",
			nativeQuery = true)
	List<Object[]> buscarCasosR(@Param("idCliente") Integer idCliente );

	@Query(value = "SELECT cc.id_caso, c.tipo_documento, c.nro_documento, cc.nro_realmarcado, " +
			"cc.fecha_caso, cc.fecha_vencimiento,cc.fecha_cierre, cc2.nombre_categoria, " +
			"cs.nombre_subcategoria, ct.nombre_tipologia, ce.nombre_estado, " +
			"cn.nombre_nivel, cd.nombre_departamento " +
			"FROM crm_casos cc " +
			"JOIN crm_departamento cd ON cc.id_departamento = cd.id_departamento " +
			"JOIN crm_estado ce ON cc.id_estado = ce.id_estado " +
			"JOIN crm_nivel cn ON cc.id_nivel = cn.id_nivel " +
			"JOIN crm_tipologia ct ON cc.id_tipologia = ct.id_tipologia " +
			"JOIN crm_subcategoria cs ON ct.id_subcategoria = cs.id_subcategoria " +
			"JOIN crm_categoria cc2 ON cs.id_categoria = cc2.id_categoria " +
			"JOIN cliente c ON cc.id_cliente = c.id_cliente " +
			"WHERE cc.id_estado in ('1','3') " +
			"ORDER BY cc.id_caso DESC ",
			nativeQuery = true)
	List<Object[]> buscarEstadoR();


	@Transactional
	@Modifying	
	@Query(value="UPDATE crm_casos SET id_estado = :idCrmEstado,fecha_cierre= :fechaDetalle  WHERE id_caso = :idCrmCaso ", nativeQuery = true)
	void actuEstado(@Param("idCrmEstado") Integer idCrmEstado, @Param("fechaDetalle") String fechaDetalle, @Param("idCrmCaso") Integer idCrmCaso );






}
