package com.ceiba.carrito.comando.manejador;

import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.comando.fabrica.FabricaCarrito;
import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.servicio.ServicioCrearCarrito;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.manejador.ManejadorComandoList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenjadorCrearCarrito implements ManejadorComando<ComandoCarrito> {

    private final FabricaCarrito fabricaCarrito;
    private final ServicioCrearCarrito servicioCrearCarrito;

    public MenjadorCrearCarrito(FabricaCarrito fabricaCarrito,
                                ServicioCrearCarrito servicioCrearCarrito) {
        this.fabricaCarrito = fabricaCarrito;
        this.servicioCrearCarrito = servicioCrearCarrito;
    }

    @Override
    public void ejecutar(ComandoCarrito comandoCarrito) {
        Carrito carrito = fabricaCarrito.crear(comandoCarrito);

        servicioCrearCarrito.ejecutar(carrito);
    }

}
