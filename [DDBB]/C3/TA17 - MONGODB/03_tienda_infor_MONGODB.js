//Crear y conectarse a la base de datos tienda_infor
use tienda_infor

//Crear la colección fabricantes
db.createCollection("fabricantes")

//Crear la colección articulos
db.createCollection("articulos")


db.fabricantes.insertMany([
    { "cod_fabricantes": 1, "nombre": "Lenovo" },
    { "cod_fabricantes": 2, "nombre": "Samsung" },
    { "cod_fabricantes": 3, "nombre": "Logitech" },
    { "cod_fabricantes": 4, "nombre": "Microsoft" },
    { "cod_fabricantes": 5, "nombre": "HP" },
    { "cod_fabricantes": 6, "nombre": "Western Digital" },
    { "cod_fabricantes": 7, "nombre": "SanDisk" },
    { "cod_fabricantes": 8, "nombre": "Creative" },
    { "cod_fabricantes": 9, "nombre": "Logitech" },
    { "cod_fabricantes": 10, "nombre": "TP-Link" }
]);

db.articulos.insertMany([
    { "cod_articulos": 101, "nombre": "Portátil Lenovo", "precio": 1200, "cod_fabricantes": 1 },
    { "cod_articulos": 102, "nombre": "Monitor Samsung", "precio": 300, "cod_fabricantes": 2 },
    { "cod_articulos": 103, "nombre": "Teclado Logitech", "precio": 50, "cod_fabricantes": 3 },
    { "cod_articulos": 104, "nombre": "Ratón Microsoft", "precio": 30, "cod_fabricantes": 4 },
    { "cod_articulos": 105, "nombre": "Impresora HP", "precio": 200, "cod_fabricantes": 5 },
    { "cod_articulos": 106, "nombre": "Disco Duro Externo Western Digital", "precio": 100, "cod_fabricantes": 6 },
    { "cod_articulos": 107, "nombre": "Memoria USB SanDisk", "precio": 20, "cod_fabricantes": 7 },
    { "cod_articulos": 108, "nombre": "Altavoces Creative", "precio": 80, "cod_fabricantes": 8 },
    { "cod_articulos": 109, "nombre": "Webcam Logitech", "precio": 40, "cod_fabricantes": 9 },
    { "cod_articulos": 110, "nombre": "Router WiFi TP-Link", "precio": 60, "cod_fabricantes": 10 },
]);
