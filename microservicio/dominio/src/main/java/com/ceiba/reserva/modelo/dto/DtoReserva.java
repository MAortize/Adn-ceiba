package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class DtoReserva {

    private Long idReservaDto;
    private String codigoDto;
    private String peliculaDto;
    private LocalDate fechaCreacionDto;
    private LocalTime horaCreacionDto;
    private LocalDate fechaReservaDto;
    private LocalTime horaReservaDto;
    private Integer noPuestoDto;
    private Double tarifa;
    private Long idUsuarioReservaDto;



}
