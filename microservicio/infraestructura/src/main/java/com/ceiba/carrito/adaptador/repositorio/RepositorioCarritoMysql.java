package com.ceiba.carrito.adaptador.repositorio;

import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCarritoMysql implements RepositorioCarrito {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="carrito", value="crear")
    private static String sqlCrear;

    public RepositorioCarritoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public void crear(Carrito carrito) {
        this.customNamedParameterJdbcTemplate.crear(carrito, sqlCrear);
    }

}
