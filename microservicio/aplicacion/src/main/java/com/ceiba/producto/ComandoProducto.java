package com.ceiba.producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private LocalDate fechaCreacion;

}
