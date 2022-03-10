package com.ceiba.carrito.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCarrito {

    private Long id;
    private String nombre;
    private Integer cantidad;
    private Double precioProducto;
    private Double precioTotal;
    private LocalDate fecha;
    private String nombreCliente;
    private String identificacion;

}
