package com.ceiba.carrito.comando.manejador;

import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.comando.fabrica.FabricaCarrito;
import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.servicio.ServicioActualizarCarrito;
import com.ceiba.manejador.ManejadorComandoList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorActualizarCarrito implements ManejadorComandoList<ComandoCarrito> {



    private final ServicioActualizarCarrito servicioActualizarCarrito;
    private final FabricaCarrito fabricaCarrito;

    public ManejadorActualizarCarrito(ServicioActualizarCarrito servicioActualizarCarrito,
                                      FabricaCarrito fabricaCarrito) {
        this.servicioActualizarCarrito = servicioActualizarCarrito;
        this.fabricaCarrito = fabricaCarrito;
    }

    @Override
    public void ejecutar(List<ComandoCarrito> comandoCarrito) {
        List<Carrito> carritos = fabricaCarrito.crearActualizacion(comandoCarrito);

        servicioActualizarCarrito.ejecutar(carritos);
    }

}
