package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long idUsuario;
    private String nombre;
    private String correo;



    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        correo = "1234";


    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(idUsuario,nombre, correo);
    }
}
