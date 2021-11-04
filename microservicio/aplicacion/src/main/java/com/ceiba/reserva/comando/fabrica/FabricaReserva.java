package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.usuario.comando.ComandoUsuario;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva){
        return new Reserva(
                comandoReserva.getIdReserva(),
                comandoReserva.getCodigo(),
                comandoReserva.getPelicula(),
                LocalDate.now(),
                LocalTime.of(16,00),
                comandoReserva.getFechaReserva(),
                comandoReserva.getHoraReserva(),
                comandoReserva.getNoPuesto(),
                comandoReserva.getTipoCarro(),
                comandoReserva.getIdUsuarioReserva()



        );
    }
}
