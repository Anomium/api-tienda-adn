package com.ceiba.producto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.productotestbuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductoTest {

    @Test
    @DisplayName("Deberia crear correctamente el producto")
    void deberiaCrearCorrectamenteElProducto() {
        Producto producto = new ProductoTestDataBuilder().conNombre("HK").conId(1L).build();

        assertEquals(1L, producto.getId());
        assertEquals("HK", producto.getNombre());
        assertEquals(30.0, producto.getPrecio());
        assertEquals(8, producto.getCantidad());
        assertEquals(LocalDate.parse("2022-03-08"), producto.getFechaCreacion());
    }

    @Test
    @DisplayName("Deberia fallar por el nombre del producto")
    void deberiaFallarSinNombreDeProducto() {

        //Arrange
        ProductoTestDataBuilder usuarioTestDataBuilder = new ProductoTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del producto.");
    }

    @Test
    @DisplayName("Deberia fallar por el nombre del producto")
    void deberiaFallarSinPrecioDeProducto() {

        //Arrange
        ProductoTestDataBuilder usuarioTestDataBuilder = new ProductoTestDataBuilder().conPrecio(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio del producto.");
    }

    @Test
    @DisplayName("Deberia fallar por el nombre del producto")
    void deberiaFallarSinCantidadDeProducto() {

        //Arrange
        ProductoTestDataBuilder usuarioTestDataBuilder = new ProductoTestDataBuilder().conCantidad(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el cantidad del producto.");
    }

    @Test
    @DisplayName("Deberia fallar por el nombre del producto")
    void deberiaFallarSinFechaCreacionDeProducto() {

        //Arrange
        ProductoTestDataBuilder usuarioTestDataBuilder = new ProductoTestDataBuilder().conFechaCreacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creacion del producto.");
    }


}