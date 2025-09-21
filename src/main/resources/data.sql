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

INSERT IGNORE detalles_caso(id_parte, id_caso, rol_en_caso) VALUES
(1, 1, 'Cliente'),
(2, 2, 'Contraparte'),
(3, 3, 'Otro'),
(4, 4, 'Contraparte'),
(4, 5, 'Contraparte');

INSERT IGNORE historiales(descripcion, id_abogado, id_caso) VALUES
('Se presenta la demanda en el tribunal', 1, 5),
('Primera audiencia programada para el 15/09/2025', 1, 4),
('Se adjuntan nuevas pruebas al expediente del caso', 1, 3),
('El juez emite una orden de restricción temporal', 2, 2),
('Revisión de testimonios de los testigos clave', 3, 1);

INSERT IGNORE eventos(tipo, id_caso, id_abogado, id_historial) VALUES
('AUDIENCIA', 1, 1, 1),
('DEBATE_ORAL', 2, 2, 2),
('RECONOCIMIENTO_JUDICIAL', 3, 3, 3),
('DESALOJO', 1, 2, 3),
('OTRO', 3, 2, 1);

INSERT IGNORE insumos(descripcion, cantidad, costo_unitario, costo) VALUES
('Se adquirieron rollos de papel para los baños', 6, 5.50, 6*5.50),
('Se adquirieron baterías para los controles de TV de la Sala de Espera', 12, 7.35, 12*7.35),
('Se adquirió un Nuevo Escritorio para el Practicante Roberto Milián', 1, 750.99, 750.99),
('Se adquirió una cubeta de pintura para la Sala de Juntas', 1, 899.99, 899.99);

INSERT IGNORE gestiones (tipo, descripcion, fecha_creacion, fecha_vencimiento, estado, observaciones, id_caso, id_abogado, id_historial) VALUES
('DEMANDA', 'Presentación de demanda civil por incumplimiento de contrato', '2025-09-01', '2025-10-01', 'PENDIENTE', 'Se entregaron documentos al juzgado', 1, 3, 5),
('ORIENTACIÓN', 'Audiencia preliminar en juzgado de lo penal', '2025-08-15', '2025-09-20', 'PENDIENTE', 'Se solicitó reprogramación por ausencia del juez', 2, 1, 2),
('MEMORIAL', 'Sesión de mediación entre las partes', '2025-09-10', '2025-09-25', 'PENDIENTE', 'El cliente aún no confirma asistencia', 3, 4, 3),
('ASESORIA', 'Interposición de recurso de apelación', '2025-07-30', '2025-09-30', 'COMPLETADA', 'Resolución favorable al cliente', 4, 2, 1),
('QUERELLA', 'Revisión de expediente y asesoría legal', '2025-09-18', '2025-09-18', 'COMPLETADA', 'Se entregó informe escrito al cliente', 5, 5, 4);

INSERT IGNORE INTO documentos (nombre, tipo_documento, id_caso) VALUES
('Contrato de Arrendamiento', 'JUDICIAL', 1),
('Escritura Pública', 'CONTRACTUAL', 2),
('Testamento', 'ADMINISTRATIVO', 3),
('Acta Notarial', 'CONTRACTUAL', 4),
('Cédula de Notificación', 'JUDICIAL', 5);
