package com.jaimetorres.repo.gestor;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.Campana;
import com.jaimetorres.model.gestor.DetalleGestionComercial;



public interface IDetalleGestionComercialRepo extends IGenericRepo<DetalleGestionComercial, Integer> {
	
	
	List<DetalleGestionComercial> findByNomArchivo(String nomArchivo);
	
	

	
	@Query(value="SELECT  "
			+ "DETGESCOM.fecha_gestion AS fechaGestionCargue, CLI.tipo_documento, CLI.nro_documento, CLI.razon_social, "
			+ "CON.nombre AS ContactoNombre, CON.numero_contacto, CON.telefono_celular, CON.correo_electronico,  "
			+ "CONCAT(MUN.nombre,' - ',DEP.nombre) as ciudad, "
			+ "CLI.direccion, MOT.nombre AS MotivoNombre, DETGESCOM.reg_proyectados, "
			+ "EST.nombre AS EstadoNombre, DETGES.observacion, "
			+ "GES.fecha_gestion AS fechaGestion, "
			+ "U.usuario, DETGESCOM.id_detalle_gestion_comercial AS idDetalleComercial "
			+ "FROM detalle_gestion_comercial DETGESCOM "
			+ "INNER JOIN gestion GES on (GES.id_gestion = DETGESCOM.id_gestion) "
			+ "INNER JOIN detalle_gestion DETGES on (DETGES.id_gestion = GES.id_gestion) "
			+ "INNER JOIN cliente CLI on (CLI.id_cliente = GES.id_cliente) "
			+ "INNER JOIN contacto CON on (CON.id_gestion = GES.id_gestion) "
			+ "INNER JOIN usuario U ON (GES.id_agente = u.id_usuario) "
			+ "INNER JOIN estado_gestion EST on (EST.id_estado_gestion = DETGES.id_estado_gestion) "
			+ "INNER JOIN motivo MOT on (MOT.id_motivo = DETGESCOM.id_motivo) "
			+ "INNER JOIN divipola MUN on (CLI.id_zona = MUN.id_zona) "
			+ "INNER JOIN divipola DEP on (MUN.id_zona_padre = DEP.id_zona) "
			+ "WHERE DETGESCOM.fecha_gestion BETWEEN :fechaInicial AND :fechaFinal "
			+ "ORDER BY GES.fecha_gestion ", nativeQuery = true)
		List<Object[]> buscarGC(@Param("fechaInicial") LocalDateTime fechaInicial, @Param("fechaFinal") LocalDateTime fechaFinal);
		
//		@Query("FROM DetalleGestionComercial dc JOIN dc.usuario u WHERE dc.fechaGestion BETWEEN :fechaInicial AND :fechaFinal")
//		List<DetalleGestionComercial> buscarUsuarios(@Param("fechaInicial") Date fechaInicial, @Param("fechaFinal") Date fechaFinal);
//	
		}

