// Conectarse a la base de datos peliculas_salas
use peliculas_salas

// Crear la colección peliculas
db.createCollection("peliculas")

// Crear la colección salas
db.createCollection("salas")

// Insertar datos en la colección peliculas
db.peliculas.insertMany([
    { "cod_pelicula": 1, "nombre": "Spider-Man: No Way Home", "cal_edad": 7 },
    { "cod_pelicula": 2, "nombre": "Dune", "cal_edad": 12 },
    { "cod_pelicula": 3, "nombre": "Eternals", "cal_edad": 7 },
    { "cod_pelicula": 4, "nombre": "Sing 2", "cal_edad": 0 },
    { "cod_pelicula": 5, "nombre": "La familia Addams 2: La gran excursión", "cal_edad": 0 },
    { "cod_pelicula": 6, "nombre": "Ghostbusters: Afterlife", "cal_edad": 7 },
    { "cod_pelicula": 7, "nombre": "Scream", "cal_edad": 16 },
    { "cod_pelicula": 8, "nombre": "Matrix Resurrections", "cal_edad": 12 },
    { "cod_pelicula": 9, "nombre": "El médico africano", "cal_edad": 12 },
    { "cod_pelicula": 10, "nombre": "Licorice Pizza", "cal_edad": 12 }
]);

// Insertar datos en la colección salas
db.salas.insertMany([
    { "cod_sala": "S01", "nombre": "Sala de Estreno", "cod_pelicula": 1 },
    { "cod_sala": "S02", "nombre": "Sala de Aventuras", "cod_pelicula": 2 },
    { "cod_sala": "S03", "nombre": "Sala de Ciencia Ficción", "cod_pelicula": 3 },
    { "cod_sala": "S04", "nombre": "Sala de Animación", "cod_pelicula": 4 },
    { "cod_sala": "S05", "nombre": "Sala de Comedia", "cod_pelicula": 5 },
    { "cod_sala": "S06", "nombre": "Sala de Terror", "cod_pelicula": 6 },
    { "cod_sala": "S07", "nombre": "Sala de Suspenso", "cod_pelicula": 7 },
    { "cod_sala": "S08", "nombre": "Sala de Acción", "cod_pelicula": 8 },
    { "cod_sala": "S09", "nombre": "Sala de Drama", "cod_pelicula": 9 },
    { "cod_sala": "S10", "nombre": "Sala de Romance", "cod_pelicula": 10 }
]);
