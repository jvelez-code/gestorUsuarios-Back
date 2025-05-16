package com.jaimetorres.service.mongo.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.mongo.PagoFecha;
import com.jaimetorres.repo.mongo.IPagoFechaRepo;
import com.jaimetorres.service.mongo.IPagoFechaService;

@Service
public class PagoFechaServiceImpl implements IPagoFechaService {

    @Autowired
    private IPagoFechaRepo repo;

    @Override
    public List<PagoFecha> obtenerPagos(ParametrosDTO filtro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaInicial = filtro.getFechaInicial().format(formatter);
        String fechaFinal = filtro.getFechaFinal().format(formatter);
        return repo.findByFechaPagoBetween(fechaInicial, fechaFinal);
    }

    @Override
    public PagoFecha pagoDocumento(ParametrosDTO filtro) {
        
        String fechaInicial = ajustarFecha(filtro.getFechaInicial());
        return repo.findFirstByFechaPagoGreaterThanEqualAndTipoIdentificacionAndNumIdentificacion
        (fechaInicial, filtro.getTipo(), filtro.getNroDocumento());
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
