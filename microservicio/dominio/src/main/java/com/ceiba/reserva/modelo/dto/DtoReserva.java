package com.ceiba.reserva.modelo.dto;



import java.time.LocalDate;
import java.time.LocalTime;




public class DtoReserva {

    private Long idReservaDto;
    private String codigoDto;
    private String peliculaDto;
    private LocalDate fechaCreacionDto;
    private LocalTime horaCreacionDto;
    private LocalDate fechaReservaDto;
    private LocalTime horaReservaDto;
    private Integer noPuestoDto;
    private Long idUsuarioReservaDto;

    public Long getIdReservaDto() {
        return idReservaDto;
    }

    public String getCodigoDto() {
        return codigoDto;
    }

    public String getPeliculaDto() {
        return peliculaDto;
    }

    public LocalDate getFechaCreacionDto() {
        return fechaCreacionDto;
    }

    public LocalTime getHoraCreacionDto() {
        return horaCreacionDto;
    }

    public LocalDate getFechaReservaDto() {
        return fechaReservaDto;
    }

    public LocalTime getHoraReservaDto() {
        return horaReservaDto;
    }

    public Integer getNoPuestoDto() {
        return noPuestoDto;
    }

    public Long getIdUsuarioReservaDto() {
        return idUsuarioReservaDto;
    }

    public DtoReserva(Long idReservaDto, String codigoDto, String peliculaDto, LocalDate fechaCreacionDto, LocalTime horaCreacionDto, LocalDate fechaReservaDto,
                      LocalTime horaReservaDto, Integer noPuestoDto, Long idUsuarioReservaDto) {
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
