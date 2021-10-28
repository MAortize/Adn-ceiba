package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long idUsuario;
    private String nombre;
    private String correo;
    private String tipoCarro;
    private String placa;


}
