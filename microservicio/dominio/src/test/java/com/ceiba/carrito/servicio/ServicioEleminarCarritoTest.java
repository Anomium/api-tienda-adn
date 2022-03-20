package com.ceiba.carrito.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.carrito.servicio.testdatabuilder.CarritoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

class ServicioEleminarCarritoTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del carrito")
    void deberiaValidarLaExistenciaPreviaDelCarrito() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder().conId(100L).build();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarProductoCarrito servicioEliminarProductoCarrito = new ServicioEliminarProductoCarrito(repositorioCarrito);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarProductoCarrito.ejecutar(100L),
                ExcepcionDuplicidad.class,"El carrito no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia eliminar el usuario llamando al repositorio")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarProductoCarrito servicioEliminarProductoCarrito = new ServicioEliminarProductoCarrito(repositorioCarrito);

        servicioEliminarProductoCarrito.ejecutar(2L);

        Mockito.verify(repositorioCarrito, Mockito.times(1)).eliminar(2L);

    }

}
