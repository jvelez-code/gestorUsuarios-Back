package com.jaimetorres.repo.gestor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.Menu;

public interface IMenuRepo extends IGenericRepo<Menu, Integer>{
	
	@Query(value="select m.* "
			+ "from menu_rol mr "
			+ "inner join usuario_rol ur on ur.id_rol = mr.id_rol "
			+ "inner join menu m on m.idmenu = mr.id_menu "
			+ "inner join usuarios u on u.idusuario = ur.id_usuario "
			+ "where u.nombre = :nombre and m.app='1' ", nativeQuery = true)
	List<Menu> listarMenuPorUsuario(@Param("nombre") String nombre);

}
