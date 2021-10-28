insert into usuarios(id_usuario, nombre, correo, tipo_carro, placa) values(1,'test','1234','Automovil','ABCD');
insert into usuarios(id_usuario, nombre, correo, tipo_carro, placa) values(2,'test1','12345','Camioneta','ABCD');

insert into reservas (id_reserva,codigo,pelicula,fecha_creacion,hora_creacion,fecha_reserva,
					 hora_reserva, no_puesto, id_usuario_fk)
					 values (3,'1234',  'avengers', now(), current_time, now(), current_time, 2, 1);