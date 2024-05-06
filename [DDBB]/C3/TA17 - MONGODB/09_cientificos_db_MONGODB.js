// Conectarse a la base de datos cientificos_db
use cientificos_db

// Crear la colección cientificos
db.createCollection("cientificos")

// Crear la colección proyecto
db.createCollection("proyecto")

// Crear la colección asignado_a
db.createCollection("asignado_a")

// Insertar datos en la colección cientificos
db.cientificos.insertMany([
    { "DNI": "12345678", "nom_apels": "Juan Pérez" },
    { "DNI": "23456789", "nom_apels": "María Gómez" },
    { "DNI": "34567890", "nom_apels": "Carlos Rodríguez" },
    { "DNI": "45678901", "nom_apels": "Ana Martínez" },
    { "DNI": "56789012", "nom_apels": "Pedro López" },
    { "DNI": "67890123", "nom_apels": "Laura Sánchez" },
    { "DNI": "78901234", "nom_apels": "David García" },
    { "DNI": "89012345", "nom_apels": "Sofía Ruiz" },
    { "DNI": "90123456", "nom_apels": "Javier Hernández" },
    { "DNI": "01234567", "nom_apels": "Elena Fernández" }
]);

// Insertar datos en la colección proyecto
db.proyecto.insertMany([
    { "id_proyecto": "PR01", "nombre": "Proyecto de Investigación en Biología", "horas": 100 },
    { "id_proyecto": "PR02", "nombre": "Desarrollo de Software Educativo", "horas": 200 },
    { "id_proyecto": "PR03", "nombre": "Investigación en Inteligencia Artificial", "horas": 150 },
    { "id_proyecto": "PR04", "nombre": "Proyecto de Energías Renovables", "horas": 180 },
    { "id_proyecto": "PR05", "nombre": "Estudio de Cambio Climático", "horas": 220 },
    { "id_proyecto": "PR06", "nombre": "Desarrollo de Vacunas", "horas": 120 },
    { "id_proyecto": "PR07", "nombre": "Investigación en Neurociencia", "horas": 170 },
    { "id_proyecto": "PR08", "nombre": "Proyecto de Agricultura Sostenible", "horas": 190 },
    { "id_proyecto": "PR09", "nombre": "Desarrollo de Aplicaciones Móviles", "horas": 160 },
    { "id_proyecto": "PR10", "nombre": "Investigación en Física de Partículas", "horas": 210 }
]);

// Insertar datos en la colección asignado_a
db.asignado_a.insertMany([
    { "id_proyecto": "PR01", "DNI": "12345678" },
    { "id_proyecto": "PR02", "DNI": "23456789" },
    { "id_proyecto": "PR03", "DNI": "34567890" },
    { "id_proyecto": "PR04", "DNI": "45678901" },
    { "id_proyecto": "PR05", "DNI": "56789012" },
    { "id_proyecto": "PR06", "DNI": "67890123" },
    { "id_proyecto": "PR07", "DNI": "78901234" },
    { "id_proyecto": "PR08", "DNI": "89012345" },
    { "id_proyecto": "PR09", "DNI": "90123456" },
    { "id_proyecto": "PR10", "DNI": "01234567" }
]);


