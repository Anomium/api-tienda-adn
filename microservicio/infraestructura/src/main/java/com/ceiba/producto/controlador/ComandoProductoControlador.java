package com.ceiba.producto.controlador;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.manejador.ManejadorEditarProducto;
import com.ceiba.producto.comando.manejador.ManejadorEliminarProducto;
import com.ceiba.producto.comando.manejador.ManejadorRegistrarProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador comando productos"})
public class ComandoProductoControlador {

    private final ManejadorRegistrarProducto manejadorRegistrarProducto;
    private final ManejadorEditarProducto manejadorEditarProducto;
    private final ManejadorEliminarProducto manejadorEliminarPorducto;

    @Autowired
    public ComandoProductoControlador(ManejadorRegistrarProducto manejadorRegistrarProducto,
                                      ManejadorEditarProducto manejadorEditarProducto,
                                      ManejadorEliminarProducto manejadorEliminarPorducto) {
        this.manejadorRegistrarProducto = manejadorRegistrarProducto;
        this.manejadorEditarProducto = manejadorEditarProducto;
        this.manejadorEliminarPorducto = manejadorEliminarPorducto;
    }

    @PostMapping
    @ApiOperation("Crear producto")
    public void registrar(@RequestBody ComandoProducto comandoProducto) {
        this.manejadorRegistrarProducto.ejecutar(comandoProducto);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualizar producto")
    public void editar(@RequestBody ComandoProducto comandoProducto, @PathVariable Long id) {
        comandoProducto.setId(id);
        this.manejadorEditarProducto.ejecutar(comandoProducto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Elimina un producto")
    public void elimina(@PathVariable Long id) {
        this.manejadorEliminarPorducto.ejecutar(id);
    }

}
