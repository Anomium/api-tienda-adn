package com.ceiba.producto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

public class ServicioEliminarProducto {

    private static final String EL_PRODUCTO_NO_EXISTE_EN_EL_SISTEMA = "El producto no existe en el sistema";

    private final RepositorioProducto repositorioProducto;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioProducto.eliminar(id);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioProducto.existePorId(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
