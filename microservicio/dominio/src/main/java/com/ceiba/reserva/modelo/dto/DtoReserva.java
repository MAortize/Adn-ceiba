package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class DtoReserva {

    private String codigo;
    private String pelicula;
    private LocalDate fechaCreacion;
    private LocalTime horaCreacion;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;

}
