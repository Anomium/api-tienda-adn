package com.ceiba.soporte.controlador;

import com.ceiba.soporte.comando.ComandoSoporte;
import com.ceiba.soporte.comando.manejador.ManejadorActualizarSoporte;
import com.ceiba.soporte.comando.manejador.ManejadorCrearSoporte;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soporte")
@Api(tags={"Controlador comando soporte"})
public class ComandoControladorSoporte {

    private final ManejadorCrearSoporte manejadorCrearSoporte;
    private final ManejadorActualizarSoporte manejadorActualizarSoporte;

    @Autowired
    public ComandoControladorSoporte(ManejadorCrearSoporte manejadorCrearSoporte,
                                     ManejadorActualizarSoporte manejadorActualizarSoporte) {
        this.manejadorCrearSoporte = manejadorCrearSoporte;
        this.manejadorActualizarSoporte = manejadorActualizarSoporte;
    }

    @PostMapping
    @ApiOperation("Crear soporte")
    public void crear(@RequestBody ComandoSoporte comandoSoporte) {
        manejadorCrearSoporte.ejecutar(comandoSoporte);
    }

    @PutMapping
    @ApiOperation("Actualizar estado de soporte")
    public void actualizar(@RequestBody ComandoSoporte comandoSoporte) {
        manejadorActualizarSoporte.ejecutar(comandoSoporte);
    }

}
