insert into usuarios(id, nombre, correo) values(1,'test','1234');
insert into usuarios(id, nombre, correo) values(2,'test1','12345');

insert into reservas (id,codigo,pelicula,fecha_creacion,hora_creacion,fecha_reserva,
					 hora_reserva, no_puesto, tarifa, id_usuario_fk)
					 values (1,'1234',  'lilo', now(), current_time, now(), current_time, 2, 40.000, 1);