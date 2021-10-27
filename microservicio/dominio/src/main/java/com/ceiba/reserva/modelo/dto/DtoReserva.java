package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;




public class DtoReserva {

    private Long idReserva;
    private String codigo;
    private String pelicula;
    private LocalDate fechaCreacion;
    private LocalTime horaCreacion;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private Integer noPuesto;
    private Long idUsuario;

    public Long getIdReserva() {
        return idReserva;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPelicula() {
        return pelicula;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalTime getHoraCreacion() {
        return horaCreacion;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    public Integer getNoPuesto() {
        return noPuesto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public DtoReserva(Long id, String codigo, String pelicula, LocalDate fechaCreacion, LocalTime horaCreacion, LocalDate fechaReserva, LocalTime horaReserva, Integer noPuest, Long idCliente) {

        this.idReserva = id;
        this.codigo = codigo;
        this.pelicula = pelicula;
        this.fechaCreacion = fechaCreacion;
        this.horaCreacion = horaCreacion;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.noPuesto = noPuest;
        this.idUsuario = idCliente;
    }


}
