package com.ceiba.carrito.puerto.repositorio;

import com.ceiba.carrito.modelo.entidad.Carrito;

public interface RepositorioCarrito {

    void crear(Carrito carrito);

    void actualizar(Carrito carrito);

    boolean existeCupon(String cupon);

    boolean existePorId(Long id);

    void eliminar(Long id);

}
