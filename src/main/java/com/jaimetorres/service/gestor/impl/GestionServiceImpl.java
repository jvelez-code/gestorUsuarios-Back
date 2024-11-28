package com.jaimetorres.service.gestor.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.CargueArchivoDTO;
import com.jaimetorres.dto.LlamadaEntranteDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Archivo;
import com.jaimetorres.model.gestor.Campana;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Divipola;
import com.jaimetorres.model.gestor.Empresa;
import com.jaimetorres.model.gestor.EstadoCampana;
import com.jaimetorres.model.gestor.EstadoGestion;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.TipoCampana;
import com.jaimetorres.model.gestor.TipoDocumento;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.IGestionService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class GestionServiceImpl extends CRUDImpl<Gestion, Integer> implements IGestionService{

	private final String LOCALHOST_IPV4 = "127.0.0.1";
	private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";
	LocalDateTime ahora = LocalDateTime.now();
	

	@Autowired
	private IGestionRepo repo;
	
	@Autowired
	private ICampanaRepo repoCam;
	
	@Autowired
	private IArchivoRepo repoArc;

	@Autowired
	private IClienteRepo repoCli;

	@Autowired
	private IContactoRepo repoCon;

	@Autowired
	private IGestionRepo repoGes;

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


	@Override
	public Integer buscarSecre(LlamadaEntranteDTO filtro) {
		return repo.buscarGestion(filtro.getnumeroDocumento());
	}


	@Override
	public ParametrosDTO readCsvFile(
			MultipartFile file,
			String idUsuario,
			String idEmpresa,
			HttpServletRequest request) throws IOException, CsvValidationException {

		ParametrosDTO cargueList = new ParametrosDTO();
		
		Integer clienteNuevo = 0;
		Integer gestionNuevo = 0;
		String fileName = file.getOriginalFilename();
		String ip = getClientIp(request);
		Integer idCoordinador = Integer.parseInt(idUsuario);
		Integer idEmpresas = Integer.parseInt(idEmpresa);
		
		
		TipoCampana tipoC = new TipoCampana();
		tipoC.setIdTipoCampana(4);
		
		EstadoCampana esta = new EstadoCampana();
		esta.setIdEstadoCampana(1);
		
		Empresa emp = new Empresa();
		emp.setIdEmpresa(idEmpresas);
		
		Date now=new Date();
		Campana cam = new Campana();
		cam.setTipoCampana(tipoC);
		cam.setEstadoCampana(esta);
		cam.setEmpresa(emp);
		cam.setIdCoordinador(idCoordinador);
		cam.setTipoAsignacion(2);
		cam.setNombre(fileName.replaceAll("\\.csv$", ""));
		cam.setTiempoCargueCampana(now);
		repoCam.save(cam);	


		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream())))
		{        	
			CSVReader csvReader = new CSVReader(reader);
			String[] nextRecord;
			csvReader.readNext();

			while ((nextRecord = csvReader.readNext()) != null) {
				CargueArchivoDTO dto = new CargueArchivoDTO(
						nextRecord[0], // tipoDocumento
						nextRecord[1], // nroDocumento
						nextRecord[2], // razonSocial
						nextRecord[3], // codMunicipio
						nextRecord[4], // telefonoMovi
						nextRecord[5], // telefonoTrab
						nextRecord[6], // telefonoResi
						nextRecord[7], // correo
						Integer.parseInt(nextRecord[8]) // idCliente
						);

				TipoDocumento tipo = new TipoDocumento();
				tipo.setTipoDoc(nextRecord[0]);

				Divipola divi = new Divipola();
				divi.setIdZona(184);

				Usuario usu = new Usuario();
				usu.setIdUsuario(idCoordinador);

				EstadoGestion est = new EstadoGestion();
				est.setIdEstadoGestion(7); 
				
				
				Cliente cli = new Cliente();
				cli = repoCli.buscarCargue(nextRecord[0], nextRecord[1]);
				if(cli !=null) {
					dto.setIdCliente(cli.getIdCliente());       		
				} else { 

					Cliente clin = new Cliente();
					clin.setTipoDocumento(tipo);
					clin.setNroDocumento(nextRecord[1]);
					clin.setDivipola(divi);
					clin.setRazonSocial(nextRecord[2]);
					clin.setTelefonoFijo(nextRecord[4]);
					clin.setTelefonoCelular(nextRecord[6]);
					clin.setCorreo(nextRecord[7]);
					clin.setUsuario(idUsuario);
					clin.setCantidadEmpleados("1");
					clin.setLey1581(true);
					clin.setFechaHoraSistema(now);					
					repoCli.save(clin);	
					dto.setIdCliente(clin.getIdCliente());
					clienteNuevo ++;
				}
				//cargueList.add(dto);

				Cliente clic = new Cliente();
				clic.setIdCliente(dto.getIdCliente());

				Gestion ges = new Gestion();
				ges.setAgente(usu);
				ges.setCliente(clic);
				ges.setEstadoGestion(est);
				ges.setCampana(cam);
				ges.setIpAct(ip);
				ges.setCallid("N/A");
				ges.setFechaGestion(now);
				ges.setFechaHoraSis(now);
				repoGes.save(ges);

				Contacto cont = new Contacto();
				cont.setCliente(clic);
				cont.setGestion(ges);
				cont.setDivipola(divi);
				cont.setNroEmpleado(1);
				cont.setNumeroContacto(nextRecord[4]);
				cont.setTelefonoDirecto(nextRecord[5]);
				cont.setTelefonoCelular(nextRecord[6]);
				cont.setCorreoElectronico(nextRecord[7]);				
				repoCon.save(cont);
				
				gestionNuevo ++ ;
			}
			
			Archivo arc = new Archivo();
			arc.setNombreArchivo(file.getName());
			arc.setCampana(cam);
			arc.setFechaHoraCargue(ahora);
			arc.setCantidadRegistros(gestionNuevo);
			arc.setRegistrosExitosos(clienteNuevo);			
			arc.setNombreArchivo(fileName);
			repoArc.save(arc);
			
			
		}
		cargueList.setCampanaSal(cam.getIdCampana());
		cargueList.setGestionNuevo(gestionNuevo);
		cargueList.setClienteNuevo(clienteNuevo);
		
		return cargueList;

	}


	@Override
	public Gestion registrarTransaccionalCargue(Gestion gestion) throws Exception {
		gestion.getListaContacto().forEach(det ->det.setGestion(gestion));
		return repo.save(gestion);	
	}


	@Override
	public Integer contarGestiones(ParametrosDTO filtro) {
		return repo.contarGestiones(filtro.getCampanaSal());
	}


	@Override
	public Integer contarGestionesfalt(ParametrosDTO filtro) {
		return repo.contarGestionesfalt(filtro.getCampanaSal());
	}
}



