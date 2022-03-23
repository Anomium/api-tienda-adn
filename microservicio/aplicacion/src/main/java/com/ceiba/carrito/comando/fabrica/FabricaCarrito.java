package com.ceiba.carrito.comando.fabrica;

import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.modelo.entidad.Carrito;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FabricaCarrito {

    public Carrito crear(ComandoCarrito comandoCarrito) {
        return new Carrito(
            comandoCarrito.getId(),
            comandoCarrito.getNombre(),
            comandoCarrito.getCantidad(),
            comandoCarrito.getPrecio(),
            comandoCarrito.getPrecioTotal(),
            comandoCarrito.getFecha(),
            comandoCarrito.getCupon(),
            comandoCarrito.getEstadoCompra()
        );
    }

    public Carrito crearActualizacion(ComandoCarrito comandoCarrito) {
        return new Carrito(
            comandoCarrito.getId(),
            comandoCarrito.getCantidad(),
            comandoCarrito.getPrecio(),
            comandoCarrito.getCupon(),
            LocalDate.now()
        );
    }

}
