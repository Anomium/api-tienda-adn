package com.ceiba.producto.servicio;

import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.modelo.entidad.Producto;

public class ServicioActualizarProducto {

    private final RepositorioProducto repositorioProducto;


    public ServicioActualizarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        this.repositorioProducto.ejecutar(producto);
    }
}
