package com.ceiba.soporte.controlador;

import com.ceiba.soporte.comando.manejador.ManejadorConsultarSoportes;
import com.ceiba.soporte.modelo.dto.DtoSoporte;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/soporte")
@Api(tags={"Controlador consulta soporte"})
public class ConsultaControladorSoporte {

    private final ManejadorConsultarSoportes manejadorConsultarSoportes;

    public ConsultaControladorSoporte(ManejadorConsultarSoportes manejadorConsultarSoportes) {
        this.manejadorConsultarSoportes = manejadorConsultarSoportes;
    }

    @GetMapping
    @ApiOperation("Listar Soportes")
    public List<DtoSoporte> listar() {
        return manejadorConsultarSoportes.ejecutar();
    }

}
