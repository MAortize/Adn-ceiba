package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearReservaTest {

    @Test
    @DisplayName("Deberia Crear la reserva de manera correcta")
    void deberiaCrearLaReservaDeManeraCorrecta() {
        // arrange
        LocalDate fechaCreacion = LocalDate.now();
        LocalTime horaCreacion = LocalTime.now();
        Reserva reserva = new ReservaTestDataBuilder().conFechaCreacion(fechaCreacion).conHoraCreacion(horaCreacion.minusHours(3)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(2L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act
        Long idReserva = servicioCrearReserva.ejecutar(reserva);
        //- assert
        assertEquals(2L,idReserva);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(reserva);
    }

}
