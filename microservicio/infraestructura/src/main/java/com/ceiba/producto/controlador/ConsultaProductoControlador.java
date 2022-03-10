package com.ceiba.producto.controlador;

import com.ceiba.producto.comando.manejador.ManejadorListarProductos;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags={"Controlador consulta productos"})
public class ConsultaProductoControlador {

    private final ManejadorListarProductos manejadorListarProductos;

    public ConsultaProductoControlador(ManejadorListarProductos manejadorListarProductos) {
        this.manejadorListarProductos = manejadorListarProductos;
    }

    @GetMapping
    @ApiOperation("Obtener todos los productos")
    public List<DtoProducto> listarProdutos() {
        return this.manejadorListarProductos.ejecutar();
    }

}
