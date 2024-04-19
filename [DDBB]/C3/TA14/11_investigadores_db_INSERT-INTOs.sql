INSERT INTO facultad (cod_facultad, nombre) VALUES
(1, 'Facultad de Ciencias'),
(2, 'Facultad de Ingeniería'),
(3, 'Facultad de Medicina'),
(4, 'Facultad de Humanidades'),
(5, 'Facultad de Derecho'),
(6, 'Facultad de Economía'),
(7, 'Facultad de Artes'),
(8, 'Facultad de Psicología'),
(9, 'Facultad de Educación'),
(10, 'Facultad de Comunicación');

INSERT INTO investigadores (DNI, nom_apels, cod_facultad) VALUES
('12345678', 'Juan Pérez', 1),
('23456789', 'María Gómez', 2),
('34567890', 'Carlos Rodríguez', 3),
('45678901', 'Ana Martínez', 1),
('56789012', 'Pedro López', 2),
('67890123', 'Laura Sánchez', 3),
('78901234', 'David García', 1),
('89012345', 'Sofía Ruiz', 2),
('90123456', 'Javier Hernández', 3),
('01234567', 'Elena Fernández', 1);


INSERT INTO equipos (num_serie, nombre, cod_facultad) VALUES
('E101', 'Equipo de Biología', 1),
('E102', 'Equipo de Ingeniería Civil', 2),
('E103', 'Equipo de Cirugía', 3),
('E104', 'Equipo de Historia', 4),
('E105', 'Equipo de Derecho Penal', 5),
('E106', 'Equipo de Economía Internacional', 6),
('E107', 'Equipo de Arte Contemporáneo', 7),
('E108', 'Equipo de Psicología Experimental', 8),
('E109', 'Equipo de Educación Inclusiva', 9),
('E110', 'Equipo de Comunicación Digital', 10);


INSERT INTO reserva (comienzo, fin, DNI, num_serie) VALUES
('2024-04-20', '2024-04-25', '12345678', 'E101'), -- Juan Pérez reserva equipo E101
('2024-04-21', '2024-04-26', '23456789', 'E102'), -- María Gómez reserva equipo E102
('2024-04-22', '2024-04-27', '34567890', 'E103'), -- Carlos Rodríguez reserva equipo E103
('2024-04-23', '2024-04-28', '45678901', 'E104'), -- Ana Martínez reserva equipo E104
('2024-04-24', '2024-04-29', '56789012', 'E105'), -- Pedro López reserva equipo E105
('2024-04-25', '2024-04-30', '67890123', 'E106'), -- Laura Sánchez reserva equipo E106
('2024-04-26', '2024-05-01', '78901234', 'E107'), -- David García reserva equipo E107
('2024-04-27', '2024-05-02', '89012345', 'E108'), -- Sofía Ruiz reserva equipo E108
('2024-04-28', '2024-05-03', '90123456', 'E109'), -- Javier Hernández reserva equipo E109
('2024-04-29', '2024-05-04', '01234567', 'E110'); -- Elena Fernández reserva equipo E110
