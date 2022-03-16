package com.ceiba.soporte.comando.fabrica;

import com.ceiba.soporte.comando.ComandoSoporte;
import com.ceiba.soporte.modelo.entidad.Soporte;
import org.springframework.stereotype.Component;

@Component
public class FabricaSoporte {

    public Soporte crear(ComandoSoporte comandoSoporte) {
        return new Soporte(
                comandoSoporte.getId(),
                comandoSoporte.getDescripcion(),
                comandoSoporte.getFechaCreacion(),
                comandoSoporte.getFechaASolucionar(),
                comandoSoporte.getEstado()
        );
    }

}
