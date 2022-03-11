package com.ceiba.carrito.controlador;

import com.ceiba.carrito.comando.manejador.ManejadorListarCarritos;
import com.ceiba.carrito.modelo.dto.DtoCarrito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
@Api(tags = { "Controlador comando carritos"})
public class ConsultaControladorCarrito {

    private final ManejadorListarCarritos manejadorListarCarritos;

    public ConsultaControladorCarrito(ManejadorListarCarritos manejadorListarCarritos) {
        this.manejadorListarCarritos = manejadorListarCarritos;
    }

    @GetMapping
    @ApiOperation("Listar carrito")
    public List<DtoCarrito> actualizar() {
        return manejadorListarCarritos.ejecutar();
    }

}
