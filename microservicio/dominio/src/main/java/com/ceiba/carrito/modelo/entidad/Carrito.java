package com.ceiba.carrito.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Carrito {

    private String nombre;
    private Integer cantidad;
    private Double precioProducto;
    private Double precioTotal;
    private LocalDate fecha;
    private String nombreCliente;
    private String identificacion;

    public Carrito(String nombre, Integer cantidad, Double precioProducto, Double precioTotal, LocalDate fecha,
                   String nombreCliente, String identificacion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.identificacion = identificacion;
    }
}
