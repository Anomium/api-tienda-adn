package com.ceiba.usuario.comando.fabrica;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(),
                comandoProducto.getNombre(),
                comandoProducto.getPrecio(),
                comandoProducto.getCantidad(),
                comandoProducto.getFechaCreacion()
        );
    }

}
