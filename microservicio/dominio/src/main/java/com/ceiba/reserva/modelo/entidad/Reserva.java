package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION_DE_LA_RESERVA = "Se debe ingresar la fecha en al cual se creo la reserva";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA = "Se debe ingresar la fecha de la reserva";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DE_LA_RESERVA = "Se debe ingresar el codigo de reserva";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA = "Se debe ingresar el nombre de la pelicula";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO = "Debe ingresar el puesto en el que desea estar ubicado";
    private static final String EL_TIEMPO_DE_RESERVA_FINALIZO = "El horario disponible para hacer la reserva ya termino";
    private static final String EL_TIEMPO_PARA_RESERVAR_NO_HA_INICIADO = "Todavia no esta disponible el horario para hacer una reserva";


    private static final Integer CAPACIDAD_MAXIMA_DE_PUESTOS = 100;
    private static final Double TARIFA_ENTRADA_AUTOMOVILES = 40.000;
    private static final Double TARIFA_ENTRADA_CAMIONETA = 60.000;
    private static final Integer INICIO_HORARIO_DE_ATENCION = 8;
    private static final Integer FIN_HORARIO_DE_ATENCION = 17;

    //private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";


    private Long id_reserva;
    private String codigo;
    private String pelicula;
    private LocalDate fechaCreacion;
    private LocalTime horaCreacion;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private Integer no_puesto;
    private Long id_cliente;

    public Reserva(Long idReserva, String codigo, String pelicula, LocalDate fechaCreacion, LocalTime horaCreacion, LocalDate fechaReserva, LocalTime horaReserva, Integer noPuesto, Long idCliente) {

        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION_DE_LA_RESERVA);
        validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA);
        validarObligatorio(codigo, SE_DEBE_INGRESAR_EL_CODIGO_DE_LA_RESERVA);
        validarObligatorio(pelicula, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA);
        validarObligatorio(noPuesto, SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO);
        validarMenor(INICIO_HORARIO_DE_ATENCION,horaCreacion.getHour(), EL_TIEMPO_PARA_RESERVAR_NO_HA_INICIADO);
        validarMenor(horaCreacion.getHour(),FIN_HORARIO_DE_ATENCION, EL_TIEMPO_DE_RESERVA_FINALIZO);

        this.id_reserva = idReserva;
        this.codigo = codigo;
        this.pelicula = pelicula;
        this.fechaCreacion = fechaCreacion;
        this.horaCreacion = horaCreacion;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.no_puesto = noPuesto;
        this.id_cliente = idCliente;
    }
}
