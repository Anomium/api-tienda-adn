package com.ceiba.soporte.servicio.testdatabuilder;

import com.ceiba.soporte.comando.ComandoSoporte;

import java.time.LocalDate;

public class ComandoSoporteTestDataBuilder {

    private Long id;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaASolucionar;
    private String estado;

    public ComandoSoporteTestDataBuilder() {
        descripcion = "Descripcion prueba";
        fechaCreacion = LocalDate.parse("2022-03-08");
        fechaASolucionar = LocalDate.parse("2022-03-08");
        estado = "CREADO";
    }

    public ComandoSoporteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoSoporteTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ComandoSoporte build() {
        return new ComandoSoporte(id, descripcion, fechaCreacion,
                fechaASolucionar, estado);
    }

}
