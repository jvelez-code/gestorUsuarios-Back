package com.jaimetorres.repo.mongo;
import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.jaimetorres.model.mongo.PagoFecha;

public interface IPagoFechaRepo extends MongoRepository <PagoFecha, String> {

    List<PagoFecha> findByFechaPagoBetween(String fechaInicial, String fechaFinal);

    PagoFecha findFirstByFechaPagoGreaterThanEqualAndTipoIdentificacionAndNumIdentificacion(
        String fechaInicial, String tipoIdentificacion, String numIdentificacion);
}
