// Conectarse a la base de datos grandes_almacenes
use grandes_almacenes

// Crear la colección cajeros
db.createCollection("cajeros")

// Crear la colección productos
db.createCollection("productos")

// Crear la colección maq_registradoras
db.createCollection("maq_registradoras")

// Crear la colección venta
db.createCollection("venta")

// Insertar datos en la colección cajeros
db.cajeros.insertMany([
    { "cod_cajero": 1, "nom_apels": "Carlos González" },
    { "cod_cajero": 2, "nom_apels": "María López" },
    { "cod_cajero": 3, "nom_apels": "Juan Martínez" },
    { "cod_cajero": 4, "nom_apels": "Ana Rodríguez" },
    { "cod_cajero": 5, "nom_apels": "Pedro Sánchez" },
    { "cod_cajero": 6, "nom_apels": "Laura García" },
    { "cod_cajero": 7, "nom_apels": "David Pérez" },
    { "cod_cajero": 8, "nom_apels": "Sofía Hernández" },
    { "cod_cajero": 9, "nom_apels": "Javier Ruiz" },
    { "cod_cajero": 10, "nom_apels": "Elena Fernández" }
]);

// Insertar datos en la colección productos
db.productos.insertMany([
    { "cod_productos": 101, "nombre": "Camiseta", "precio": 1500 },
    { "cod_productos": 102, "nombre": "Pantalón", "precio": 2500 },
    { "cod_productos": 103, "nombre": "Zapatos", "precio": 3500 },
    { "cod_productos": 104, "nombre": "Reloj", "precio": 2000 },
    { "cod_productos": 105, "nombre": "Gafas de sol", "precio": 1000 },
    { "cod_productos": 106, "nombre": "Bolso", "precio": 1800 },
    { "cod_productos": 107, "nombre": "Bufanda", "precio": 1200 },
    { "cod_productos": 108, "nombre": "Sombrero", "precio": 900 },
    { "cod_productos": 109, "nombre": "Pulsera", "precio": 800 },
    { "cod_productos": 110, "nombre": "Anillo", "precio": 1500 }
]);

// Insertar datos en la colección maq_registradoras
db.maq_registradoras.insertMany([
    { "cod_maq": 201, "piso": 1 },
    { "cod_maq": 202, "piso": 1 },
    { "cod_maq": 203, "piso": 2 },
    { "cod_maq": 204, "piso": 2 },
    { "cod_maq": 205, "piso": 3 },
    { "cod_maq": 206, "piso": 3 },
    { "cod_maq": 207, "piso": 4 },
    { "cod_maq": 208, "piso": 4 },
    { "cod_maq": 209, "piso": 5 },
    { "cod_maq": 210, "piso": 5 }
]);

// Insertar datos en la colección venta
db.venta.insertMany([
    { "cod_productos": 101, "cod_cajero": 1, "cod_maq": 201 },
    { "cod_productos": 102, "cod_cajero": 2, "cod_maq": 202 },
    { "cod_productos": 103, "cod_cajero": 3, "cod_maq": 203 },
    { "cod_productos": 104, "cod_cajero": 4, "cod_maq": 204 },
    { "cod_productos": 105, "cod_cajero": 5, "cod_maq": 205 },
    { "cod_productos": 106, "cod_cajero": 6, "cod_maq": 206 },
    { "cod_productos": 107, "cod_cajero": 7, "cod_maq": 207 },
    { "cod_productos": 108, "cod_cajero": 8, "cod_maq": 208 },
    { "cod_productos": 109, "cod_cajero": 9, "cod_maq": 209 },
    { "cod_productos": 110, "cod_cajero": 10, "cod_maq": 210 }
]);
