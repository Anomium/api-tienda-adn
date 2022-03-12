package com.ceiba.producto.puerto.repositorio;

import com.ceiba.producto.modelo.entidad.Producto;

public interface RepositorioProducto {

    void crear(Producto producto);

    void actualizar(Producto producto);

    boolean existePorId(Long id);

}
