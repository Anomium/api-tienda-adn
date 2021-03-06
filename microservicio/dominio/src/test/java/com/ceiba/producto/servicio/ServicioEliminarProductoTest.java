package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarProductoTest {

    @Test
    @DisplayName("Deberia eliminar un producto llamando al repositorio")
    void deberiaEliminarUnProductoLlamandoAlRepositorio() {
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto);
        Mockito.when(repositorioProducto.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioEliminarProducto.ejecutar(1L);

        Mockito.verify(repositorioProducto, Mockito.times(1)).eliminar(1L);

    }

    @Test
    @DisplayName("Deberia lanzar una excepcion al intentar eliminar un producto")
    void deberiaLanzarExcepcionAlIntentarEliminarUnProducto() {
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto);
        Mockito.when(repositorioProducto.existePorId(Mockito.anyLong())).thenReturn(false);

        BasePrueba.assertThrows(() -> servicioEliminarProducto.ejecutar(100L),
                ExcepcionDuplicidad.class,"El producto no existe en el sistema");
    }

}
