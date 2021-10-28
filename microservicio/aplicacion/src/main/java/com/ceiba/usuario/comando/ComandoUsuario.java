package com.ceiba.usuario.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario{

    private Long idUsuario;
    private String nombre;
    private String correo;
    private String tipoCarro;
    private String placa;

}
