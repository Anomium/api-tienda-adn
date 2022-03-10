package com.ceiba.producto.controlador;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.manejador.ManejadorEditarProducto;
import com.ceiba.producto.comando.manejador.ManejadorListarProductos;
import com.ceiba.producto.comando.manejador.ManejadorRegistrarProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador comando productos"})
public class ComandoProductoControlador {

    private final ManejadorRegistrarProducto manejadorRegistrarProducto;
    private final ManejadorEditarProducto manejadorEditarProducto;
    private final ManejadorListarProductos manejadorListarProductos;

    @Autowired
    public ComandoProductoControlador(ManejadorRegistrarProducto manejadorRegistrarProducto,
                                      ManejadorEditarProducto manejadorEditarProducto,
                                      ManejadorListarProductos manejadorListarProductos) {
        this.manejadorRegistrarProducto = manejadorRegistrarProducto;
        this.manejadorEditarProducto = manejadorEditarProducto;
        this.manejadorListarProductos = manejadorListarProductos;
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

    @GetMapping
    @ApiOperation("Obtener todos los productos")
    public List<DtoProducto> listarProdutos() {
        return this.manejadorListarProductos.ejecutar();
    }

}
