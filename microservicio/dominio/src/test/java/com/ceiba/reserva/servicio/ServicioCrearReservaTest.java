package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearReservaTest {


    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia de la reserva")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLaReserva(){
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioUsuario);


        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, "La reserva ya existe en el sistema");

    }


    @Test
    @DisplayName("Deberia fallar sin un usario para hacer la reserva")
    void deberiaLanzarUnaExcepcionCuandoSeValideQueNoHayUsarioEnLaReserva(){
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioUsuario);
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionSinDatos.class, "El usuario no existe");

    }



    @Test
    @DisplayName("Deberia Crear la reserva de manera correcta")
    void deberiaCrearLaReservaDeManeraCorrecta() {
        // arrange
        LocalTime horaCreacion = LocalTime.of(16,00);
        Reserva reserva = new ReservaTestDataBuilder().conHoraCreacion(horaCreacion).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(3L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioUsuario);
        // act
        Long idReserva = servicioCrearReserva.ejecutar(reserva);
        //- assert
        assertEquals(3L,idReserva);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(reserva);
    }

}
