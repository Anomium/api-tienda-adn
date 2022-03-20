package com.ceiba.carrito.servicio;

import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioEliminarProductoCarrito {

    private static final String EL_CARRITO_NO_EXISTE_EN_EL_SISTEMA = "El carrito no existe en el sistema";

    private final RepositorioCarrito repositorioCarrito;

    public ServicioEliminarProductoCarrito(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioCarrito.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioCarrito.existePorId(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_CARRITO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
