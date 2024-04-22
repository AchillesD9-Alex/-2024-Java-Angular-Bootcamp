INSERT INTO almacenes (cod_almacen, lugar, capacidad) VALUES
(1, 'Almacén Central', 1500),
(2, 'Almacén Norte', 1200),
(3, 'Almacén Sur', 1000),
(4, 'Almacén Este', 800),
(5, 'Almacén Oeste', 2000),
(6, 'Almacén Principal', 1800),
(7, 'Almacén Secundario', 1300),
(8, 'Almacén de Reserva', 900),
(9, 'Almacén de Emergencia', 1100),
(10, 'Almacén de Excedentes', 1600);

INSERT INTO cajas (num_referencia, contenido, valor, cod_almacen) VALUES
('CA001', 'Documentos', 100, 1),
('CA002', 'Productos electrónicos', 800, 2),
('CA003', 'Material de oficina', 50, 3),
('CA004', 'Ropa', 200, 4),
('CA005', 'Herramientas', 300, 5),
('CA006', 'Juguetes', 150, 6),
('CA007', 'Libros', 80, 7),
('CA008', 'Productos de limpieza', 70, 8),
('CA009', 'Alimentos no perecederos', 120, 9),
('CA010', 'Artículos deportivos', 250, 10);

-- 1) Obtener todos los almacenes
SELECT * FROM almacenes;

-- 2) Obtener todas las cajas cuyo contenido tenga un valor superior a 150
SELECT * FROM cajas WHERE valor > 150;

-- 3) Obtener los tipos de contenidos de las cajas
SELECT DISTINCT contenido FROM cajas;

-- 4) Obtener el valor medio de todas las cajas
SELECT AVG(valor) AS valor_medio FROM cajas;

-- 5) Obtener el valor medio de las cajas de cada almacén
SELECT cod_almacen, AVG(valor) AS valor_medio
FROM cajas
GROUP BY cod_almacen;

-- 6) Obtener los códigos de los almacenes en los cuales el valor medio de las cajas sea superior a 150
SELECT cod_almacen
FROM cajas
GROUP BY cod_almacen
HAVING AVG(valor) > 150;

-- 7) Obtener el numero de referencia de cada caja junto con el nombre de la ciudad (lugar) en la que se encuentra
SELECT c.num_referencia, a.lugar
FROM cajas AS c
INNER JOIN almacenes AS a ON c.cod_almacen = a.cod_almacen;

-- 8) Obtener el numero de cajas que hay en cada almacén
SELECT cod_almacen, COUNT(*) AS num_cajas
FROM cajas
GROUP BY cod_almacen;

-- 9) Obtener los códigos de los almacenes que están saturados (numero de cajas > capacidad)
SELECT cod_almacen
FROM almacenes
WHERE (SELECT COUNT(*) FROM cajas WHERE cajas.cod_almacen = almacenes.cod_almacen) > capacidad;

-- 10) Obtener los numeros de referencia de las cajas que están en Bilbao
SELECT num_referencia
FROM cajas
INNER JOIN almacenes ON cajas.cod_almacen = almacenes.cod_almacen
WHERE lugar = 'Bilbao';

-- 11) Insertar un nuevo almacén (lugar = Barcelona) con capacidad para 3 cajas
INSERT INTO almacenes (lugar, capacidad) VALUES ('Barcelona', 3);

-- 12) Insertar una nueva caja, con numero de referencia H5RT con contenido Papel, valor 200 y situada en el almacén 2
INSERT INTO cajas (num_referencia, contenido, valor, cod_almacen) VALUES ('H5RT', 'Papel', 200, 2);

-- 13) Rebajar el valor de todas las cajas un 15%
UPDATE cajas SET valor = valor * 0.85;

-- 14) Rebajar un 20% el valor de todas las cajas cuyo valor sea superior al valor medio de todas las cajas
UPDATE cajas SET valor = valor * 0.8 WHERE valor > (SELECT AVG(valor) FROM cajas);

-- 15) Eliminar todas las cajas cuyo valor sea inferior a 100
DELETE FROM cajas WHERE valor < 100;

-- 16) Vaciar el contenido de los almacenes que están saturados
UPDATE cajas SET contenido = NULL WHERE cod_almacen IN (SELECT cod_almacen FROM almacenes WHERE (SELECT COUNT(*) FROM cajas WHERE cajas.cod_almacen = almacenes.cod_almacen) > capacidad);
