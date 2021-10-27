package com.ceiba.reserva.adaptador;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;


public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id_reserva = resultSet.getLong("id_reserva");
        String codigo = resultSet.getString("codigo");
        String pelicula = resultSet.getString("pelicula");
        LocalDate fecha_creacion = resultSet.getDate("fecha_creacion").toLocalDate();
        LocalTime hora_creacion = resultSet.getTime("hora_creacion").toLocalTime();
        LocalDate fecha_reserva = resultSet.getDate("fecha_reserva").toLocalDate();
        LocalTime hora_reserva = resultSet.getTime("hora_reserva").toLocalTime();
        Integer no_puesto = resultSet.getInt("no_puesto");
        Long id_usuario_fk = resultSet.getLong("id_usuario_fk");


        return new DtoReserva(id_reserva, codigo, pelicula, fecha_creacion, hora_creacion, fecha_reserva, hora_reserva,
                no_puesto, id_usuario_fk);
    }
}
