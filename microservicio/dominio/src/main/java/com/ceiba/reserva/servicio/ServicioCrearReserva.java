package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;


public class ServicioCrearReserva {
    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    private static final String EL_USUARIO_NO_EXISTE = "El usuario no existe";

    private final RepositorioReserva repositorioReserva;

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioUsuario repositorioUsuario) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Reserva reserva){
        validarExistenciaPrevia(reserva);
        validarExistenciaUsuario(reserva.getIdUsuario());
        return this.repositorioReserva.crear(reserva);
    }

    private void validarExistenciaUsuario(Long idUsuario){
        boolean existe =this.repositorioUsuario.existePorId(idUsuario);
        if (!existe){
            throw new ExcepcionSinDatos(EL_USUARIO_NO_EXISTE);
        }

    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getCodigo());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }



}
