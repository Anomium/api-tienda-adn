package com.ceiba.soporte.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSoporte {

    private Long id;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaASolucionar;
    private String estado;

}
