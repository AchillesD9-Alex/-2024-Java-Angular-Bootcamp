// Conectarse a la base de datos directores_db
use directores_db

// Crear la colección despachos
db.createCollection("despachos")

// Insertar datos en la colección despachos
db.despachos.insertMany([
    { "num_despacho": 1, "capacidad": 3 },
    { "num_despacho": 2, "capacidad": 8 },
    { "num_despacho": 3, "capacidad": 7 },
    { "num_despacho": 4, "capacidad": 6 },
    { "num_despacho": 5, "capacidad": 4 },
    { "num_despacho": 6, "capacidad": 1 },
    { "num_despacho": 7, "capacidad": 2 },
    { "num_despacho": 8, "capacidad": 9 },
    { "num_despacho": 9, "capacidad": 5 },
    { "num_despacho": 10, "capacidad": 12 }
]);

// Insertar datos en la colección directores
db.directores.insertMany([
    { "dni": "12345", "nom_apels": "Román Díaz, Alexandre", "dni_jefe": null, "num_despacho": "1" },
    { "dni": "22345", "nom_apels": "Sanchez, Pedro", "dni_jefe": null, "num_despacho": "2" },
    { "dni": "32345", "nom_apels": "Rajoy, Mariano", "dni_jefe": null, "num_despacho": "3" },
    { "dni": "42345", "nom_apels": "Swift, Taylor", "dni_jefe": null, "num_despacho": "4" },
    { "dni": "62345", "nom_apels": "Chalamet, Timothée", "dni_jefe": null, "num_despacho": "5" },
    { "dni": "52345", "nom_apels": "Shelby, Tommy", "dni_jefe": null, "num_despacho": "6" },
    { "dni": "72345", "nom_apels": "White, Walter", "dni_jefe": null, "num_despacho": "7" },
    { "dni": "82345", "nom_apels": "Monkey D, Luffy", "dni_jefe": null, "num_despacho": "8" },
    { "dni": "92345", "nom_apels": "Roronoa, Zoro", "dni_jefe": null, "num_despacho": "9" },
    { "dni": "13345", "nom_apels": "Lee,Bruce ", "dni_jefe": null, "num_despacho": "10" }
]);
