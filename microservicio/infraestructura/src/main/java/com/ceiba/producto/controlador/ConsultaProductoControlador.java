package com.ceiba.producto.controlador;

import com.ceiba.producto.comando.manejador.ManejadorListarPorIdPorducto;
import com.ceiba.producto.comando.manejador.ManejadorListarProductos;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags={"Controlador consulta productos"})
public class ConsultaProductoControlador {

    private final ManejadorListarProductos manejadorListarProductos;
    private final ManejadorListarPorIdPorducto manejadorListarPorIdPorducto;

    public ConsultaProductoControlador(ManejadorListarProductos manejadorListarProductos,
                                       ManejadorListarPorIdPorducto manejadorListarPorIdPorducto) {
        this.manejadorListarProductos = manejadorListarProductos;
        this.manejadorListarPorIdPorducto = manejadorListarPorIdPorducto;
    }

    @GetMapping
    @ApiOperation("Obtener todos los productos")
    public List<DtoProducto> listarProdutos() {
        return this.manejadorListarProductos.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener todos los productos")
    public DtoProducto listarProdutosPorId(@PathVariable Long id) {
        return this.manejadorListarPorIdPorducto.ejecutar(id);
    }
}
