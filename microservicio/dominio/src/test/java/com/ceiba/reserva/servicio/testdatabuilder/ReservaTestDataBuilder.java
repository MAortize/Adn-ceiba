package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaTestDataBuilder {
    private Long id_reserva;
    private String codigo;
    private String pelicula;
    private LocalDate fechaCreacion;
    private LocalTime horaCreacion;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private Integer no_puesto;
    private Long id_usuario;


    public ReservaTestDataBuilder() {
        codigo = "12";
        pelicula = "Avengers";
        fechaCreacion = LocalDate.now();
        horaCreacion = LocalTime.of(16,00);
        fechaReserva = LocalDate.of(2021,10,30);
        horaReserva = LocalTime.of(1,33);
        no_puesto = 5;
        id_usuario = 1L;

    }

    public ReservaTestDataBuilder conCodigo(String codigo){
            this.codigo = codigo;
            return this;
    }

    public ReservaTestDataBuilder conPelicula(String pelicula){
        this.pelicula = pelicula;
        return this;
    }

    public ReservaTestDataBuilder conFechaCreacion(LocalDate fechaCreacion){
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public ReservaTestDataBuilder conHoraCreacion(LocalTime horaCreacion){
        this.horaCreacion = horaCreacion;
        return this;
    }

    public ReservaTestDataBuilder conFechaReserva(LocalDate fechaReserva){
        this.fechaReserva = fechaReserva;
        return this;
    }

    public ReservaTestDataBuilder conHoraReserva(LocalTime horaReserva){
        this.horaReserva = horaReserva;
        return this;
    }

    public ReservaTestDataBuilder conNoPuesto(Integer noPuesto){
        this.no_puesto = noPuesto;
        return this;
    }

    public ReservaTestDataBuilder conIdReserva(Long id){
        this.id_reserva = id;
        return this;
    }

    public ReservaTestDataBuilder conIdUsuario(Long id){
        this.id_usuario = id;
        return this;
    }

    public Reserva build(){
        return new Reserva(id_reserva,codigo,pelicula,fechaCreacion,horaCreacion,fechaReserva,horaReserva,no_puesto, id_usuario);
    }

}
