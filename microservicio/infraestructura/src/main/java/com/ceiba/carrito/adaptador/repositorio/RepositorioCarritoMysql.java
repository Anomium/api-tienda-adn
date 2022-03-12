package com.ceiba.carrito.adaptador.repositorio;

import com.ceiba.carrito.modelo.entidad.Carrito;
import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCarritoMysql implements RepositorioCarrito {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="carrito", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="carrito", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="carrito", value="existePorNombre")
    private static String sqlExistePorNombre;

    @SqlStatement(namespace="carrito", value="existePorid")
    private static String sqlExistePorId;

    public RepositorioCarritoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public void crear(Carrito carrito) {
        this.customNamedParameterJdbcTemplate.crear(carrito, sqlCrear);
    }

    @Override
    public void actualizar(Carrito carrito) {
        this.customNamedParameterJdbcTemplate.actualizar(carrito, sqlActualizar);
    }

    @Override
    public boolean existeCupon(String cupon) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", cupon);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorNombre, paramSource, Boolean.class));
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorNombre, paramSource, Boolean.class));
    }

}
