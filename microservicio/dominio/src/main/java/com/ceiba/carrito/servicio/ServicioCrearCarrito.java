package com.ceiba.carrito.servicio;

import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.dominio.excepcion.ExcepcionFechaFueraRango;

import java.time.*;
import java.util.Calendar;
import java.util.List;

public class ServicioCrearCarrito {

    public static final String SE_TRABAJA_EN_DIAS_HABILES_Y_FESTIVOS = "Se trabaja en dias habiles y festivos.";
    private final RepositorioCarrito repositorioCarrito;

    public ServicioCrearCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public void ejecutar(List<Carrito> carritos) {
        carritos.forEach(carrito -> {
            validarFecha(carrito.getFecha());
            this.repositorioCarrito.crear(carrito);
        });

    }

    private void validarFecha(LocalDate fecha) {
        if (validarQueNoSeaDiaDeSemana(fecha)) {
            throw new ExcepcionFechaFueraRango(SE_TRABAJA_EN_DIAS_HABILES_Y_FESTIVOS);
        }

    }

    private boolean validarQueNoSeaDiaDeSemana(LocalDate fecha) {

        return (fecha.getDayOfWeek() == DayOfWeek.SATURDAY ||
                fecha.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

}
