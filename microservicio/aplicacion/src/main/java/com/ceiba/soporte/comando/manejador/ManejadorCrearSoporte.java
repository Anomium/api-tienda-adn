package com.ceiba.soporte.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.soporte.comando.ComandoSoporte;
import com.ceiba.soporte.comando.fabrica.FabricaSoporte;
import com.ceiba.soporte.modelo.entidad.Soporte;
import com.ceiba.soporte.servicio.ServicioCrearSoporte;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSoporte implements ManejadorComando<ComandoSoporte> {

    private final FabricaSoporte fabricaSoporte;
    private final ServicioCrearSoporte servicioCrearSoporte;

    public ManejadorCrearSoporte(FabricaSoporte fabricaSoporte,
                                 ServicioCrearSoporte servicioCrearSoporte) {
        this.fabricaSoporte = fabricaSoporte;
        this.servicioCrearSoporte = servicioCrearSoporte;
    }

    public void ejecutar(ComandoSoporte comandoSoporte) {
        Soporte soporte = this.fabricaSoporte.crear(comandoSoporte);
        this.servicioCrearSoporte.ejecutar(soporte);
    }

}
