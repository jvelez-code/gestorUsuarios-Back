package com.jaimetorres.service.gestor.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.CargueArchivoDTO;
import com.jaimetorres.dto.CargueComercialDTO;
import com.jaimetorres.dto.LlamadaEntranteDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Archivo;
import com.jaimetorres.model.gestor.Campana;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.DetalleGestionComercial;
import com.jaimetorres.model.gestor.Divipola;
import com.jaimetorres.model.gestor.Empresa;
import com.jaimetorres.model.gestor.EstadoCampana;
import com.jaimetorres.model.gestor.EstadoGestion;
import com.jaimetorres.model.gestor.FidelizacionComercial;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.Motivo;
import com.jaimetorres.model.gestor.TipoCampana;
import com.jaimetorres.model.gestor.TipoDocumento;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.model.mongo.PagoFecha;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.repo.mongo.IPagoFechaRepo;
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
	// Mapa para rastrear archivos en procesamiento
	private final Map<String, Boolean> archivosEnProcesamiento = new ConcurrentHashMap<>();

	// Lock para sincronización
	private final Object lock = new Object();


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
	private IDetalleGestionRepo repoDet;

	@Autowired
	private IDetalleGestionComercialRepo repoDetCo;

	@Autowired
	private IGestionRepo repoGes;

	@Autowired
	private IPagoFechaRepo repoPagos;

	@Autowired
	private IFidelizacionComercialRepo repoFidel;

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
	public Gestion registrarTransaccionalVisita(Gestion gestion, boolean necesitaTransaccion) throws Exception {
		
		 System.out.println(necesitaTransaccion + "validaForm");
			gestion.getListaDetalleGestion().forEach(det ->det.setGestion(gestion));
			gestion.getListaContacto().forEach(det ->det.setGestion(gestion));
			gestion.getListaSeguimientoComercial().forEach(seguimiento ->{
						seguimiento.setGestion(gestion);
				if (necesitaTransaccion) {
					seguimiento.getListaCompromisoComercial().forEach(compromiso -> 
	                compromiso.setSeguimientoComercial(seguimiento)
	            );
				}				
			});		
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
	public ParametrosDTO readCsvFile(MultipartFile file,String idUsuario,String idEmpresa,
			HttpServletRequest request) throws IOException, CsvValidationException {

		ParametrosDTO cargueList = new ParametrosDTO();
		String fileName = file.getOriginalFilename();

		synchronized (lock) {
			if (archivosEnProcesamiento.containsKey(fileName)) {
				throw new IllegalStateException("El archivo " + fileName + " ya está siendo procesado");
			}
			// Marcar archivo como en procesamiento
			archivosEnProcesamiento.put(fileName, true);
		}

		try {
			Date now=new Date();
			Integer clienteNuevo = 0;
			Integer gestionNuevo = 0;
			String ip = getClientIp(request);
			Integer idCoordinador = Integer.parseInt(idUsuario);
			Integer idEmpresas = Integer.parseInt(idEmpresa);


			TipoCampana tipoC = new TipoCampana();
			tipoC.setIdTipoCampana(4);

			EstadoCampana esta = new EstadoCampana();
			esta.setIdEstadoCampana(1);
			
			Usuario usua = new Usuario();
			usua.setIdUsuario(idCoordinador);

			Empresa emp = new Empresa();
			emp.setIdEmpresa(idEmpresas);

			String campaignName = fileName.replaceAll("\\.csv$", "");
			if (repoCam.findByNombre(campaignName).isPresent()) {
				throw new IllegalArgumentException("Ya existe una campaña con el nombre: " + campaignName);
			}
			Campana cam = new Campana();
			cam.setTipoCampana(tipoC);
			cam.setEstadoCampana(esta);
			cam.setEmpresa(emp);
			cam.setUsuario(usua);
			cam.setTipoAsignacion(2);
			cam.setNombre(campaignName);
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
						clin.setUsuario(usu.getUsuario());
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


			} catch (Exception e) {
				throw new RuntimeException("Error al procesar el archivo: " + e.getMessage());
			}

			cargueList.setCampanaSal(cam.getIdCampana());
			cargueList.setGestionNuevo(gestionNuevo);
			cargueList.setClienteNuevo(clienteNuevo);

			return cargueList;
		} finally {
			// Liberar el archivo del tracking al finalizar
			synchronized (lock) {
				archivosEnProcesamiento.remove(fileName);
			}
		}

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

	@Override
	public ParametrosDTO comercialFile(MultipartFile file, Integer idUsuario, Integer idCampana, HttpServletRequest request) 
			throws IOException, CsvValidationException {

		ParametrosDTO cargueList = new ParametrosDTO();
		String fileName = file.getOriginalFilename();

		if (file.isEmpty()) {
			cargueList.setGestionNuevo(0);
			return cargueList;

		}
		List<DetalleGestionComercial> existingCampaigns = repoDetCo.findByNomArchivo(fileName);
		if (!existingCampaigns.isEmpty()) {
			
		    throw new IllegalArgumentException("Ya existe una campaña con el nombre: " + fileName);
		}
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			     CSVReader csvReader = new CSVReader(reader)) {
			
			String[] nextRecord;
		    csvReader.readNext();
		    
		    Set<String> documentosProcesados = new HashSet<>();
			while ((nextRecord = csvReader.readNext()) != null) {

				String tipoDocumento = nextRecord[0];
				String nroDocumento = nextRecord[1];
				String tiponro = tipoDocumento + nroDocumento;
			    
			    if (documentosProcesados.contains(tiponro)) {
			    	
			        cargueList.setNroDocumento(nroDocumento);
			        cargueList.setTipo("Cédula Duplicada");
			        return cargueList;
			    } else {
			        
			        documentosProcesados.add(tiponro);
			    }
			}
		}
		

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
				CSVReader csvReader = new CSVReader(reader)) {

			String[] nextRecord;
			csvReader.readNext();
			
			Date now=new Date();
			Integer clienteNuevo = 0;
			Integer gestionNuevo = 0;
			String ip = getClientIp(request);
			

			Empresa emp = new Empresa();
			emp.setIdEmpresa(12);

			Usuario usu = new Usuario();
			usu.setIdUsuario(idUsuario);

			EstadoGestion est = new EstadoGestion();
			est.setIdEstadoGestion(1359);

			Campana cam = new Campana();
			cam.setIdCampana(idCampana);

			Motivo mo = new Motivo();
			mo.setIdMotivo(1);
			
			while ((nextRecord = csvReader.readNext()) != null) {

				String tipoDocumento = nextRecord[0];
				String nroDocumento = nextRecord[1];
				String nombreEmpresa = nextRecord[2];
				String razonSocial = nextRecord[3];
				String telefonoMovi = nextRecord[4];
				String telefonoTrab = nextRecord[5];
				String correo = nextRecord[6];
				String direccion = nextRecord[7];
				Integer codMunicipio = Integer.parseInt(nextRecord[8]);
				String regProyec = nextRecord[9];
				
				CargueComercialDTO dto = new CargueComercialDTO(tipoDocumento, nroDocumento, nombreEmpresa, razonSocial, telefonoMovi, telefonoTrab, correo, direccion, codMunicipio, regProyec, 0);

				TipoDocumento tipo = new TipoDocumento();
				tipo.setTipoDoc(tipoDocumento);

				Divipola divi = new Divipola();
				divi.setIdZona(184); 
				
				Optional<Cliente> optionalCliente = Optional.ofNullable(repoCli.buscarCargue(tipoDocumento, nroDocumento));
				if(optionalCliente.isEmpty()) {
					clienteNuevo ++;					
				}
				
				Cliente cli = optionalCliente.orElseGet(() -> {	
					// Crear cliente si no existe
					Cliente newClient = new Cliente();
					newClient.setTipoDocumento(tipo);
					newClient.setNroDocumento(nroDocumento);
					newClient.setDivipola(divi);
					newClient.setRazonSocial(nombreEmpresa);
					newClient.setTelefonoFijo(telefonoTrab);
					newClient.setTelefonoCelular(telefonoMovi);
					newClient.setCorreo(correo);
					newClient.setUsuario(usu.getUsuario());
					newClient.setCantidadEmpleados("1");
					newClient.setLey1581(true);
					newClient.setFechaHoraSistema(now);
					repoCli.save(newClient);
					return newClient;
				});


				dto.setIdCliente(cli.getIdCliente());


				Gestion ges = new Gestion();
				ges.setAgente(usu);
				ges.setCampana(cam);
				ges.setCliente(cli);
				ges.setEstadoGestion(est);
				ges.setIpAct(ip);
				ges.setCallid("C/O");
				ges.setFechaGestion(now);
				ges.setFechaHoraSis(now);
				repo.save(ges);

				DetalleGestion det= new DetalleGestion();
				det.setGestion(ges);
				det.setFechaGestion(now);
				det.setFechaHoraSis(now);
				det.setObservacion("PLANEACIÓN");
				det.setEstadoGestion(est);
				repoDet.save(det);

				Contacto con = new Contacto();
				con.setGestion(ges);
				con.setNombre(razonSocial);
				con.setTelefonoCelular(telefonoMovi);
				con.setCorreoElectronico(correo);
				con.setNumeroContacto(telefonoTrab);
				con.setNroEmpleado(1);
				repoCon.save(con);

				DetalleGestionComercial detc = new DetalleGestionComercial();
				detc.setGestion(ges);
				detc.setMotivo(mo);
				detc.setFechaGestion(now);
				detc.setNomArchivo(fileName);
				detc.setRegProyectados(regProyec);
				repoDetCo.save(detc);
				
				String fechaInicial = ajustarFecha(ahora);
				PagoFecha pagosFechas = repoPagos.findFirstByFechaPagoGreaterThanEqualAndTipoIdentificacionAndNumIdentificacion
						(fechaInicial, tipoDocumento, nroDocumento);
				if(pagosFechas != null){
					FidelizacionComercial fidel = new FidelizacionComercial();
					fidel.setIdDetalleGestionComercial(detc);
					fidel.setFechaPago(pagosFechas.getFechaPago());
					fidel.setCodCaja("");
					fidel.setRegistrosNuevos(pagosFechas.getNumTrabajadores());
					fidel.setNumeroPlanilla(pagosFechas.getNumeroPlanilla());
					fidel.setObservacion(pagosFechas.getTipoPago());
					fidel.setSucursal(pagosFechas.getSucursal());
					fidel.setFechaGestion(now);
					repoFidel.save(fidel);
				} else {
					//System.out.println(nroDocumento + " SIN PAGO");

				}

				gestionNuevo ++; 				
			}

			cargueList.setClienteNuevo(clienteNuevo);
			cargueList.setGestionNuevo(gestionNuevo);
			cargueList.setTipo("CARGADA");
			return cargueList;

		} catch (IOException e) {
			// Captura errores de lectura de archivo
			e.printStackTrace();
			cargueList.setGestionNuevo(1);
			return cargueList;
		} catch (CsvValidationException e) {
			// Captura errores específicos de CSV
			e.printStackTrace();
			cargueList.setGestionNuevo(2);
			return cargueList;
		} catch (Exception e) {
			// Captura cualquier otro tipo de excepción
			e.printStackTrace();
			cargueList.setGestionNuevo(3);
			return cargueList;
		}


	}

	public static String ajustarFecha(LocalDateTime fecha){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaInicial = fecha.toLocalDate();
		LocalDate ultimoDiaMesAnterior = fechaInicial
				.withDayOfMonth(1)
				.minusDays(1);

		return ultimoDiaMesAnterior.format(formatter);
	}


}



