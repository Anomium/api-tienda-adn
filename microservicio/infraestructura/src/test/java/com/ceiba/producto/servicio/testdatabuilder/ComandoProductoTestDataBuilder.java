package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;

import java.time.LocalDate;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private LocalDate fechaCreacion;

    public ComandoProductoTestDataBuilder() {
        nombre = "Esto es una prueba1";
        precio = 30.0;
        cantidad = 6;
        fechaCreacion = LocalDate.parse("2022-03-08");
    }

    public ComandoProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(id, nombre, precio, cantidad, fechaCreacion);
    }
}
