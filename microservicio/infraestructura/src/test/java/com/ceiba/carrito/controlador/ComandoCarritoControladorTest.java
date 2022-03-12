package com.ceiba.carrito.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.servicio.testdatabuilder.ComandoCarritoTestDataBuilder;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCarrito.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoCarritoControladorTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void crear() throws Exception {

        ComandoCarrito carrito = new ComandoCarritoTestDataBuilder().conId(1L).build();
        List<ComandoCarrito> carritos = new ArrayList<>();
        carritos.add(carrito);

        mocMvc.perform(post("/carritos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carritos)))
                .andExpect(status().isOk());

    }

    @Test
    void actualizar() throws Exception {

        ComandoCarrito carrito = new ComandoCarritoTestDataBuilder().conId(1L).build();

        mocMvc.perform(put("/carritos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Collections.singletonList(carrito))))
                .andExpect(status().isOk());

    }
}