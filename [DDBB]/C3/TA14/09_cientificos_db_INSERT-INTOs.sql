INSERT INTO cientificos (DNI, nom_apels) VALUES
('12345678', 'Juan Pérez'),
('23456789', 'María Gómez'),
('34567890', 'Carlos Rodríguez'),
('45678901', 'Ana Martínez'),
('56789012', 'Pedro López'),
('67890123', 'Laura Sánchez'),
('78901234', 'David García'),
('89012345', 'Sofía Ruiz'),
('90123456', 'Javier Hernández'),
('01234567', 'Elena Fernández');


INSERT INTO proyecto (id_proyecto, nombre, horas) VALUES
('PR01', 'Proyecto de Investigación en Biología', 100),
('PR02', 'Desarrollo de Software Educativo', 200),
('PR03', 'Investigación en Inteligencia Artificial', 150),
('PR04', 'Proyecto de Energías Renovables', 180),
('PR05', 'Estudio de Cambio Climático', 220),
('PR06', 'Desarrollo de Vacunas', 120),
('PR07', 'Investigación en Neurociencia', 170),
('PR08', 'Proyecto de Agricultura Sostenible', 190),
('PR09', 'Desarrollo de Aplicaciones Móviles', 160),
('PR10', 'Investigación en Física de Partículas', 210);


INSERT INTO asignado_a (id_proyecto, DNI) VALUES
('PR01', '12345678'), -- Juan Pérez asignado al proyecto PR01
('PR02', '23456789'), -- María Gómez asignada al proyecto PR02
('PR03', '34567890'), -- Carlos Rodríguez asignado al proyecto PR03
('PR04', '45678901'), -- Ana Martínez asignada al proyecto PR04
('PR05', '56789012'), -- Pedro López asignado al proyecto PR05
('PR06', '67890123'), -- Laura Sánchez asignada al proyecto PR06
('PR07', '78901234'), -- David García asignado al proyecto PR07
('PR08', '89012345'), -- Sofía Ruiz asignada al proyecto PR08
('PR09', '90123456'), -- Javier Hernández asignado al proyecto PR09
('PR10', '01234567'); -- Elena Fernández asignada al proyecto PR10

