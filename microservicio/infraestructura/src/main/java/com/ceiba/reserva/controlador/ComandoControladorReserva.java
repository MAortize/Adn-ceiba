package com.ceiba.reserva.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@Api(tags = {"Controlador comando reserva"})
public class ComandoControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;


    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;

    }

    @PostMapping
    @ApiOperation("crear reserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva){
        return  manejadorCrearReserva.ejecutar(comandoReserva);
    }




}
