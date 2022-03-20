package com.ceiba.soporte.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.soporte.modelo.entidad.Soporte;
import com.ceiba.soporte.puerto.repositorio.RepositorioSoporte;

public class ServicioActualizarSoporte {

    private static final String EL_SOPORTE_NO_EXISTE_EN_EL_SISTEMA = "El soporte no existe en el sistema";
    public static final String SOLUCIONADO = "SOLUCIONADO";

    private final RepositorioSoporte repositorioSoporte;

    public ServicioActualizarSoporte(RepositorioSoporte repositorioSoporte) {
        this.repositorioSoporte = repositorioSoporte;
    }

    public void ejecutar(Soporte soporte) {
        this.validarExistenciaPrevia(soporte);
        soporte.setEstado(SOLUCIONADO);
        repositorioSoporte.actualizar(soporte);
    }

    private void validarExistenciaPrevia(Soporte soporte) {
        boolean existe = this.repositorioSoporte.existePorId(soporte.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_SOPORTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
