package com.ceiba.carrito.comando.manejador;

import com.ceiba.carrito.servicio.ServicioEliminarProductoCarrito;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProductoCarrito implements ManejadorComando<Long> {

    private final ServicioEliminarProductoCarrito servicioEliminarProductoCarrito;

    public ManejadorEliminarProductoCarrito(ServicioEliminarProductoCarrito servicioEliminarProductoCarrito) {
        this.servicioEliminarProductoCarrito = servicioEliminarProductoCarrito;
    }

    @Override
    public void ejecutar(Long idCarrito) {
        servicioEliminarProductoCarrito.ejecutar(idCarrito);
    }

}
