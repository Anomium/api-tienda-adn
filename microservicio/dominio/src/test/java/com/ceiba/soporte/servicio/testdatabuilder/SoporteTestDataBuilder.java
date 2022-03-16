package com.ceiba.soporte.servicio.testdatabuilder;

import com.ceiba.soporte.modelo.entidad.Soporte;

import java.time.LocalDate;

public class SoporteTestDataBuilder {

    private Long id;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaASolucionar;
    private String estado;

    public SoporteTestDataBuilder() {
        descripcion = "Descripcion prueba";
        fechaCreacion = LocalDate.parse("2022-03-08");
        fechaASolucionar = LocalDate.parse("2022-03-08");
        estado = "CREADO";
    }

    public SoporteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public SoporteTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Soporte build() {
        return new Soporte(id, descripcion, fechaCreacion,
                fechaASolucionar, estado);
    }

}
