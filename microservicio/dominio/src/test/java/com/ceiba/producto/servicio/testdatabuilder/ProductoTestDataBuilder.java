package com.ceiba.producto.servicio.testdatabuilder;


import com.ceiba.producto.modelo.entidad.Producto;

import java.time.LocalDate;

public class ProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private LocalDate fechaCreacion;

    public ProductoTestDataBuilder() {
        nombre = "Esto es una prueba";
        precio = 30.0;
        cantidad = 8;
        fechaCreacion = LocalDate.parse("2022-03-08");
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoTestDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public ProductoTestDataBuilder conFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Producto build() {
        return new Producto(id, nombre, precio, cantidad, fechaCreacion);
    }

}
