package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long idUsuario;
    private String nombreUsuario;
    private String correo;
    private String tipoCarro;
    private String placa;


    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        correo = "1234";
        tipoCarro = "Automovil";
        placa = "ABCD";

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

    public UsuarioTestDataBuilder conTipoCarro(String vehiculo){
        this.tipoCarro = vehiculo;
        return this;
    }

    public UsuarioTestDataBuilder conPlaca(String placa){
        this.placa = placa;
        return this;
    }

    public Usuario build() {
        return new Usuario(idUsuario,nombreUsuario,correo,tipoCarro,placa);
    }
}
