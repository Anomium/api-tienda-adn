package com.ceiba.carrito.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCarrito {

    private Long id;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private Double precioTotal;
    private String estadoCompra;

}
