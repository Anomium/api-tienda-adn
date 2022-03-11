package com.ceiba.carrito.comando.manejador;

import com.ceiba.carrito.modelo.dto.DtoCarrito;
import com.ceiba.carrito.puerto.dao.DaoCarrito;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCarritos {

    private final DaoCarrito daoCarrito;

    public ManejadorListarCarritos(DaoCarrito daoCarrito) {
        this.daoCarrito = daoCarrito;
    }

    public List<DtoCarrito> ejecutar() {
        return this.daoCarrito.listar();
    }
}
