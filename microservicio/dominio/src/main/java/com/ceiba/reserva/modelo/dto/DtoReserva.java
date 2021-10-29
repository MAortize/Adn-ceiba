package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
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


    public DtoReserva(Long idReservaDto, String codigoDto, String peliculaDto, LocalDate fechaCreacionDto, LocalTime horaCreacionDto,
                      LocalDate fechaReservaDto, LocalTime horaReservaDto, Integer noPuestoDto, Long idUsuarioReservaDto) {
        this.idReservaDto = idReservaDto;
        this.codigoDto = codigoDto;
        this.peliculaDto = peliculaDto;
        this.fechaCreacionDto = fechaCreacionDto;
        this.horaCreacionDto = horaCreacionDto;
        this.fechaReservaDto = fechaReservaDto;
        this.horaReservaDto = horaReservaDto;
        this.noPuestoDto = noPuestoDto;
        this.idUsuarioReservaDto = idUsuarioReservaDto;
    }
}
