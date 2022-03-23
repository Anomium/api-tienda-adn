package com.ceiba.producto.servicio;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioCrearProductoTest {

    @Test
    @DisplayName("Deberia crear correctamente en el repositorio")
    void deberiaCrearCorrectamenteEnElRepositorio() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conId(1L).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        ServicioRegistrarProducto servicioRegistrarProducto = new ServicioRegistrarProducto(repositorioProducto);
        // act
        servicioRegistrarProducto.ejecutar(producto);
        //assert
        Mockito.verify(repositorioProducto,Mockito.times(1)).crear(producto);
    }

}
