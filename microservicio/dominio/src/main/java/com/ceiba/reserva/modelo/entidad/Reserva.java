package com.ceiba.reserva.modelo.entidad;



import com.ceiba.usuario.modelo.entidad.Usuario;


import java.time.LocalDate;
import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

public class Reserva {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION_DE_LA_RESERVA = "Se debe ingresar la fecha en al cual se creo la reserva";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA = "Se debe ingresar la fecha de la reserva";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DE_LA_RESERVA = "Se debe ingresar el codigo de reserva";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA = "Se debe ingresar el nombre de la pelicula";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO = "Debe ingresar el puesto en el que desea estar ubicado";
    private static final String SE_DEBE_INGRESAR_LA_HORA_EN_LA_QUE_SE_CREO_LA_RESERVA = "Se debe ingresar la hora de creacion de la reserva";
    private static final String SE_DEBE_INGRESAR_LA_HORA_DE_LA_RESERVA = "Se debe ingresar la hora de la reserva";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_CARRO = "Se debe ingresar el tipo carro";
    private static final String NO_ACEPTAMOS_RESERVAS_LOS_FINES_DE_SEMANA = "Los fines de semana no permitimos hacer reservas";
    private static final String EL_TIEMPO_DE_RESERVA_FINALIZO = "El horario disponible para hacer la reserva ya termino";
    private static final String EL_TIEMPO_PARA_RESERVAR_NO_HA_INICIADO = "Todavia no esta disponible el horario para hacer una reserva";


    private static final String AUTOMOVIL = "Automovil";
    private static final String CAMIONETA = "Camioneta";

    private static final Double TARIFA_AUTOMOVILES = 40.000;
    private static final Double TARIFA_CAMIONETA = 60.000;


    private static final Integer INICIO_HORARIO_DE_ATENCION = 8;
    private static final Integer FIN_HORARIO_DE_ATENCION = 17;



    private Long idReserva;
    private String codigo;
    private String pelicula;
    private LocalDate fechaCreacion;
    private LocalTime horaCreacion;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private Integer noPuesto;
    private Double tarifa;
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

    public Double getTarifa() {
        return tarifa;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }



    public Reserva(Long id, String codigo, String pelicula, LocalDate fechaCreacion, LocalTime horaCreacion, LocalDate fechaReserva, LocalTime horaReserva, Integer noPuest,
                   String tipoCarro ,Long idCliente) {

        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION_DE_LA_RESERVA);
        validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA);
        validarObligatorio(codigo, SE_DEBE_INGRESAR_EL_CODIGO_DE_LA_RESERVA);
        validarObligatorio(pelicula, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA);
        validarObligatorio(noPuest, SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO);
        validarObligatorio(horaCreacion, SE_DEBE_INGRESAR_LA_HORA_EN_LA_QUE_SE_CREO_LA_RESERVA);
        validarObligatorio(horaReserva, SE_DEBE_INGRESAR_LA_HORA_DE_LA_RESERVA);
        validarObligatorio(tipoCarro, SE_DEBE_INGRESAR_EL_TIPO_CARRO);
        validarDia(fechaCreacion, NO_ACEPTAMOS_RESERVAS_LOS_FINES_DE_SEMANA);
        validarMenor(INICIO_HORARIO_DE_ATENCION,horaCreacion.getHour(), EL_TIEMPO_PARA_RESERVAR_NO_HA_INICIADO);
        validarMenor(horaCreacion.getHour(),FIN_HORARIO_DE_ATENCION, EL_TIEMPO_DE_RESERVA_FINALIZO);


        this.idReserva = id;
        this.codigo = codigo;
        this.pelicula = pelicula;
        this.fechaCreacion = fechaCreacion;
        this.horaCreacion = horaCreacion;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.noPuesto = noPuest;
        this.tarifa = calcularTarifa(tipoCarro);
        this.idUsuario = idCliente;



    }


    private Double calcularTarifa(String tipoCarro){
        Double tarifaFija=0.0;

        if (tipoCarro.equals(AUTOMOVIL)){
            tarifaFija = TARIFA_AUTOMOVILES;
        }
        if (tipoCarro.equals(CAMIONETA)){
            tarifaFija = TARIFA_CAMIONETA;
        }
        return tarifaFija;
    }





}
