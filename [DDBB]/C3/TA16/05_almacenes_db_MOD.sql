INSERT INTO almacenes (cod_almacen, lugar, capacidad) VALUES
(1, 'Barcelona', 500),
(2, 'Bilbao', 400),
(3, 'Madrid', 600),
(4, 'Valencia', 450),
(5, 'Sevilla', 550),
(6, 'Zaragoza', 480),
(7, 'Málaga', 520),
(8, 'Murcia', 470),
(9, 'Palma de Mallorca', 420),
(10, 'Las Palmas de Gran Canaria', 380);


INSERT INTO cajas (num_referencia, contenido, valor, cod_almacen) VALUES
('A0001', 'Libros', 50, 1),
('B0002', 'Electrónica', 120, 2),
('C0003', 'Ropa', 80, 3),
('D0004', 'Herramientas', 150, 4),
('E0005', 'Juguetes', 70, 5),
('F0006', 'Alimentos', 90, 6),
('G0007', 'Artículos de hogar', 110, 7),
('H0008', 'Cosméticos', 100, 8),
('I0009', 'Equipamiento deportivo', 130, 9),
('J0010', 'Muebles', 160, 10);


-- 1) Obtener todos los almacenes
SELECT * FROM almacenes;

-- 2) Obtener todas las cajas cuyo contenido tenga un valor superior a 150
SELECT * FROM cajas WHERE valor > 150;

-- 3) Obtener los tipos de contenidos de las cajas
SELECT DISTINCT contenido FROM cajas;

-- 4) Obtener el valor medio de todas las cajas
SELECT ROUND(AVG(valor),2) AS "Valor promedio" FROM cajas;

-- 5) Obtener el valor medio de las cajas de cada almacén
SELECT cod_almacen, ROUND(AVG(valor),2) AS "Valor medio cajas"
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
