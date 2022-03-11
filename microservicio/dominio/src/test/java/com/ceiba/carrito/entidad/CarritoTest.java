package com.ceiba.carrito.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.servicio.testdatabuilder.CarritoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CarritoTest {

    @Test
    void deberiaCrearCorrectamenteElCarrito() {

        Carrito carrito = new CarritoTestDataBuilder().build();

        assertEquals("1234", carrito.getNombre());
        assertEquals(8, carrito.getCantidad());
        assertEquals(31.0, carrito.getPrecioProducto());
        assertEquals(410.1, carrito.getPrecioTotal());
        assertEquals(LocalDate.parse("2022-03-10"), carrito.getFecha());
        assertEquals("12345", carrito.getNombreCliente());
        assertEquals("123456789", carrito.getIdentificacion());
        assertNull(carrito.getCupon());
        assertNull(carrito.getEstadoCompra());
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
    void deberiaFallarSinFechaDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder().conFecha(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creacion del producto.");
    }

    @Test
    void deberiaFallarSinNombreClienteDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder().conNombreCliente(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del cliente.");
    }

    @Test
    void deberiaFallarSinIdentificacioneDelProducto() {

        //Arrange
        CarritoTestDataBuilder carritoTestDataBuilder = new CarritoTestDataBuilder().conIdentificacion(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    carritoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion.");
    }

}
