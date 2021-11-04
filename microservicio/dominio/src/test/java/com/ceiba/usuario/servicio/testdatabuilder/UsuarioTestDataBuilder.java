package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long idUsuario;
    private String nombreUsuario;
    private String correo;



    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        correo = "1234";


    }
    public UsuarioTestDataBuilder conId(Long id) {
        this.idUsuario = id;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public UsuarioTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }



    public Usuario build() {
        return new Usuario(idUsuario,nombreUsuario,correo);
    }
}
