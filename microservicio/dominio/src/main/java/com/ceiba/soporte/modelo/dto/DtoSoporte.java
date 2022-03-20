package com.ceiba.soporte.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoSoporte {

    private Long id;
    private String descripcion;
    private LocalDate fechaASolucionar;
    private String estado;

}
