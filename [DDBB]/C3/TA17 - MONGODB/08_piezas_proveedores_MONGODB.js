// Conectarse a la base de datos piezas_proveedores
use piezas_proveedores

// Crear la colección piezas
db.createCollection("piezas")

// Crear la colección proveedores
db.createCollection("proveedores")

// Crear la colección suministra
db.createCollection("suministra")

// Insertar datos en la colección piezas
db.piezas.insertMany([
    { "cod_pieza": 1, "nombre": "tornillo" },
    { "cod_pieza": 2, "nombre": "muelle" },
    { "cod_pieza": 3, "nombre": "rosca" },
    { "cod_pieza": 4, "nombre": "tope" },
    { "cod_pieza": 5, "nombre": "abrazadera" },
    { "cod_pieza": 6, "nombre": "brida" },
    { "cod_pieza": 7, "nombre": "tuerca" },
    { "cod_pieza": 8, "nombre": "perno" },
    { "cod_pieza": 9, "nombre": "ya no se cual mas poner" },
    { "cod_pieza": 10, "nombre": "esta tambien me la invento" }
]);

// Insertar datos en la colección proveedores
db.proveedores.insertMany([
    { "id_proveedor": "1000", "nombre": "LeroyMerlin" },
    { "id_proveedor": "2000", "nombre": "BauHaus" },
    { "id_proveedor": "3000", "nombre": "Carrefour" },
    { "id_proveedor": "4000", "nombre": "IKEA" },
    { "id_proveedor": "5000", "nombre": "CasaPacoSL" },
    { "id_proveedor": "6000", "nombre": "CasamariaSA" },
    { "id_proveedor": "7000", "nombre": "InventoNamberJuan" },
    { "id_proveedor": "8000", "nombre": "2Good2Go" },
    { "id_proveedor": "9000", "nombre": "ElCorteIngles" },
    { "id_proveedor": "0000", "nombre": "MercadilloTorreforta" }
]);

// Insertar datos en la colección suministra
db.suministra.insertMany([
    { "cod_pieza": 1, "id_proveedor": "1000", "precio": 2 },
    { "cod_pieza": 2, "id_proveedor": "2000", "precio": 3 },
    { "cod_pieza": 3, "id_proveedor": "3000", "precio": 1 },
    { "cod_pieza": 4, "id_proveedor": "4000", "precio": 2 },
    { "cod_pieza": 5, "id_proveedor": "5000", "precio": 3 },
    { "cod_pieza": 6, "id_proveedor": "6000", "precio": 4 },
    { "cod_pieza": 7, "id_proveedor": "7000", "precio": 5 },
    { "cod_pieza": 8, "id_proveedor": "8000", "precio": 4 },
    { "cod_pieza": 9, "id_proveedor": "9000", "precio": 1 },
    { "cod_pieza": 10, "id_proveedor": "0000", "precio": 2 }
]);
