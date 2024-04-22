-- Agregar datos a la tabla fabricantes
INSERT INTO fabricantes (cod_fabricantes, nombre) VALUES
(1, 'Lenovo'),
(2, 'Samsung'),
(3, 'Logitech'),
(4, 'Microsoft'),
(5, 'HP'),
(6, 'Western Digital'),
(7, 'SanDisk'),
(8, 'Creative'),
(9, 'Logitech'),
(10, 'TP-Link');

-- Agregar datos a la tabla articulos
INSERT INTO articulos (cod_articulos, nombre, precio, cod_fabricantes) VALUES
(101, 'Portátil Lenovo', 1200, 1),
(102, 'Monitor Samsung', 300, 2),
(103, 'Teclado Logitech', 50, 3),
(104, 'Ratón Microsoft', 30, 4),
(105, 'Impresora HP', 200, 5),
(106, 'Disco Duro Externo Western Digital', 100, 6),
(107, 'Memoria USB SanDisk', 20, 7),
(108, 'Altavoces Creative', 80, 8),
(109, 'Webcam Logitech', 40, 9),
(110, 'Router WiFi TP-Link', 60, 10);

-- Consultas hypermegalargas de la muerte

-- 1) Obtener los nombres de los productos de la tienda
SELECT nombre FROM articulos;

-- 2) Obtener nombres y precios de los productos de la tienda
SELECT nombre, precio FROM articulos;

-- 3) Obtener el nombre de los productos cuyo precio sea menor o igual a 200
SELECT nombre FROM articulos WHERE precio <= 200;

-- 4) Obtener todos los datos de los artículos cuyo precio esté entre 60 y 120, ambas cantidades incluidas
SELECT * FROM articulos WHERE precio BETWEEN 60 AND 120;

-- 5) Obtener el nombre y el precio en pesetas (el precio de la base de datos se considerará euros; deberá ser multiplicado por 166,386 para hacer la conversión)
SELECT nombre, precio * 166.386 AS precio_pesetas FROM articulos;

-- 6) Seleccionar el precio medio de todos los productos
SELECT AVG(precio) AS precio_medio FROM articulos;

-- 7) Obtener el precio medio de los artículos cuyo código de fabricante sea 2
SELECT AVG(precio) AS precio_medio FROM articulos WHERE cod_fabricantes = 2;

-- 8) Obtener el número de artículos cuyo precio sea mayor o igual a 180
SELECT COUNT(*) AS num_articulos FROM articulos WHERE precio >= 180;

-- 9) Obtener el nombre y precio de los artículos cuyo precio sea mayor o igual a 180 y ordenarlos descendentemente por precio y luego ascendentemente por nombre
SELECT nombre, precio FROM articulos WHERE precio >= 180 ORDER BY precio DESC, nombre ASC;

-- 10) Obtener un listado completo de artículos, incluyendo por cada artículo los datos del artículo y su fabricante
SELECT a.*, f.nombre AS nombre_fabricante
FROM articulos AS a
INNER JOIN fabricantes AS f ON a.cod_fabricantes = f.cod_fabricantes;

-- 11) Obtener un listado de artículos, incluyendo el nombre del artículo, su precio y el nombre de su fabricante
SELECT a.nombre AS nombre_articulo, a.precio, f.nombre AS nombre_fabricante
FROM articulos AS a
INNER JOIN fabricantes AS f ON a.cod_fabricantes = f.cod_fabricantes;

-- 12) Obtener el precio medio de los productos de cada fabricante, mostrando solo los códigos del fabricante
SELECT cod_fabricantes, AVG(precio) AS precio_medio
FROM articulos
GROUP BY cod_fabricantes;

-- 13) Obtener el precio medio de los productos de cada fabricante, mostrando el nombre del fabricante
SELECT f.nombre AS nombre_fabricante, AVG(a.precio) AS precio_medio
FROM articulos AS a
INNER JOIN fabricantes AS f ON a.cod_fabricantes = f.cod_fabricantes
GROUP BY f.nombre;

-- 14) Obtener los nombres de los fabricantes que ofrezcan productos cuyo precio medio sea mayor o igual a 150
SELECT f.nombre
FROM articulos AS a
INNER JOIN fabricantes AS f ON a.cod_fabricantes = f.cod_fabricantes
GROUP BY f.nombre
HAVING AVG(a.precio) >= 150;

-- 15) Obtener el nombre y precio del artículo más barato
SELECT nombre, precio
FROM articulos
WHERE precio = (SELECT MIN(precio) FROM articulos);

-- 16) Obtener una lista con el nombre y precio de los artículos más caros de cada fabricante (incluyendo nombre de fabricante)
SELECT f.nombre AS nombre_fabricante, a.nombre AS nombre_articulo, a.precio
FROM articulos AS a
INNER JOIN fabricantes AS f ON a.cod_fabricantes = f.cod_fabricantes
WHERE (a.cod_articulos, a.precio) IN (
    SELECT cod_articulos, MAX(precio)
    FROM articulos
    WHERE cod_fabricantes = a.cod_fabricantes
    GROUP BY cod_fabricantes
);

-- 17) Añadir un nuevo producto: altavoces, precio = 70, fabricante 2
INSERT INTO articulos (cod_articulos, nombre, precio, cod_fabricantes)
VALUES (111, 'Altavoces', 70, 2);

-- 18) Cambiar el nombre del producto 8 a "Impresora Láser"
UPDATE articulos SET nombre = 'Impresora Láser' WHERE cod_articulos = 108;

-- 19) Aplicar un 10% de descuento (multiplicar el precio por 0.9) a todos los productos
UPDATE articulos SET precio = precio * 0.9;

-- 20) Aplicar un descuento de 10€ a todos los productos cuyo precio sea mayor o igual a 120€
UPDATE articulos SET precio = precio - 10 WHERE precio >= 120;


