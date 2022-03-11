package com.ceiba.carrito.adaptador.dao;

import com.ceiba.carrito.modelo.dto.DtoCarrito;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCarrito implements RowMapper<DtoCarrito>, MapperResult {

    @Override
    public DtoCarrito mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        Integer cantidad = resultSet.getInt("cantidad");
        Double precio = resultSet.getDouble("precio_producto");
        Double preciototal = resultSet.getDouble("precio_total");
        return new DtoCarrito(id, nombre, cantidad, precio, preciototal);
    }

}
