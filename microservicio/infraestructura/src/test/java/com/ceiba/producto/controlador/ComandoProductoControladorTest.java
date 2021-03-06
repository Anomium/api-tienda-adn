package com.ceiba.producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.servicio.testdatabuilder.ComandoProductoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
//@WebMvcTest: Solamente habilita las anotaciones @Controller @ControllerAdvice @JsonComponent...
// y deshabilita @Componente @Service @Repositoru
@WebMvcTest(ComandoProductoControlador.class)
@ContextConfiguration(classes= ApplicationMock.class)
//@DirtiesContext: Le dice al marco de prueba que cierre y recree el contexto para pruebas posteriores
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoProductoControladorTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un producto")
    void registrar() throws Exception {

        ComandoProducto producto = new ComandoProductoTestDataBuilder().conNombre("Esto es una prueba3").build();

        mocMvc.perform(post("/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Deberia editar un producto")
    void editar() throws Exception {

        Long id = 1L;
        ComandoProducto producto = new ComandoProductoTestDataBuilder().conNombre("Esto es una prueba1").build();

        mocMvc.perform(put("/productos/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Deberia eliminar un producto")
    void deberiaEliminarUnProducto() throws Exception {
        // arrange
        Long id = 3L;
        // act - assert
        mocMvc.perform(delete("/productos/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/productos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}