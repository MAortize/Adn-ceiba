package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id_usuario;
    private String nombre;
    private String correo;
    private String tipo_carro;
    private String placa;


    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        correo = "1234";
        tipo_carro = "Automovil";
        placa = "ABCD";

    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id_usuario,nombre, correo, tipo_carro, placa);
    }
}
