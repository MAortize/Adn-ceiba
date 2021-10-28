update usuarios
set nombre = :nombre,
	correo = :correo,
	tipo_carro = :tipoCarro,
	placa = :placa
where id = :idUsuario