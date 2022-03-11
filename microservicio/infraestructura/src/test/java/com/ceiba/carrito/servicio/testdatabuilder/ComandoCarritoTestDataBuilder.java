package com.ceiba.carrito.servicio.testdatabuilder;

import com.ceiba.carrito.comando.ComandoCarrito;

import java.time.LocalDate;

public class ComandoCarritoTestDataBuilder {
    private Long id;
    private String nombre;
    private Integer cantidad;
    private Double precioProducto;
    private Double precioTotal;
    private LocalDate fecha;
    private String nombreCliente;
    private String identificacion;
    private String cupon;
    private String estadoCompra;


    public ComandoCarritoTestDataBuilder() {
        nombre = "Esto es una prueba";
        cantidad = 2;
        precioProducto = 30.0;
        precioTotal = 1500.0;
        fecha = LocalDate.parse("2022-03-08");
        nombreCliente = "KH";
        identificacion = "123456789";
        cupon = "f1c053a5-cada-4511-a0c2-79d4d21de880";
        estadoCompra = "PENDIENTE";
    }

    public ComandoCarrito build() {
        return new ComandoCarrito(id, nombre, cantidad, precioProducto,
                precioTotal, fecha, nombreCliente, identificacion, cupon, estadoCompra);
    }

}
