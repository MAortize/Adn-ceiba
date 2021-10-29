package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoReservaTestDataBuilder {

    private Long idReserva;
    private String codigo;
    private String pelicula;
    private LocalDate fechaCreacion;
    private LocalTime horaCreacion;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private Integer noPuesto;
    private String tipoCarro;
    private Long idUsuario;

    public ComandoReservaTestDataBuilder(){
        codigo="12346";
        pelicula="xd";
        fechaCreacion = LocalDate.now();
        horaCreacion = LocalTime.of(16,00);
        fechaReserva = LocalDate.of(2021,10,28);
        horaReserva = LocalTime.of(9,37);
        noPuesto = 4;
        tipoCarro = "Automovil";
        idUsuario = 1L;

    }


    public ComandoReservaTestDataBuilder conTipoCarro(String tipoCarro){
        this.tipoCarro = tipoCarro;
        return this;
    }

    public ComandoReservaTestDataBuilder conPelicula(String pelicula){
        this.pelicula = pelicula;
        return this;
    }

    public ComandoReservaTestDataBuilder conFechaCreacion(LocalDate fecha){
        this.fechaCreacion = fecha;
        return this;
    }

    public ComandoReservaTestDataBuilder conHoraCreacion(LocalTime hora){
        this.horaCreacion = hora;
        return this;
    }

    public ComandoReserva build(){
        return new ComandoReserva(idReserva, codigo, pelicula, fechaCreacion,horaCreacion,fechaReserva,horaReserva,noPuesto, tipoCarro,idUsuario);
    }

}
