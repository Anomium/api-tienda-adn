package com.ceiba.producto.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.producto.ComandoProducto;
import com.ceiba.producto.servicio.ServicioRegistrarProducto;
import com.ceiba.usuario.comando.fabrica.FabricaProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarProducto implements ManejadorComando<ComandoProducto> {

    private final FabricaProducto fabricaProducto;
    private final ServicioRegistrarProducto servicioRegistrarProducto;

    public ManejadorRegistrarProducto(FabricaProducto fabricaProducto,
                                      ServicioRegistrarProducto servicioRegistrarProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioRegistrarProducto = servicioRegistrarProducto;
    }


    @Override
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        this.servicioRegistrarProducto.ejecutar(producto);
    }
}
