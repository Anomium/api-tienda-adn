package com.ceiba.carrito.servicio;

import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionFechaFueraRango;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioActualizarCarrito {


    private static final String EL_CARRITO_NO_EXISTE_EN_EL_SISTEMA = "El carrito no existe en el sistema";
    public static final String SE_TRABAJA_EN_DIAS_HABILES_Y_FESTIVOS = "Se trabaja en dias habiles y festivos.";
    public static final String COMPRADO = "COMPRADO";

    private final RepositorioCarrito repositorioCarrito;

    public ServicioActualizarCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public void ejecutar(Carrito carrito) {
        validarExistenciaPrevia(carrito);
        validarQueNoSeaDiaDeSemana(carrito.getFecha());
        validarCuponYCalcularPrecioTotal(carrito);
        carrito.estado(COMPRADO);
        this.repositorioCarrito.actualizar(carrito);
    }

    private void validarExistenciaPrevia(Carrito carrito) {
        boolean existe = this.repositorioCarrito.existePorId(carrito.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_CARRITO_NO_EXISTE_EN_EL_SISTEMA);
        }
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

    private void validarCuponYCalcularPrecioTotal(Carrito carrito) {
        boolean existeCupon = this.repositorioCarrito.existeCupon(carrito.getCupon());
        if (existeCupon) {
            carrito.precioConDescuento(carrito.getPrecioProducto(), carrito.getCantidad());
        } else {
            carrito.precioSinDescuento(carrito.getPrecioProducto(), carrito.getCantidad());
        }
    }
}

