INSERT INTO peliculas (cod_pelicula, nombre, cal_edad) VALUES
(1, 'Spider-Man: No Way Home', 7),
(2, 'Dune', 12),
(3, 'Eternals', 7),
(4, 'Sing 2', 0),
(5, 'La familia Addams 2: La gran excursión', 0),
(6, 'Ghostbusters: Afterlife', 7),
(7, 'Scream', 16),
(8, 'Matrix Resurrections', 12),
(9, 'El médico africano', 12),
(10, 'Licorice Pizza', 12);

INSERT INTO salas (cod_sala, nombre, cod_pelicula) VALUES
('S01', 'Sala de Estreno', 1),
('S02', 'Sala de Aventuras', 2),
('S03', 'Sala de Ciencia Ficción', 3),
('S04', 'Sala de Animación', 4),
('S05', 'Sala de Comedia', 5),
('S06', 'Sala de Terror', 6),
('S07', 'Sala de Suspenso', 7),
('S08', 'Sala de Acción', 8),
('S09', 'Sala de Drama', 9),
('S10', 'Sala de Romance', 10);


-- 1) Mostrar el nombre de todas las películas
SELECT nombre FROM peliculas;

-- 2) Mostrar las distintas calificaciones de edad que existen
SELECT DISTINCT cal_edad FROM peliculas;

-- 3) Mostrar todas las películas que no han sido calificadas
SELECT * FROM peliculas WHERE cal_edad IS NULL;

-- 4) Mostrar todas las salas que no proyectan ninguna película
SELECT * FROM salas WHERE cod_pelicula IS NULL;

-- 5) Mostrar la información de todas las salas y, si se proyecta alguna película en la sala, mostrar también la información de la película
SELECT s.*, p.*
FROM salas AS s
LEFT JOIN peliculas AS p ON s.cod_pelicula = p.cod_pelicula;

-- 6) Mostrar la información de todas las películas y, si se proyecta en alguna sala, mostrar también la información de la sala
SELECT p.*, s.*
FROM peliculas AS p
LEFT JOIN salas AS s ON p.cod_pelicula = s.cod_pelicula;

-- 7) Mostrar los nombres de las películas que no se proyectan en ninguna sala
SELECT nombre
FROM peliculas
WHERE cod_pelicula NOT IN (SELECT cod_pelicula FROM salas);

-- 8) Añadir una nueva película "Uno, Dos, Tres", para mayores de 7 años
INSERT INTO peliculas (cod_pelicula, nombre, cal_edad) VALUES (11, 'Uno, Dos, Tres', 7);

-- 9) Hacer constar que todas las películas no calificadas han sido calificadas como "No recomendables para menores de 13 años"
UPDATE peliculas SET cal_edad = 13 WHERE cal_edad IS NULL;

-- 10) Eliminar todas las salas que proyectan películas recomendadas para todos los públicos
DELETE FROM salas WHERE cod_pelicula IN (SELECT cod_pelicula FROM peliculas WHERE cal_edad = 0);
