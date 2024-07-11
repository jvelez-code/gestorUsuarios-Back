package com.jaimetorres.service.gestor.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.DivipolaDto;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IGestionService;
import org.springframework.util.StringUtils;

@Service
public class GestionServiceImpl extends CRUDImpl<Gestion, Integer> implements IGestionService{
	
	private final String LOCALHOST_IPV4 = "127.0.0.1";
    private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

	@Autowired
	private IGestionRepo repo;
	
	@Override
	protected IGenericRepo<Gestion, Integer> getRepo(){
		return repo;
	}
	
	
	@Override
	public List<Gestion> buscar(ParametrosDTO filtro) {
		return null;
	}

	@Override
	public List<Gestion> buscarA(ParametrosDTO filtro) {
		return repo.buscarA(filtro.getIdCliente());
	}

	@Override
	public Gestion buscarM(ParametrosDTO filtro) {
		return repo.buscarM(filtro.getIdCliente());
	}


	@Override
	public Gestion registrarTransaccional(Gestion gestion) throws Exception {
		
		gestion.getListaDetalleGestion().forEach(det ->det.setGestion(gestion));
		gestion.getListaContacto().forEach(det ->det.setGestion(gestion));
		
		
		return repo.save(gestion);		
	}
	
	@Override
	public Gestion registrarTransaccionalComercial(Gestion gestion) throws Exception {
		
		gestion.getListaDetalleGestion().forEach(det ->det.setGestion(gestion));		
		gestion.getListaContacto().forEach(det ->det.setGestion(gestion));		
		gestion.getListaDetalleGestionComercial().forEach(det -> det.setGestion(gestion));
		
		return repo.save(gestion);		
	}

	@Override
	public void actuaGestionComer(Integer idGestion, DetalleGestion idDetalle ) {
		repo.actualizarComercial(idGestion, idDetalle.getIdDetalleGestion());
		
	}
	

	@Override
	public void actualizarGestion(Integer id, Gestion gestion) {
			repo.actualizarGestion(gestion.getEstadoGestion().getIdEstadoGestion(), gestion.getIdGestion(), 
					gestion.getAgente().getIdUsuario(), gestion.getUsuarioAct(), gestion.getIpAct());
			
        
	}


	@Override
	public synchronized Integer gestionSaliente(ParametrosDTO filtro) {
		//return repo.buscarIdGestion(filtro.getCampanaSal());
		Integer idGestion = repo.buscarIdGestion(filtro.getCampanaSal());
	    if (idGestion == null) {
	        // No se encontraron datos, devuelve un valor nulo
	        return 0;
	    } else {
	        // Se encontró un id de gestión, devolverlo
	        return idGestion;
	    }
	}


	@Override
	public void cambioEstadoGestion(Integer idgestion) {
		repo.cambioEstado(idgestion);		
	}


	@Override
	public ParametrosDTO buscarGestioSaliente(Integer idGestion) {		
			Map<String, Object> result = repo.gestionSal(idGestion);
		    ParametrosDTO parametrosDTO = new ParametrosDTO();
		    parametrosDTO.setIdGestion((Integer) result.get("idGestion"));
		    parametrosDTO.setIdCliente((Integer) result.get("idCliente"));
		    return parametrosDTO;
		}


	@Override
	public String getClientIp(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-Forwarded-For");
		 
        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
 
        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
 
        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
 
        if (!StringUtils.isEmpty(ipAddress)
                && ipAddress.length() > 15
                && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }
 
        return ipAddress;
    }
	


	
	
	}




