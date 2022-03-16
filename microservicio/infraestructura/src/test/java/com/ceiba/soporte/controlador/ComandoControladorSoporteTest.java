package com.ceiba.soporte.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.servicio.testdatabuilder.ComandoCarritoTestDataBuilder;
import com.ceiba.soporte.comando.ComandoSoporte;
import com.ceiba.soporte.servicio.testdatabuilder.ComandoSoporteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorSoporte.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorSoporteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void crearSoporte() throws Exception {
        ComandoSoporte soporte = new ComandoSoporteTestDataBuilder().conId(1L).build();

        mocMvc.perform(post("/soporte")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(soporte)))
                .andExpect(status().isOk());
    }

    @Test
    void actualizar() throws Exception {

        ComandoSoporte carrito = new ComandoSoporteTestDataBuilder().conId(1L).conDescripcion("prueba2").build();

        mocMvc.perform(put("/soporte")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carrito)))
                .andExpect(status().isOk());

    }

}
