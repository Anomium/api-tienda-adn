package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoProducto {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private LocalDate fechaCreacion;

}
