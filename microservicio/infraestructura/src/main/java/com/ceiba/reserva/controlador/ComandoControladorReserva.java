package com.ceiba.reserva.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorActualizarReserva;
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
    private final ManejadorEliminarReserva manejadorEliminarReserva;
    private final ManejadorActualizarReserva manejadorActualizarReserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorEliminarReserva manejadorEliminarReserva, ManejadorActualizarReserva manejadorActualizarReserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorEliminarReserva = manejadorEliminarReserva;
        this.manejadorActualizarReserva = manejadorActualizarReserva;
    }

    @PostMapping
    @ApiOperation("crear reserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva){
        return  manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @PutMapping(value = "/{idReserva}")
    @ApiOperation("Actualizar usuario")
    public void actualizar(@RequestBody ComandoReserva comandoReserva,@PathVariable(name = "idReserva") Long id){
        comandoReserva.setIdReserva(id);
        manejadorActualizarReserva.ejecutar(comandoReserva);
    }


    @DeleteMapping(value="/{idReserva}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable(name = "idReserva") Long id) {
        manejadorEliminarReserva.ejecutar(id);
    }




}
