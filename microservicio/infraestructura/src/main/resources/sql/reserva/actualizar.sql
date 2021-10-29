update reservas
set pelicula = :pelicula,
    fecha_reserva = :fechaReserva,
    hora_reserva = :horaReserva
where id = :idReserva
