package com.ceiba.carrito.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.carrito.servicio.testdatabuilder.CarritoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionFechaFueraRango;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collections;

class ServicioActualizarCarritoTest {

    public static final double PRECIO_CON_DESCUENTO = 3600.0;
    public static final double PRECIO_SIN_DESCUENTO = 4000.0;
    public static final String COMPRADO = "COMPRADO";

    @Test
    @DisplayName("Deberia validar la existencia previa del carrito")
    void deberiaValidarLaExistenciaPreviaDelCarrito() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder().conId(1L).buildMenosParametros();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCarrito.ejecutar(carrito),
                ExcepcionDuplicidad.class,"El carrito no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorioConExistenciaCupon() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder()
                .conId(1L)
                .conFecha(LocalDate.now())
                .conCupon("f1c053a5-cada-4511-a0c2-79d4d21de880").buildMenosParametros();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCarrito.existeCupon(Mockito.anyString())).thenReturn(true);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act
        servicioActualizarCarrito.ejecutar(carrito);
        //assert
        Assertions.assertEquals(carrito.getFecha(), LocalDate.now());
        Mockito.verify(repositorioCarrito,Mockito.times(1)).actualizar(carrito);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorioConExistenciaCuponFalsa() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder()
                .conId(1L)
                .conPrecioProducto(2000.0)
                .conCantidad(2)
                .conCupon("f1c053a5-cada-4511-a0c2-79d4d21de880").buildMenosParametros();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCarrito.existeCupon(Mockito.anyString())).thenReturn(false);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act
        servicioActualizarCarrito.ejecutar(carrito);
        //assert
        Assertions.assertEquals(PRECIO_SIN_DESCUENTO, carrito.getPrecioTotal());
        Mockito.verify(repositorioCarrito,Mockito.times(1)).actualizar(carrito);
    }

    @Test
    @DisplayName("Deberia validar cupon")
    void deberiaValidarLaExistenciaDelCupon() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder().conId(1L)
                .conPrecioProducto(2000.0)
                .conCantidad(2)
                .conCupon("f1c053a5-cada-4511-a0c2-79d4d21de880").buildMenosParametros();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existeCupon(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act
        servicioActualizarCarrito.ejecutar(carrito);
        //assert
        Assertions.assertEquals(PRECIO_CON_DESCUENTO, carrito.getPrecioTotal());
        Mockito.verify(repositorioCarrito,Mockito.times(1)).actualizar(carrito);
    }

    @Test
    @DisplayName("Deberia validar si es dia habil")
    void deberiaValidarSiEsDiaHabil() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder()
                .conId(1L)
                .conFecha(LocalDate.parse("2022-03-19")).buildMenosParametros();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act - assert
        Assertions.assertEquals(carrito.getFecha(), LocalDate.parse("2022-03-19"));
        BasePrueba.assertThrows(() -> servicioActualizarCarrito.ejecutar(carrito),
                ExcepcionFechaFueraRango.class,"Se trabaja en dias habiles y festivos.");
    }

    @Test
    @DisplayName("Deberia validar estado comprado")
    void deberiaValidarEstadoComprado() {
        // arrange
        Carrito carrito = new CarritoTestDataBuilder()
                .conId(1L)
                .conPrecioProducto(2000.0)
                .conCantidad(2)
                .conCupon("f1c053a5-cada-4511-a0c2-79d4d21de880").buildMenosParametros();
        RepositorioCarrito repositorioCarrito = Mockito.mock(RepositorioCarrito.class);
        Mockito.when(repositorioCarrito.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCarrito.existeCupon(Mockito.anyString())).thenReturn(true);
        ServicioActualizarCarrito servicioActualizarCarrito = new ServicioActualizarCarrito(repositorioCarrito);
        // act
        servicioActualizarCarrito.ejecutar(carrito);
        //assert
        Assertions.assertEquals(carrito.getEstadoCompra(), COMPRADO);
        Mockito.verify(repositorioCarrito,Mockito.times(1)).actualizar(carrito);
    }

}
