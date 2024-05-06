// Conectarse a la base de datos almacenes_db
use almacenes_db

// Crear la colección almacenes
db.createCollection("almacenes")

// Crear la colección cajas
db.createCollection("cajas")

// Insertar datos en la colección almacenes
db.almacenes.insertMany([
    { "cod_almacen": 1, "lugar": "Barcelona", "capacidad": 500 },
    { "cod_almacen": 2, "lugar": "Bilbao", "capacidad": 400 },
    { "cod_almacen": 3, "lugar": "Madrid", "capacidad": 600 },
    { "cod_almacen": 4, "lugar": "Valencia", "capacidad": 450 },
    { "cod_almacen": 5, "lugar": "Sevilla", "capacidad": 550 },
    { "cod_almacen": 6, "lugar": "Zaragoza", "capacidad": 480 },
    { "cod_almacen": 7, "lugar": "Málaga", "capacidad": 520 },
    { "cod_almacen": 8, "lugar": "Murcia", "capacidad": 470 },
    { "cod_almacen": 9, "lugar": "Palma de Mallorca", "capacidad": 420 },
    { "cod_almacen": 10, "lugar": "Las Palmas de Gran Canaria", "capacidad": 380 }
]);

// Insertar datos en la colección cajas
db.cajas.insertMany([
    { "num_referencia": "A0001", "contenido": "Libros", "valor": 50, "cod_almacen": 1 },
    { "num_referencia": "B0002", "contenido": "Electrónica", "valor": 120, "cod_almacen": 2 },
    { "num_referencia": "C0003", "contenido": "Ropa", "valor": 80, "cod_almacen": 3 },
    { "num_referencia": "D0004", "contenido": "Herramientas", "valor": 150, "cod_almacen": 4 },
    { "num_referencia": "E0005", "contenido": "Juguetes", "valor": 70, "cod_almacen": 5 },
    { "num_referencia": "F0006", "contenido": "Alimentos", "valor": 90, "cod_almacen": 6 },
    { "num_referencia": "G0007", "contenido": "Artículos de hogar", "valor": 110, "cod_almacen": 7 },
    { "num_referencia": "H0008", "contenido": "Cosméticos", "valor": 100, "cod_almacen": 8 },
    { "num_referencia": "I0009", "contenido": "Equipamiento deportivo", "valor": 130, "cod_almacen": 9 },
    { "num_referencia": "J0010", "contenido": "Muebles", "valor": 160, "cod_almacen": 10 }
]);
