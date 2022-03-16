package com.ceiba.soporte.servicio;

import com.ceiba.soporte.modelo.entidad.Soporte;
import com.ceiba.soporte.puerto.repositorio.RepositorioSoporte;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioCrearSoporte {

    private final RepositorioSoporte repositorioSoporte;

    public ServicioCrearSoporte(RepositorioSoporte repositorioSoporte) {
        this.repositorioSoporte = repositorioSoporte;
    }

    public Long ejecutar(Soporte soporte) {
        soporte.setFechaASolucionar(calcularFechaHabil());
        return this.repositorioSoporte.crear(soporte);
    }

    private LocalDate calcularFechaHabil() {
        LocalDate fecha = LocalDate.now().plusDays(3);
        Integer contadorDias = 0;
        LocalDate contadorFecha = fecha;
        do {
            contadorDias++;
            contadorFecha = fecha.plusDays(contadorDias);
        } while ((contadorFecha.getDayOfWeek() == DayOfWeek.SATURDAY ||
                contadorFecha.getDayOfWeek() == DayOfWeek.SUNDAY));

        return contadorFecha;
    }
}
