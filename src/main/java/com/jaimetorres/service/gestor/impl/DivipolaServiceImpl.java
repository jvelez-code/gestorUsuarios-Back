package com.jaimetorres.service.gestor.impl;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.DivipolaDto;
import com.jaimetorres.model.gestor.Divipola;
import com.jaimetorres.model.gestor.TipoDocumento;
import com.jaimetorres.repo.gestor.IDivipolaRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.IDivipolaService;
@Service
public class DivipolaServiceImpl extends CRUDImpl<Divipola, Integer> implements IDivipolaService{

	@Autowired
	private IDivipolaRepo  repo;

	@Override
	protected IGenericRepo<Divipola, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<DivipolaDto> listaCiudades() {
		List<DivipolaDto> divi = new ArrayList<>();
		repo.buscar().forEach( x ->{
			DivipolaDto di = new DivipolaDto();
			di.setIdZona((Integer) x[0]);
			di.setNombre(String.valueOf(x[1]));
			di.setDepartamento(String.valueOf(x[2]));
			divi.add(di);
		});
		return divi;
	}

	@Override
	public List<Divipola> cargueCampana(DivipolaDto filtro) {
		List<Divipola> divi = new ArrayList<>();
		divi=repo.findByNombre(filtro.getNombre());
		return divi;
	}


}
