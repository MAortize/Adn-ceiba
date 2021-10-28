package com.ceiba.reserva.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalTime;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION_DE_LA_RESERVA = "Se debe ingresar la fecha en al cual se creo la reserva";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DE_LA_RESERVA = "Se debe ingresar el codigo de reserva";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA = "Se debe ingresar el nombre de la pelicula";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO = "Debe ingresar el puesto en el que desea estar ubicado";


    @Test
    @DisplayName("Deberia crear correctamente una reserva")
    void deberiaCrearCorrectamenteUnaReserva() {

        //arrange
        LocalDate fechaCreacion = LocalDate.now();
        LocalTime horaCreacion = LocalTime.now();
        LocalDate fechaReserva = LocalDate.of(2021,10,30);
        LocalTime horaReserva = LocalTime.of(1, 33);
        //act
        Reserva reserva = new ReservaTestDataBuilder().conFechaCreacion(fechaCreacion).conHoraCreacion(horaCreacion)
                .conIdUsuario(1L).conIdReserva(1L).build();
        //Assert
        assertEquals(1, reserva.getIdReserva());
        assertEquals("12", reserva.getCodigo());
        assertEquals("Avengers", reserva.getPelicula());
        assertEquals(1, reserva.getIdUsuario());
        assertEquals(5, reserva.getNoPuesto());
        assertEquals(fechaReserva, reserva.getFechaReserva());
        assertEquals(horaReserva, reserva.getHoraReserva());
    }

    @Test
    void deberiaFallarSinNombrePelicula() {
        LocalDate fechaCreacion = LocalDate.now();
        LocalTime horaCreacion = LocalTime.now();
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conPelicula(null).conIdReserva(1L)
                .conFechaCreacion(fechaCreacion).conHoraCreacion(horaCreacion);
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA);
    }

    @Test
    void deberiaFallarSinCodigo() {
        LocalDate fechaCreacion = LocalDate.now();
        LocalTime horaCreacion = LocalTime.now();
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCodigo(null).conIdReserva(1L)
                .conFechaCreacion(fechaCreacion).conHoraCreacion(horaCreacion);
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_CODIGO_DE_LA_RESERVA);
    }

    @Test
    void deberiaFallarSinFechaCreacion() {
        LocalTime horaCreacion = LocalTime.now();
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaCreacion(null)
                .conHoraCreacion(horaCreacion).conIdReserva(1L);
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_CREACION_DE_LA_RESERVA);
    }

    @Test
    void deberiaFallarSinNoPuesto(){
        LocalDate fechaCreacion = LocalDate.now();
        LocalTime horaCreacion = LocalTime.now();
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conNoPuesto(null)
                .conFechaCreacion(fechaCreacion)
                .conHoraCreacion(horaCreacion).conIdReserva(1L);
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO);
    }


}
