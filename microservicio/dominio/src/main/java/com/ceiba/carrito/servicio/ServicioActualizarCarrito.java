package com.ceiba.carrito.servicio;

import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.dominio.excepcion.ExcepcionFechaFueraRango;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class ServicioActualizarCarrito {

    public static final String COMPRADO = "COMPRADO";
    public static final String SE_TRABAJA_EN_DIAS_HABILES_Y_FESTIVOS = "Se trabaja en dias habiles y festivos.";
    private final RepositorioCarrito repositorioCarrito;

    public ServicioActualizarCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public void ejecutar(List<Carrito> carritos) {
        carritos.forEach(carrito -> {
            validarQueNoSeaDiaDeSemana(carrito.getFecha());
            carrito.setEstadoCompra(COMPRADO);
            this.repositorioCarrito.crear(carrito);
        });

    }

    private void validarQueNoSeaDiaDeSemana(LocalDate fecha) {
        if (validarFecha(fecha)) {
            throw new ExcepcionFechaFueraRango(SE_TRABAJA_EN_DIAS_HABILES_Y_FESTIVOS);
        }
    }

    private boolean validarFecha(LocalDate fecha) {
        return (fecha.getDayOfWeek() == DayOfWeek.SATURDAY ||
                fecha.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

}

