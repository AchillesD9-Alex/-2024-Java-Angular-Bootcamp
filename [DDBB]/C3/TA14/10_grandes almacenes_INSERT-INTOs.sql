INSERT INTO cajeros (cod_cajero, nom_apels) VALUES
(1, 'Carlos González'),
(2, 'María López'),
(3, 'Juan Martínez'),
(4, 'Ana Rodríguez'),
(5, 'Pedro Sánchez'),
(6, 'Laura García'),
(7, 'David Pérez'),
(8, 'Sofía Hernández'),
(9, 'Javier Ruiz'),
(10, 'Elena Fernández');


INSERT INTO productos (cod_productos, nombre, precio) VALUES
(101, 'Camiseta', 1500),
(102, 'Pantalón', 2500),
(103, 'Zapatos', 3500),
(104, 'Reloj', 2000),
(105, 'Gafas de sol', 1000),
(106, 'Bolso', 1800),
(107, 'Bufanda', 1200),
(108, 'Sombrero', 900),
(109, 'Pulsera', 800),
(110, 'Anillo', 1500);

INSERT INTO maq_registradoras (cod_maq, piso) VALUES
(201, 1),
(202, 1),
(203, 2),
(204, 2),
(205, 3),
(206, 3),
(207, 4),
(208, 4),
(209, 5),
(210, 5);

INSERT INTO venta (cod_productos, cod_cajero, cod_maq) VALUES
(101, 1, 201), -- Venta del producto 101 por el cajero 1 en la máquina 201
(102, 2, 202), -- Venta del producto 102 por el cajero 2 en la máquina 202
(103, 3, 203), -- Venta del producto 103 por el cajero 3 en la máquina 203
(104, 4, 204), -- Venta del producto 104 por el cajero 4 en la máquina 204
(105, 5, 205), -- Venta del producto 105 por el cajero 5 en la máquina 205
(106, 6, 206), -- Venta del producto 106 por el cajero 6 en la máquina 206
(107, 7, 207), -- Venta del producto 107 por el cajero 7 en la máquina 207
(108, 8, 208), -- Venta del producto 108 por el cajero 8 en la máquina 208
(109, 9, 209), -- Venta del producto 109 por el cajero 9 en la máquina 209
(110, 10, 210); -- Venta del producto 110 por el cajero 10 en la máquina 210


