package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {


    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_CARRO = "Se debe ingresar el tipo de carro";
    private static final String SE_DEBE_INGRESAR_LA_PLACA_DEL_CARRO = "Se debe ingresar la placa del carro";




    private Long idUsuario;
    private String nombre;
    private String correo;
    private String tipoCarro;
    private String placa;

    public Usuario(Long id,String nombre, String correo, String tipoCarro, String placa) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(correo, SE_DEBE_INGRESAR_LA_CLAVE);
        validarObligatorio(tipoCarro, SE_DEBE_INGRESAR_EL_TIPO_DE_CARRO);
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA_DEL_CARRO);


        this.idUsuario = id;
        this.nombre = nombre;
        this.correo = correo;
        this.tipoCarro = tipoCarro;
        this.placa = placa;

    }

}
