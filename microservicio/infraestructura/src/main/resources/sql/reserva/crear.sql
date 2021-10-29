insert into reservas (codigo,pelicula,fecha_creacion,hora_creacion,fecha_reserva,
					 hora_reserva, no_puesto, tarifa, id_usuario_fk) values (:codigo, :pelicula, :fechaCreacion, :horaCreacion,
					                                            :fechaReserva, :horaReserva, :noPuesto, :tarifa, :idUsuario)