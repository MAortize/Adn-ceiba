package com.ceiba.reserva.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.modelo.entidad.TipoCarro;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.*;
import java.time.temporal.TemporalAdjusters;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA = "Se debe ingresar la fecha de la reserva";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION_DE_LA_RESERVA = "Se debe ingresar la fecha en al cual se creo la reserva";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DE_LA_RESERVA = "Se debe ingresar el codigo de reserva";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA = "Se debe ingresar el nombre de la pelicula";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO = "Debe ingresar el puesto en el que desea estar ubicado";
    private static final String SE_DEBE_INGRESAR_LA_HORA_EN_LA_QUE_SE_CREO_LA_RESERVA = "Se debe ingresar la hora de creacion de la reserva";
    private static final String SE_DEBE_INGRESAR_LA_HORA_DE_LA_RESERVA = "Se debe ingresar la hora de la reserva";
    private static final String EL_TIEMPO_DE_RESERVA_FINALIZO = "El horario disponible para hacer la reserva ya termino";
    private static final String EL_TIEMPO_PARA_RESERVAR_NO_HA_INICIADO = "Todavia no esta disponible el horario para hacer una reserva";
    private static final String NO_ACEPTAMOS_RESERVAS_LOS_FINES_DE_SEMANA = "Los fines de semana no permitimos hacer reservas";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_CARRO = "Se debe ingresar el tipo carro";

    private static final String AUTOMOVIL = "Automovil";
    private static final String CAMIONETA = "Camioneta";

    @Test
    @DisplayName("Deberia crear correctamente una reserva")
    void deberiaCrearCorrectamenteUnaReserva() {

        //arrange
        LocalDate fechaReserva = LocalDate.of(2021,10,29);
        LocalTime horaReserva = LocalTime.of(1, 33);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conIdUsuario(2L).conIdReserva(1L).build();
        //Assert
        assertEquals(1, reserva.getIdReserva());
        assertEquals("12", reserva.getCodigo());
        assertEquals("Avengers", reserva.getPelicula());
        assertEquals(2, reserva.getIdUsuario());
        assertEquals(5, reserva.getNoPuesto());
        assertEquals(fechaReserva, reserva.getFechaReserva());
        assertEquals(horaReserva, reserva.getHoraReserva());
    }

    @Test
    void deberiaFallarSinNombrePelicula() {
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conPelicula(null).conIdReserva(1L);
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA);
    }

    @Test
    void deberiaFallarSinCodigo() {
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCodigo(null).conIdReserva(1L);
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_CODIGO_DE_LA_RESERVA);
    }

    @Test
    void deberiaFallarSinFechaCreacion() {
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaCreacion(null).conIdReserva(1L);
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_CREACION_DE_LA_RESERVA);
    }

    @Test
    void deberiaFallarSinNoPuesto(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conNoPuesto(null).conIdReserva(1L);
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO);
    }


    @Test
    @DisplayName("Deberia fallar si el tiempo de reserva ya ha finalizado")
    void deberiaFallarSiElTiempoDeReservaFinalizo(){
        LocalTime finHoraCreacion = LocalTime.of(18,00);
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conHoraCreacion(finHoraCreacion);
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        },
                ExcepcionValorInvalido.class, EL_TIEMPO_DE_RESERVA_FINALIZO);
    }


    @Test
    @DisplayName("Deberia fallar si el tiempo de reserva no ha iniciado")
    void deberiaFallarSiElTiempoDeReservaNoHaIniciado(){
        LocalTime inicioHoraCreacion = LocalTime.of(6,00);
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conHoraCreacion(inicioHoraCreacion);
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        },
                ExcepcionValorInvalido.class, EL_TIEMPO_PARA_RESERVAR_NO_HA_INICIADO);
    }

    @Test
    void deberiaFallarSinFechaReserva(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaReserva(null);
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA);
    }

    @Test
    void deberiaFallarSinHoraCreacion(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conHoraCreacion(null);
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_HORA_EN_LA_QUE_SE_CREO_LA_RESERVA);
    }

    @Test
    void deberiaFallarSinHoraReserva(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conHoraReserva(null);
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_HORA_DE_LA_RESERVA);
    }

    @Test
    void deberiaFallarSiHaceLaReservaEnSabado(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaReserva(calcNextDay(DayOfWeek.SATURDAY));
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, NO_ACEPTAMOS_RESERVAS_LOS_FINES_DE_SEMANA);
    }

    @Test
    void deberiaFallarSiHaceLaReservaENDomingo(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaReserva(calcNextDay(DayOfWeek.SUNDAY));
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, NO_ACEPTAMOS_RESERVAS_LOS_FINES_DE_SEMANA);
    }

    @Test
    void deberiaFallarSiCreaLaReservaEnSabado(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaCreacion(calcNextDay(DayOfWeek.SATURDAY));
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, NO_ACEPTAMOS_RESERVAS_LOS_FINES_DE_SEMANA);
    }

    @Test
    void deberiaFallarSiCreaLaReservaENDomingo(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaCreacion(calcNextDay(DayOfWeek.SUNDAY));
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, NO_ACEPTAMOS_RESERVAS_LOS_FINES_DE_SEMANA);
    }



    @Test
    void deberiaFallarSinTipoCarro(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conTipoCarro(null);

        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TIPO_CARRO);

    }

    @Test
    void deberiaCrearReservaConTipoCarroCamioneta(){
        Reserva reserva = new ReservaTestDataBuilder().conIdUsuario(2L).conIdReserva(1L).conTipoCarro(TipoCarro.CAMIONETA).build();
        assertEquals(60.000, reserva.getTarifa());
    }

    @Test
    void deberiaCrearReservaConTipoCarroAutomovil(){
        Reserva reserva = new ReservaTestDataBuilder().conIdUsuario(2L).conIdReserva(1L).conTipoCarro(TipoCarro.AUTOMOVIL).build();
        assertEquals(40.000, reserva.getTarifa());
    }



    private LocalDate calcNextDay(DayOfWeek day) {
        return LocalDate.now().with(TemporalAdjusters.next(day));
    }


}
