INSERT IGNORE INTO partes (nombre, apellido, dpi, estado_civil, fecha_nacimiento, oficio, sexo, lugar_nacimiento, etnia, domicilio, telefono, nit, rol) VALUES
('Carlos', 'Ramírez', '1234567890123', 'Casado/a', '1985-06-15', 'Abogado', 'Masculino', 'Ciudad de Guatemala', 'Ladino', 'Zona 1, Ciudad', '5555-1234', '1234567-8', 'Cliente'),
('Ana', 'González', '9876543210123', 'Soltero/a', '1992-11-30', 'Secretaria', 'Femenino', 'Antigua Guatemala', 'Maya', 'Zona 2, Ciudad', '5555-5678', '9876543-2', 'Contraparte'),
('Luis', 'Martínez', '52951952514', 'Divorciado/a', '1979-03-22', 'Ingeniero', 'Masculino', 'Quetzaltenango', 'Xinca', 'Zona 10, Ciudad', '5555-9999', '1213185-9', 'Cliente'),
('María', 'López', '1122334455667', 'Union de Hecho', '1995-08-05', 'Estudiante', 'Femenino', 'Chimaltenango', 'Garífuna', 'Zona 18, Ciudad', '5555-8888', '1122334-5', 'Contraparte');

INSERT IGNORE INTO abogados (nombre, apellido, dpi, no_colegiado_activo, correo, telefono, especialidad) VALUES
('Laura', 'Hernández', '1234567890101', 'A12345', 'laura.hernandez@bufete.com', '5555-1234', 'MERCANTIL'),
('Juan', 'Pérez', '2345678901212', 'B23456', 'juan.perez@bufete.com', '5555-5678', 'ADMINISTRATIVO'),
('Carla', 'Ramírez', '3456789012323', 'C34567', 'carla.ramirez@bufete.com', '5555-8765', 'INTERNACIONAL'),
('Miguel', 'Sánchez', '4567890123434', 'D45678', 'miguel.sanchez@bufete.com', '5555-4321', 'PROPIEDAD_INTELECTUAL'),
('Ana', 'López', '5678901234545', 'E56789', 'ana.lopez@bufete.com', '5555-0000', 'FAMILIA');

INSERT IGNORE Casos (titulo, descripcion, fecha_inicio, fecha_cierre, estado, tipo_caso) VALUES
('Caso de Robo', 'Investigación y resolución de caso por robo en propiedad privada.', '2024-01-15', '2024-06-01', 'SUSPENDIDO', 'ADMINISTRATIVO'),
('Demanda Laboral', 'Caso sobre incumplimiento de contrato laboral.', '2023-11-01', '2024-03-10', 'FINALIZADO', 'INTERNACIONAL'),
('Divorcio Contencioso', 'Proceso legal para la disolución del matrimonio.', '2024-02-20', '2024-08-15', 'EN_PROCESO', 'INMOBILIARIO'),
('Reclamación de Herencia', 'Disputa sobre la distribución de bienes hereditarios.', '2023-12-05', '2024-07-01', 'FINALIZADO', 'PROPIEDAD_INTELECTUAL'),
('Caso de Fraude', 'Investigación de fraude financiero en empresa.', '2024-03-01', '2024-09-10', 'ARCHIVADO', 'FAMILIA');


