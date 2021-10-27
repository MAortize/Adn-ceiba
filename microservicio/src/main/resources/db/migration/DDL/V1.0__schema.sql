create table usuarios (
 id_usuario int(11) not null auto_increment,
 nombre varchar(100) not null,
 correo varchar(100) not null,
 tipo_carro varchar(100) not null,
 placa varchar(100) not null,
 primary key (id_usuario)
);

create table reservas (
 id_reserva int(11) not null auto_increment,
 codigo varchar(15) not null,
 pelicula varchar(15) not null,
 fecha_creacion date not null,
 hora_creacion time not null,
 fecha_reserva date not null,
 hora_reserva time not null,
 no_puesto integer not null,
 id_usuario_fk integer not null
);

alter table reservas
add constraint fk_usuarios_id
foreign key (id_usuario_fk)
references usuarios(id_usuario);