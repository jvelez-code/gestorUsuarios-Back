package com.jaimetorres.repo.gestor;


import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.jaimetorres.dto.tmoGestionDto;
import com.jaimetorres.model.gestor.DetalleGestionComercial;
import com.jaimetorres.model.gestor.Gestion;



public interface IDetalleGestionComercialRepo extends IGenericRepo<DetalleGestionComercial, Integer> {
	
	

	
	@Query(value="SELECT \n"
			+ "DETGESCOM.fecha_gestion AS fechaGestionCargue, CLI.tipo_documento, CLI.nro_documento, CLI.razon_social,\n"
			+ "CON.nombre AS ContactoNombre, CON.numero_contacto, CON.telefono_celular, CON.correo_electronico, \n"
			+ "CONCAT(MUN.nombre,' - ',DEP.nombre) as ciudad,\n"
			+ "CLI.direccion, MOT.nombre AS MotivoNombre, DETGESCOM.reg_proyectados,\n"
			+ "EST.nombre AS EstadoNombre, DETGESCOM.reg_obtenidos, DETGES.observacion, DETGESCOM.nro_gestion_realizada, DETGESCOM.compromisos,\n"
			+ "GES.fecha_gestion AS fechaGestion, DETGESCOM.id_detalle_gestion_comercial, DETGESCOM.id_agente, GES.id_cliente, \n"
			+ "DETGESCOM.gestion_realizada,CV.nombre, DETGESCOM.activar\n"
			+ "FROM detalle_gestion_comercial DETGESCOM\n"
			+ "INNER JOIN gestion GES on (GES.id_gestion = DETGESCOM.id_gestion)\n"
			+ "INNER JOIN detalle_gestion DETGES on (DETGES.id_gestion = GES.id_gestion)\n"
			+ "INNER JOIN cliente CLI on (CLI.id_cliente = GES.id_cliente)\n"
			+ "INNER JOIN contacto CON on (CON.id_gestion = GES.id_gestion)\n"
			+ "INNER JOIN estado_gestion EST on (EST.id_estado_gestion = DETGES.id_estado_gestion)\n"
			+ "INNER JOIN motivo MOT on (MOT.id_motivo = DETGESCOM.id_motivo)\n"
			+ "INNER JOIN divipola MUN on (CLI.id_zona = MUN.id_zona)\n"
			+ "INNER JOIN divipola DEP on (MUN.id_zona_padre = DEP.id_zona)\n"
			+ "inner join ciclo_de_vida CV on (cv.id_ciclo = DETGESCOM.ciclo_vida )\n"
			+ "WHERE   DETGESCOM.fecha_gestion BETWEEN '2023-10-21 00:00:00' AND '2023-11-21 20:00:00'\n"
			+ "--and GES.id_agente IN ('795') \n"
			+ "ORDER BY GES.fecha_gestion", nativeQuery = true)
		List<Object[]> buscarGC(@Param("fechaInicial") Date fechaInicial, @Param("fechaFinal") Date fechaFinal);
	
		}
