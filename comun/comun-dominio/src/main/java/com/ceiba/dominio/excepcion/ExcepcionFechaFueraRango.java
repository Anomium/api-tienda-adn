package com.ceiba.dominio.excepcion;

public class ExcepcionFechaFueraRango extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionFechaFueraRango(String mensaje) {
        super(mensaje);
    }

}
