package com.ceiba.carrito.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.carrito.servicio.testdatabuilder.CarritoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

class ServicioActualizarCarritoTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del carrito")
    void deberiaValidarLaExistenciaPreviaDelCarrito() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder().conId(1L).build();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCarrito.ejecutar(Collections.singletonList(carrito)),
                ExcepcionDuplicidad.class,"El carrito no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorioConExistenciaCupon() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder().conId(1L).conCupon("f1c053a5-cada-4511-a0c2-79d4d21de880").build();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCarrito.existeCupon(Mockito.anyString())).thenReturn(true);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act
        servicioActualizarCarrito.ejecutar(Collections.singletonList(carrito));
        //assert
        Mockito.verify(repositorioCarrito,Mockito.times(1)).actualizar(carrito);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorioConExistenciaCuponFalsa() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder().conId(1L).conCupon("f1c053a5-cada-4511-a0c2-79d4d21de880").build();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCarrito.existeCupon(Mockito.anyString())).thenReturn(false);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act
        servicioActualizarCarrito.ejecutar(Collections.singletonList(carrito));
        //assert
        Mockito.verify(repositorioCarrito,Mockito.times(1)).actualizar(carrito);
    }

}
