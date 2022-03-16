package com.ceiba.soporte.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Soporte {

    private Long id;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaASolucionar;
    private String estado;

    public Soporte(Long id, String descripcion, LocalDate fechaCreacion, LocalDate fechaASolucionar, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaASolucionar = fechaASolucionar;
        this.estado = estado;
    }
}
