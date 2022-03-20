package com.ceiba.carrito.servicio;

import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;

import java.time.LocalDate;
import java.util.List;

public class ServicioCrearCarrito {

    public static final String PENDIENTE = "PENDIENTE";
    private final RepositorioCarrito repositorioCarrito;

    public ServicioCrearCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public void ejecutar(List<Carrito> carritos) {

        carritos.forEach(carrito -> {
            validarCuponYCalcularDescuento(carrito);
            calcularPrecioTotal(carrito);
            carrito.setFecha(LocalDate.now());
            carrito.setEstadoCompra(PENDIENTE);
            this.repositorioCarrito.crear(carrito);
        });

    }

    private void validarCuponYCalcularDescuento(Carrito carrito) {
        if(validarCupon(carrito.getCupon())) {
            carrito.setPrecioProducto(descuento(carrito.getPrecioProducto()));
        }
    }

    private boolean validarCupon(String cupon) {
        return repositorioCarrito.existeCupon(cupon);
    }

    private Double descuento(Double precioProducto) {
        return precioProducto * 0.25;
    }

    private void calcularPrecioTotal(Carrito carrito) {
        carrito.setPrecioTotal(carrito.getCantidad() * carrito.getPrecioProducto());
    }
}
