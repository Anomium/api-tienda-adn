package com.ceiba.producto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.usuario.comando.fabrica.FabricaProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEditarProducto implements ManejadorComando<ComandoProducto> {

    private final ServicioActualizarProducto servicioActualizarProducto;
    private final FabricaProducto fabricaProducto;

    public ManejadorEditarProducto(ServicioActualizarProducto servicioActualizarProducto,
                                   FabricaProducto fabricaProducto) {
        this.servicioActualizarProducto = servicioActualizarProducto;
        this.fabricaProducto = fabricaProducto;
    }

    @Override
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = fabricaProducto.crear(comandoProducto);
        this.servicioActualizarProducto.ejecutar(producto);
    }
}
