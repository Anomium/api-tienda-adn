package com.ceiba.soporte.servicio;

import com.ceiba.soporte.modelo.entidad.Soporte;
import com.ceiba.soporte.puerto.repositorio.RepositorioSoporte;
import com.ceiba.soporte.servicio.testdatabuilder.SoporteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearSoporteTest {

    @Test
    @DisplayName("Deberia crearse el soporte de manera correcta")
    void deberiaCrearseElSoporteDeManeraCorrecta() {
        // arrange
        Soporte soporte = new SoporteTestDataBuilder().build();
        RepositorioSoporte repositorioSoporte = Mockito.mock(RepositorioSoporte.class);
        Mockito.when(repositorioSoporte.crear(soporte)).thenReturn(10L);
        ServicioCrearSoporte servicioCrearSoporte = new ServicioCrearSoporte(repositorioSoporte);

        Long idSoporte = servicioCrearSoporte.ejecutar(soporte);
        // act - assert
        assertEquals(10L,idSoporte);
        Mockito.verify(repositorioSoporte, Mockito.times(1)).crear(soporte);
    }


}
