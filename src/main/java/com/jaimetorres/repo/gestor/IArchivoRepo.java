package com.jaimetorres.repo.gestor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.Archivo;


public interface IArchivoRepo extends IGenericRepo< Archivo , Integer > {	


}
