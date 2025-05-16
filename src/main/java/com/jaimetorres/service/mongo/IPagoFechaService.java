package com.jaimetorres.service.mongo;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.mongo.PagoFecha;

public interface IPagoFechaService {


    List<PagoFecha> obtenerPagos(ParametrosDTO filtro);
    PagoFecha pagoDocumento(ParametrosDTO filtro);
    

}
