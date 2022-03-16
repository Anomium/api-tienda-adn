package com.ceiba.soporte.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.soporte.comando.ComandoSoporte;
import com.ceiba.soporte.comando.fabrica.FabricaSoporte;
import com.ceiba.soporte.modelo.entidad.Soporte;
import com.ceiba.soporte.servicio.ServicioActualizarSoporte;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarSoporte implements ManejadorComando<ComandoSoporte> {

    public final FabricaSoporte fabricaSoporte;
    public final ServicioActualizarSoporte servicioActualizarSoporte;

    public ManejadorActualizarSoporte(FabricaSoporte fabricaSoporte, ServicioActualizarSoporte servicioActualizarSoporte) {
        this.fabricaSoporte = fabricaSoporte;
        this.servicioActualizarSoporte = servicioActualizarSoporte;
    }

    public void ejecutar(ComandoSoporte comandoSoporte) {
        Soporte soporte = fabricaSoporte.crear(comandoSoporte);
        this.servicioActualizarSoporte.ejecutar(soporte);
    }

}
