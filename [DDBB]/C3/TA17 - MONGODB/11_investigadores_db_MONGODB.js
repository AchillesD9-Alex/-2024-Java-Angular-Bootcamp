// Conectarse a la base de datos investigadores_db
use investigadores_db

// Crear la colección facultad
db.createCollection("facultad")

// Crear la colección investigadores
db.createCollection("investigadores")

// Crear la colección equipos
db.createCollection("equipos")

// Crear la colección reserva
db.createCollection("reserva")

// Insertar datos en la colección facultad
db.facultad.insertMany([
    { "cod_facultad": 1, "nombre": "Facultad de Ciencias" },
    { "cod_facultad": 2, "nombre": "Facultad de Ingeniería" },
    { "cod_facultad": 3, "nombre": "Facultad de Medicina" },
    { "cod_facultad": 4, "nombre": "Facultad de Humanidades" },
    { "cod_facultad": 5, "nombre": "Facultad de Derecho" },
    { "cod_facultad": 6, "nombre": "Facultad de Economía" },
    { "cod_facultad": 7, "nombre": "Facultad de Artes" },
    { "cod_facultad": 8, "nombre": "Facultad de Psicología" },
    { "cod_facultad": 9, "nombre": "Facultad de Educación" },
    { "cod_facultad": 10, "nombre": "Facultad de Comunicación" }
]);

// Insertar datos en la colección investigadores
db.investigadores.insertMany([
    { "DNI": "12345678", "nom_apels": "Juan Pérez", "cod_facultad": 1 },
    { "DNI": "23456789", "nom_apels": "María Gómez", "cod_facultad": 2 },
    { "DNI": "34567890", "nom_apels": "Carlos Rodríguez", "cod_facultad": 3 },
    { "DNI": "45678901", "nom_apels": "Ana Martínez", "cod_facultad": 1 },
    { "DNI": "56789012", "nom_apels": "Pedro López", "cod_facultad": 2 },
    { "DNI": "67890123", "nom_apels": "Laura Sánchez", "cod_facultad": 3 },
    { "DNI": "78901234", "nom_apels": "David García", "cod_facultad": 1 },
    { "DNI": "89012345", "nom_apels": "Sofía Ruiz", "cod_facultad": 2 },
    { "DNI": "90123456", "nom_apels": "Javier Hernández", "cod_facultad": 3 },
    { "DNI": "01234567", "nom_apels": "Elena Fernández", "cod_facultad": 1 }
]);

// Insertar datos en la colección equipos
db.equipos.insertMany([
    { "num_serie": "E101", "nombre": "Equipo de Biología", "cod_facultad": 1 },
    { "num_serie": "E102", "nombre": "Equipo de Ingeniería Civil", "cod_facultad": 2 },
    { "num_serie": "E103", "nombre": "Equipo de Cirugía", "cod_facultad": 3 },
    { "num_serie": "E104", "nombre": "Equipo de Historia", "cod_facultad": 4 },
    { "num_serie": "E105", "nombre": "Equipo de Derecho Penal", "cod_facultad": 5 },
    { "num_serie": "E106", "nombre": "Equipo de Economía Internacional", "cod_facultad": 6 },
    { "num_serie": "E107", "nombre": "Equipo de Arte Contemporáneo", "cod_facultad": 7 },
    { "num_serie": "E108", "nombre": "Equipo de Psicología Experimental", "cod_facultad": 8 },
    { "num_serie": "E109", "nombre": "Equipo de Educación Inclusiva", "cod_facultad": 9 },
    { "num_serie": "E110", "nombre": "Equipo de Comunicación Digital", "cod_facultad": 10 }
]);

// Insertar datos en la colección reserva
db.reserva.insertMany([
    { "comienzo": "2024-04-20", "fin": "2024-04-25", "DNI": "12345678", "num_serie": "E101" },
    { "comienzo": "2024-04-21", "fin": "2024-04-26", "DNI": "23456789", "num_serie": "E102" },
    { "comienzo": "2024-04-22", "fin": "2024-04-27", "DNI": "34567890", "num_serie": "E103" },
    { "comienzo": "2024-04-23", "fin": "2024-04-28", "DNI": "45678901", "num_serie": "E104" },
    { "comienzo": "2024-04-24", "fin": "2024-04-29", "DNI": "56789012", "num_serie": "E105" },
    { "comienzo": "2024-04-25", "fin": "2024-04-30", "DNI": "67890123", "num_serie": "E106" },
    { "comienzo": "2024-04-26", "fin": "2024-05-01", "DNI": "78901234", "num_serie": "E107" },
    { "comienzo": "2024-04-27", "fin": "2024-05-02", "DNI": "89012345", "num_serie": "E108" },
    { "comienzo": "2024-04-28", "fin": "2024-05-03", "DNI": "90123456", "num_serie": "E109" },
    { "comienzo": "2024-04-29", "fin": "2024-05-04", "DNI": "01234567", "num_serie": "E110" }
]);
