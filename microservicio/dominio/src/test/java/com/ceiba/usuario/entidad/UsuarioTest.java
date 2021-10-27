package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

    import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {


    private static final String SE_DEBE_INGRESAR_EL_CORREO = "Se debe ingresar ";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_CARRO = "Se debe ingresar el tipo de carro";
    private static final String SE_DEBE_INGRESAR_LA_PLACA_DEL_CARRO = "Se debe ingresar la placa del carro";

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElUsusuario() {

        //arrange-act
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, usuario.getId_usuario());
        assertEquals("1234", usuario.getNombre());
        assertEquals("1234", usuario.getCorreo());
        assertEquals("Automovil", usuario.getTipo_carro());
        assertEquals("ABCD", usuario.getPlaca());
    }

    @Test
    void deberiaFallarSinNombreDeUsuario() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
    }

    @Test
    void deberiaFallarSinCorreo() {

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conCorreo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_CORREO);
    }


    @Test
    void deberiaFallarSinPlaca(){

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conPlaca(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_PLACA_DEL_CARRO);

    }


    @Test
    void deberiaFallarSinTipoCarro(){

        //Arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conTipoCarro(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TIPO_DE_CARRO);

    }







}
