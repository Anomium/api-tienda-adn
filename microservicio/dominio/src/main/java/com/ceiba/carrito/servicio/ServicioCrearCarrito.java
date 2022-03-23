package com.ceiba.carrito.servicio;

import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;

public class ServicioCrearCarrito {

    public static final String PENDIENTE = "PENDIENTE";
    private final RepositorioCarrito repositorioCarrito;

    public ServicioCrearCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public void ejecutar(Carrito carrito) {
        carrito.precioSinDescuento(carrito.getPrecioProducto(), carrito.getCantidad());
        carrito.fecha();
        carrito.estado(PENDIENTE);
        this.repositorioCarrito.crear(carrito);
    }
}
