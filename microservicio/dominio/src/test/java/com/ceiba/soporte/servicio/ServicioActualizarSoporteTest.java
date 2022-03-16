package com.ceiba.soporte.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.soporte.modelo.entidad.Soporte;
import com.ceiba.soporte.puerto.repositorio.RepositorioSoporte;
import com.ceiba.soporte.servicio.testdatabuilder.SoporteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarSoporteTest {

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Soporte soporte = new SoporteTestDataBuilder().conId(1L).build();
        RepositorioSoporte repositorioSoporte = Mockito.mock(RepositorioSoporte.class);
        Mockito.when(repositorioSoporte.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarSoporte servicioActualizarSoporte = new ServicioActualizarSoporte(repositorioSoporte);
        // act
        servicioActualizarSoporte.ejecutar(soporte);
        //assert
        Mockito.verify(repositorioSoporte,Mockito.times(1)).actualizar(soporte);
    }

    @Test
    @DisplayName("Deberia validar la existencia previa del soporte")
    void deberiaValidarLaExistenciaPreviaDelSoporte() {
        // arrange
        Soporte soporte = new SoporteTestDataBuilder().conId(1L).build();
        RepositorioSoporte repositorioSoporte = Mockito.mock(RepositorioSoporte.class);
        Mockito.when(repositorioSoporte.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarSoporte servicioActualizarSoporte = new ServicioActualizarSoporte(repositorioSoporte);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarSoporte.ejecutar(soporte), ExcepcionDuplicidad.class,"El soporte no existe en el sistema");
    }

}
