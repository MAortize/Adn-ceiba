update usuarios
set nombre = :nombre,
	correo = :correo,
	tipo_carro = :tipo_carro,
	placa = :placa
where id = :id_usuario