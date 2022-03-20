package com.ceiba.soporte.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.soporte.modelo.dto.DtoSoporte;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MapeoSoporte implements RowMapper<DtoSoporte>, MapperResult {


    @Override
    public DtoSoporte mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Long id = resultSet.getLong("id");
        String descripcion = resultSet.getString("descripcion_soporte");
        LocalDate fechaCreacion = LocalDate.parse(resultSet.getString("fecha_a_solucionar"), formatter);
        String estado = resultSet.getString("estado");

        return new DtoSoporte(id, descripcion, fechaCreacion, estado);
    }
}
