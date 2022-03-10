package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {


    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        Double precio = resultSet.getDouble("precio");
        Integer cantidad = resultSet.getInt("cantidad");
        LocalDate fechaCreacion = LocalDate.parse(resultSet.getString("fecha_creacion"), formatter);
        return new DtoProducto(id, nombre, precio, cantidad, fechaCreacion);
    }
}
