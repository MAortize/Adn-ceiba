package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_CARRO = "Se debe ingresar el tipo de carro";
    private static final String SE_DEBE_INGRESAR_LA_PLACA_DEL_CARRO = "Se debe ingresar la placa del carro";

    private static final String AUTOMOVIL = "Automovil";
    private static final String CAMIONETA = "Camioneta";





    private Long id_usuario;
    private String nombre;
    private String correo;
    private String tipo_carro;
    private String placa;

    public Usuario(Long id,String nombre, String correo, String tipo_carro, String placa) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(correo, SE_DEBE_INGRESAR_LA_CLAVE);
        validarObligatorio(tipo_carro, SE_DEBE_INGRESAR_EL_TIPO_DE_CARRO);
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA_DEL_CARRO);
        //validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        //validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id_usuario = id;
        this.nombre = nombre;
        this.correo = correo;
        this.tipo_carro = tipo_carro;
        this.placa = placa;

    }

}
