package com.jaimetorres.service.gestor.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.AgenteDTO;
import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.AgenteCampana;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IAgenteCampanaService;

@Service
public class AgenteCampanaServiceImpl extends CRUDImpl<AgenteCampana, Integer> implements IAgenteCampanaService {

	@Autowired
	private IAgenteCampanaRepo repo;
	
	@Override
	protected IGenericRepo<AgenteCampana, Integer> getRepo(){
		return repo;
	}

	@Override
	public AgenteDTO buscarCampana(FiltroEntranteDTO filtro) {
		try {
		AgenteDTO agente = new AgenteDTO();
		AgenteCampana ag= repo.buscarAgenteCampanaE(filtro.getLoginAgente());
		if(ag != null) {
			agente.setIdUsuario(ag.getAgente().getIdUsuario());
			agente.setUsuario(ag.getAgente().getUsuario());
			agente.setNroDocumento(ag.getAgente().getNroDocumento());
			agente.setPrimerNombre(ag.getAgente().getPrimerNombre());
			agente.setPrimerApellido(ag.getAgente().getPrimerApellido());
			agente.setIdEmpresa(ag.getAgente().getEmpresa().getIdEmpresa());
			agente.setPseudonimo(ag.getAgente().getEmpresa().getPseudonimo());
			agente.setDescripcion(ag.getAgente().getEmpresa().getDescripcion());
			agente.setIdCampanaE(ag.getCampana().getIdCampana());
			agente.setNombreCamE(ag.getCampana().getTipoCampana().getNombre());
			agente.setTipoLlamadaCamE(ag.getCampana().getTipoCampana().getTipoLlamada());
			
		}
		AgenteCampana ags= repo.buscarAgenteCampanaS(filtro.getLoginAgente());
		if(ags != null) {
			agente.setIdCampanaS(ags.getCampana().getIdCampana());
			agente.setNombreCamS(ags.getCampana().getTipoCampana().getNombre());
			agente.setTipoLlamadaCamE(ags.getCampana().getTipoCampana().getTipoLlamada());
		}
		
            InetAddress localhost = InetAddress.getLocalHost();
            String ipv4 = localhost.getHostAddress();
            agente.setHostIp(ipv4);
            return agente;
            
        } 
		
		catch (UnknownHostException e) {
            e.printStackTrace();
        }
		return null;
		
		
		
	}


	
	
}


