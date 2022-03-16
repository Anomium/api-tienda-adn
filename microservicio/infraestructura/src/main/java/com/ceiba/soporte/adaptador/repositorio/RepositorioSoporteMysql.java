package com.ceiba.soporte.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.soporte.modelo.entidad.Soporte;
import com.ceiba.soporte.puerto.repositorio.RepositorioSoporte;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSoporteMysql implements RepositorioSoporte {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="soporte", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="soporte", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="soporte", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioSoporteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Soporte soporte) {
        return this.customNamedParameterJdbcTemplate.crear(soporte, sqlCrear);
    }

    @Override
    public void actualizar(Soporte soporte) {
        this.customNamedParameterJdbcTemplate.actualizar(soporte, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExistePorId, paramSource, Boolean.class));
    }


}
