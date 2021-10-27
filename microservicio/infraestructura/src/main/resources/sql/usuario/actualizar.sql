update usuarios
set nombre = :nombre,
	correo = :correo,
	tipo_carro = :tipo_carro,
	placa = :placa
where id_usuario = :id_usuario