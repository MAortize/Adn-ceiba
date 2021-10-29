package com.ceiba.reserva.adaptador.dao;

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

        Long idReserva = resultSet.getLong("id");
        String codigo = resultSet.getString("codigo");
        String pelicula = resultSet.getString("pelicula");
        LocalDate fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
        LocalTime horaCreacion = resultSet.getTime("hora_creacion").toLocalTime();
        LocalDate fechaReserva = resultSet.getDate("fecha_reserva").toLocalDate();
        LocalTime horaReserva = resultSet.getTime("hora_reserva").toLocalTime();
        Integer noPuesto = resultSet.getInt("no_puesto");
        Double tarifa = resultSet.getDouble("tarifa");
        Long idUsuarioFk = resultSet.getLong("id_usuario_fk");


        return new DtoReserva(idReserva, codigo, pelicula, fechaCreacion, horaCreacion, fechaReserva, horaReserva,
                noPuesto, idUsuarioFk);
    }
}
