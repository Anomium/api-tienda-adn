package com.ceiba.soporte.comando.manejador;

import com.ceiba.soporte.modelo.dto.DtoSoporte;
import com.ceiba.soporte.puerto.dao.DaoSoporte;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarSoportes {

    private final DaoSoporte daoSoporte;

    public ManejadorConsultarSoportes(DaoSoporte daoSoporte) {
        this.daoSoporte = daoSoporte;
    }

    public List<DtoSoporte> ejecutar() {
        return this.daoSoporte.listar();
    }
}
