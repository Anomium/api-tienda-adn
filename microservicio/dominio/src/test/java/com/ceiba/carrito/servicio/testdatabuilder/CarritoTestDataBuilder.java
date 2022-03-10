package com.ceiba.carrito.servicio.testdatabuilder;

import com.ceiba.carrito.modelo.entidad.Carrito;

import java.time.LocalDate;

public class CarritoTestDataBuilder {

    private String nombre;
    private Integer cantidad;
    private Double precioProducto;
    private Double precioTotal;
    private LocalDate fecha;
    private String nombreCliente;
    private String identificacion;

    public CarritoTestDataBuilder() {
        nombre = "1234";
        cantidad = 8;
        precioProducto = 31.0;
        precioTotal = 410.1;
        fecha = LocalDate.parse("2022-03-10");
        nombreCliente = "12345";
        identificacion = "123456789";
    }

    public CarritoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }


    public CarritoTestDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public CarritoTestDataBuilder conPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
        return this;
    }

    public CarritoTestDataBuilder conPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
        return this;
    }

    public CarritoTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public CarritoTestDataBuilder conNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        return this;
    }

    public CarritoTestDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public Carrito build() {
        return new Carrito(nombre, cantidad, precioProducto, precioTotal,
                fecha, nombreCliente, identificacion);
    }
}
