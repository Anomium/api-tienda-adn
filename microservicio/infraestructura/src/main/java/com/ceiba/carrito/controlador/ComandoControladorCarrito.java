package com.ceiba.carrito.controlador;

import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.comando.manejador.ManejadorActualizarCarrito;
import com.ceiba.carrito.comando.manejador.ManejadorEliminarProductoCarrito;
import com.ceiba.carrito.comando.manejador.MenjadorCrearCarrito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/carritos")
@Api(tags = { "Controlador comando carritos"})
public class ComandoControladorCarrito {

    private final MenjadorCrearCarrito menjadorCrearCarrito;
    private final ManejadorActualizarCarrito manejadorActualizarCarrito;
    private final ManejadorEliminarProductoCarrito manejadorEliminarProductoCarrito;

    @Autowired
    public ComandoControladorCarrito(MenjadorCrearCarrito menjadorCrearCarrito,
                                     ManejadorActualizarCarrito manejadorActualizarCarrito,
                                     ManejadorEliminarProductoCarrito manejadorEliminarProductoCarrito) {
        this.menjadorCrearCarrito = menjadorCrearCarrito;
        this.manejadorActualizarCarrito = manejadorActualizarCarrito;
        this.manejadorEliminarProductoCarrito = manejadorEliminarProductoCarrito;
    }

    @PostMapping
    @ApiOperation("Crear carrito")
    public void crear(@RequestBody ComandoCarrito comandoCarrito) {
        menjadorCrearCarrito.ejecutar(Collections.singletonList(comandoCarrito));
    }

    @PutMapping
    @ApiOperation("Actualizar carrito")
    public void actualizar(@RequestBody ComandoCarrito comandoCarrito) {
        manejadorActualizarCarrito.ejecutar(Collections.singletonList(comandoCarrito));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Elimina carrito")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProductoCarrito.ejecutar(id);
    }

}
