package com.ceiba.carrito.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.servicio.testdatabuilder.CarritoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionFechaFueraRango;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CarritoTest {

    public static final double PRECIO_CON_DESCUENTO = 3600.0;
    public static final double PRECIO_SIN_DESCUENTO = 4000.0;

    @Test
    void deberiaCrearCorrectamenteElCarrito() {

        Carrito carrito = new CarritoTestDataBuilder().build();

        assertNull(carrito.getId());
        assertEquals("1234", carrito.getNombre());
        assertEquals(8, carrito.getCantidad());
        assertEquals(31.0, carrito.getPrecioProducto());
        assertEquals(410.1, carrito.getPrecioTotal());
        assertEquals(LocalDate.parse("2022-03-10"), carrito.getFecha());
        assertNull(carrito.getCupon());
        assertNull(carrito.getEstadoCompra());
    }

    @Test
    void deberiaCalcularElPrecioConElDescuento() {
        Carrito carrito = new Carrito(1L, 2, 2000.0, "CUPON", LocalDate.now());
        carrito.precioConDescuento(carrito.getPrecioProducto(), carrito.getCantidad());
        assertEquals(PRECIO_CON_DESCUENTO, carrito.getPrecioTotal());
    }

    @Test
    void deberiaCalcularElPrecioSinElDescuento() {
        Carrito carrito = new Carrito(1L, 2, 2000.0, "CUPON", LocalDate.now());
        carrito.precioSinDescuento(carrito.getPrecioProducto(), carrito.getCantidad());
        System.out.println(carrito.getPrecioTotal());
        assertEquals(PRECIO_SIN_DESCUENTO, carrito.getPrecioTotal());
    }

    @Test
    void deberiaFallarSinNombreDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder().conNombre(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del producto.");
    }

    @Test
    void deberiaFallarSinCantidadDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder().conCantidad(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el cantidad del producto.");
    }

    @Test
    void deberiaFallarSinPrecioProductoDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder().conPrecioProducto(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio del producto.");
    }

    @Test
    void deberiaFallarConCantidadNegativaDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder().conCantidad(-1);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe de ingresar un valor positivo.");
    }

    @Test
    void deberiaFallarConPrecioProductoNegativaDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder().conPrecioProducto(-1.0);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe de ingresar un valor positivo.");
    }

    @Test
    void deberiaValidarLongitudMinimaDePrecioProducto() {
        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conPrecioProducto(0.1);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar la longitud minima de uno(1).");
    }

    @Test
    void deberiaValidarPrecioTotalMinimo() {
        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conPrecioTotal(0.1);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar la longitud minima de uno(1).");
    }

    @Test
    void deberiaValidarPrecioTotalNegativo() {
        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conPrecioTotal(-1.0);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe de ingresar un valor positivo.");
    }

    @Test
    void deberiaFallarConCantidadNegativaDelProductoSegundoConstructor() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conId(1L)
                .conCantidad(-1);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.buildMenosParametros();
                },
                ExcepcionValorInvalido.class, "Se debe de ingresar un valor positivo.");
    }

    @Test
    void deberiaFallarConPrecioProductoNegativaDelProductoSegundoConstructor() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conId(1L)
                .conPrecioProducto(-1.0);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.buildMenosParametros();
                },
                ExcepcionValorInvalido.class, "Se debe de ingresar un valor positivo.");
    }

    @Test
    void deberiaValidarLongitudMinimaDePrecioProductoSegundoConstructor() {
        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conId(1L)
                .conPrecioProducto(0.1);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.buildMenosParametros();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar la longitud minima de uno(1).");
    }

    @Test
    void deberiaFallarSinPrecioProductoDelProductoSegundoConstructor() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conId(1L)
                .conPrecioProducto(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.buildMenosParametros();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio del producto.");
    }

    @Test
    void deberiaFallarSinCantidadDelProductoSegundoConstructor() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conId(1L)
                .conCantidad(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.buildMenosParametros();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el cantidad del producto.");
    }

    @Test
    void deberiaFallarSinCIdDelProductoSegundoConstructor() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conId(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.buildMenosParametros();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id del producto.");
    }

    @Test
    void deberiaFallarConCIdDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "No deberia de existir id.");
    }

    @Test
    void deberiaFallarConFechaObligatoria() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder()
                .conFecha(null)
                .conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.buildMenosParametros();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha del producto.");
    }

}
