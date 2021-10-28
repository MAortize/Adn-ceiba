create table usuarios (
 id serial not null,
 nombre varchar(100) not null,
 correo varchar(100) not null,
 tipo_carro varchar(100) not null,
 placa varchar(100) not null,
 primary key (id)
);

create table reservas (
 id serial not null,
 codigo varchar(15) not null,
 pelicula varchar(15) not null,
 fecha_creacion date not null,
 hora_creacion time not null,
 fecha_reserva date not null,
 hora_reserva time not null,
 no_puesto numeric not null,
 id_usuario_fk integer,
 primary key (id),
 constraint fk_usuario
 foreign key (id_usuario_fk)
 references usuarios(id)
)



