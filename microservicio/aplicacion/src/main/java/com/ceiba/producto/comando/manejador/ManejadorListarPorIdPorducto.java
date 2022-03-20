package com.ceiba.producto.comando.manejador;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarPorIdPorducto {

    private final DaoProducto daoProducto;

    public ManejadorListarPorIdPorducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public DtoProducto ejecutar(Long id) {
        return this.daoProducto.listar(id);
    }

}
