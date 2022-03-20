package com.ceiba.soporte.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Setter
@Getter
public class Soporte {

    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion.";

    private Long id;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaASolucionar;
    private String estado;

    public Soporte(Long id, String descripcion, LocalDate fechaCreacion, LocalDate fechaASolucionar, String estado) {
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);

        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaASolucionar = fechaASolucionar;
        this.estado = estado;
    }
}
