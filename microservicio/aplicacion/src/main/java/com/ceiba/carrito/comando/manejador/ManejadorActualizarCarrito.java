package com.ceiba.carrito.comando.manejador;

import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.comando.fabrica.FabricaCarrito;
import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.servicio.ServicioActualizarCarrito;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCarrito implements ManejadorComando<ComandoCarrito> {



    private final ServicioActualizarCarrito servicioActualizarCarrito;
    private final FabricaCarrito fabricaCarrito;

    public ManejadorActualizarCarrito(ServicioActualizarCarrito servicioActualizarCarrito,
                                      FabricaCarrito fabricaCarrito) {
        this.servicioActualizarCarrito = servicioActualizarCarrito;
        this.fabricaCarrito = fabricaCarrito;
    }

    @Override
    public void ejecutar(ComandoCarrito comandoCarrito) {
        Carrito carrito = fabricaCarrito.crearActualizacion(comandoCarrito);

        servicioActualizarCarrito.ejecutar(carrito);
    }

}
