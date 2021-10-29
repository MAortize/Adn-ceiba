update reservas
set pelicula = :pelicula,
    fechaReserva = :fechaReserva,
    horaReserva = :horaReserva
where id = :idReserva
