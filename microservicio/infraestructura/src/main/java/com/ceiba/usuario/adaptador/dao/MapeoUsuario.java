package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id_usuario = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String correo = resultSet.getString("correo");
        String tipo_carro = resultSet.getString("tipo_carro");
        String placa = resultSet.getString("placa");


        return new DtoUsuario(id_usuario,nombre,correo,tipo_carro,placa);
    }

}
