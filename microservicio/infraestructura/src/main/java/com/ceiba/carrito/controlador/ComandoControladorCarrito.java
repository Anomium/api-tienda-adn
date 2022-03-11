package com.ceiba.carrito.controlador;

import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.comando.manejador.ManejadorActualizarCarrito;
import com.ceiba.carrito.comando.manejador.MenjadorCrearCarrito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
@Api(tags = { "Controlador comando carritos"})
public class ComandoControladorCarrito {

    private final MenjadorCrearCarrito menjadorCrearCarrito;
    private final ManejadorActualizarCarrito manejadorActualizarCarrito;

    @Autowired
    public ComandoControladorCarrito(MenjadorCrearCarrito menjadorCrearCarrito,
                                     ManejadorActualizarCarrito manejadorActualizarCarrito) {
        this.menjadorCrearCarrito = menjadorCrearCarrito;
        this.manejadorActualizarCarrito = manejadorActualizarCarrito;
    }

    @PostMapping
    @ApiOperation("Crear carrito")
    public void crear(@RequestBody List<ComandoCarrito> comandoCarrito) {
        menjadorCrearCarrito.ejecutar(comandoCarrito);
    }

    @PutMapping
    @ApiOperation("Actualizar carrito")
    public void actualizar(@RequestBody List<ComandoCarrito> comandoCarrito) {
        manejadorActualizarCarrito.ejecutar(comandoCarrito);
    }

}
