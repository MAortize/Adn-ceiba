package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearReserva {
    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    private final RepositorioReserva repositorioReserva;
    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioUsuario repositorioUsuario) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Reserva reserva, Usuario usuario){
        validarExistenciaPrevia(reserva, usuario);
        return this.repositorioReserva.crear(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva, Usuario usuario) {
        boolean existe = this.repositorioReserva.existe(reserva.getCodigo());
        boolean existeUsu = this.repositorioUsuario.existe(usuario.getNombre());
        if(existe&&existeUsu) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
