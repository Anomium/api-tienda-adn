package com.ceiba.carrito.controlador;

import com.ceiba.ApplicationMock;
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
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorCarrito.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorCarritoTest {


    private final MockMvc mocMvc;

    @Autowired
    ConsultaControladorCarritoTest(MockMvc mocMvc) {
        this.mocMvc = mocMvc;
    }

    @Test
    void listarCarritos() throws Exception {

        mocMvc.perform(get("/carritos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is("Esto es una prueba")))
                .andExpect(jsonPath("$[0].precio", is(30.0)))
                .andExpect(jsonPath("$[0].cantidad", is(6)))
                .andExpect(jsonPath("$[0].precioTotal", is(40.0)))
                .andExpect(jsonPath("$[0].id", is(1)));

    }

}
