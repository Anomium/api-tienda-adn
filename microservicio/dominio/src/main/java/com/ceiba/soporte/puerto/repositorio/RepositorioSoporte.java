package com.ceiba.soporte.puerto.repositorio;

import com.ceiba.soporte.modelo.entidad.Soporte;

import java.time.LocalDate;

public interface RepositorioSoporte {

    Long crear(Soporte soporte);
    void actualizar(Soporte soporte);
    boolean existePorId(Long id);
}
