package com.ceiba.producto.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Producto {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private LocalDate fechaCreacion;

    public Producto(Long id, String nombre, Double precio, Integer cantidad, LocalDate fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaCreacion = fechaCreacion;
    }
}
