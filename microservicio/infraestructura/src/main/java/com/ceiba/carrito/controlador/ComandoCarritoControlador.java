package com.ceiba.carrito.controlador;

import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.comando.manejador.MenjadorCrearCarrito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carritos")
@Api(tags = { "Controlador comando carritos"})
public class ComandoCarritoControlador {

    private final MenjadorCrearCarrito menjadorCrearCarrito;

    @Autowired
    public ComandoCarritoControlador(MenjadorCrearCarrito menjadorCrearCarrito) {
        this.menjadorCrearCarrito = menjadorCrearCarrito;
    }

    @PostMapping
    @ApiOperation("Crear carrito")
    public void crear(@RequestBody List<ComandoCarrito> comandoCarrito) {
        menjadorCrearCarrito.ejecutar(comandoCarrito);
    }

}
