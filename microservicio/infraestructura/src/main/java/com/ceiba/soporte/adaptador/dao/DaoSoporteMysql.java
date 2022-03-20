package com.ceiba.soporte.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.soporte.modelo.dto.DtoSoporte;
import com.ceiba.soporte.puerto.dao.DaoSoporte;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoSoporteMysql implements DaoSoporte {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="soporte", value="listar")
    private static String sqlListar;

    public DaoSoporteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoSoporte> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoSoporte());
    }
}
