package com.jaimetorres.service.gestor.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.AgenteDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.AgenteCampana;
import com.jaimetorres.model.gestor.Campana;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.IAgenteCampanaService;

@Service
public class AgenteCampanaServiceImpl extends CRUDImpl<AgenteCampana, Integer> implements IAgenteCampanaService {

	@Autowired
	private IAgenteCampanaRepo repo;
	
	@Autowired
	private IUsuarioRepo repoUsu;
	
	@Override
	protected IGenericRepo<AgenteCampana, Integer> getRepo(){
		return repo;
	}

	@Override
	public AgenteDTO buscarCampana(ParametrosDTO filtro) throws IOException {
		
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
			
		
		AgenteCampana ags= repo.buscarAgenteCampanaS(filtro.getLoginAgente());
		if(ags != null) {
			agente.setIdCampanaS(ags.getCampana().getIdCampana());
			agente.setNombreCamS(ags.getCampana().getTipoCampana().getNombre());
			agente.setTipoLlamadaCamS(ags.getCampana().getTipoCampana().getTipoLlamada());
		}
		} 
		else {
			
		
			
			Usuario usu= repoUsu.buscarLogin(filtro.getLoginAgente());
			agente.setIdUsuario(usu.getIdUsuario());
			agente.setUsuario(usu.getUsuario());
			agente.setNroDocumento(usu.getNroDocumento());
			agente.setPrimerNombre(usu.getPrimerNombre());
			agente.setPrimerApellido(usu.getPrimerApellido());
			agente.setIdEmpresa(usu.getEmpresa().getIdEmpresa());
			agente.setPseudonimo(usu.getEmpresa().getPseudonimo());
			agente.setDescripcion(usu.getEmpresa().getDescripcion());
		
			
		
		}
		
            InetAddress localhost = InetAddress.getLocalHost();
            String ipv4 = localhost.getHostAddress();
            agente.setHostIp(ipv4);
            return agente;
            
        }
	
	@Override
	public void eliminarCampana(ParametrosDTO filtro) {
		
		
		repo.eliminarCampana(filtro.getIdUsuarios(),filtro.getIdTipoCampana());
		
			
	} 

	@Override
	public void guardarCampana(ParametrosDTO filtro) {
		Campana cam = new Campana();
		cam.setIdCampana(filtro.getCampanaSal());	
		
		List<AgenteCampana> agentesCampana = new ArrayList<>();
		
		for(Integer idAgente : filtro.getIdUsuarios()) {
			
			Usuario usu = new Usuario();
			usu.setIdUsuario(idAgente);
			
			AgenteCampana ag = new AgenteCampana();
			ag.setAgente(usu);
			ag.setActivo(true);
			ag.setCampana(cam);
			agentesCampana.add(ag);
		}
		
		repo.saveAll(agentesCampana);
		
	}

	@Override
	public List<AgenteCampana> validarAsignacion(ParametrosDTO filtro) {
		  return repo.validarAsignacion(filtro.getCampanaSal());
	}


	
}
		
	
		
		
	


	
	



