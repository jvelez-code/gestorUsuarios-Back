package com.jaimetorres.repo.gestor;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimetorres.model.gestor.TipoDocumento;


public interface ITipoDocumentoRepo extends JpaRepository<TipoDocumento, String> {
	

}
