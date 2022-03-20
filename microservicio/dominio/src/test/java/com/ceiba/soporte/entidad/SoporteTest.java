package com.ceiba.soporte.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.soporte.modelo.entidad.Soporte;
import com.ceiba.soporte.servicio.testdatabuilder.SoporteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SoporteTest {

    @Test
    @DisplayName("Deberia crear correctamente el soporte")
    void deberiaCrearCorrectamenteElSoporte() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Soporte soporte = new SoporteTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1L, soporte.getId());
        assertEquals(LocalDate.parse("2022-03-08"), soporte.getFechaCreacion());
        assertEquals(LocalDate.parse("2022-03-08"), soporte.getFechaASolucionar());
        assertEquals("PENDIENTE", soporte.getEstado());
    }

    @Test
    void deberiaFallarSinNombreDeUsuario() {

        //Arrange
        SoporteTestDataBuilder usuarioTestDataBuilder = new SoporteTestDataBuilder().conDescripcion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la descripcion.");
    }

}
