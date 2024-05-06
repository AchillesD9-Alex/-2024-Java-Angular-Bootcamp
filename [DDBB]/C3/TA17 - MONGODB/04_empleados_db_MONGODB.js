// Conectarse a la base de datos empleados_db
use empleados_db

// Crear la colección departamentos
db.createCollection("departamentos")

// Crear la colección empleados
db.createCollection("empleados")

// Insertar datos en la colección departamentos
db.departamentos.insertMany([
    { "cod_departamento": 1, "nombre": "Ventas", "presupuesto": 100000 },
    { "cod_departamento": 2, "nombre": "Marketing", "presupuesto": 80000 },
    { "cod_departamento": 3, "nombre": "Recursos Humanos", "presupuesto": 120000 },
    { "cod_departamento": 4, "nombre": "Producción", "presupuesto": 150000 },
    { "cod_departamento": 5, "nombre": "Finanzas", "presupuesto": 90000 },
    { "cod_departamento": 6, "nombre": "Tecnología", "presupuesto": 200000 },
    { "cod_departamento": 7, "nombre": "Logística", "presupuesto": 110000 },
    { "cod_departamento": 8, "nombre": "Administración", "presupuesto": 130000 },
    { "cod_departamento": 9, "nombre": "Calidad", "presupuesto": 100000 },
    { "cod_departamento": 10, "nombre": "Investigación y Desarrollo", "presupuesto": 180000 }
]);

// Insertar datos en la colección empleados
db.empleados.insertMany([
    { "DNI": "12345678A", "nombre": "Juan", "apellidos": "García Pérez", "cod_departamento": 1 },
    { "DNI": "23456789B", "nombre": "María", "apellidos": "López Martínez", "cod_departamento": 2 },
    { "DNI": "34567890C", "nombre": "Antonio", "apellidos": "Rodríguez Sánchez", "cod_departamento": 3 },
    { "DNI": "45678901D", "nombre": "Laura", "apellidos": "González Fernández", "cod_departamento": 4 },
    { "DNI": "56789012E", "nombre": "David", "apellidos": "Martín Hernández", "cod_departamento": 5 },
    { "DNI": "67890123F", "nombre": "Sofía", "apellidos": "Pérez Díaz", "cod_departamento": 6 },
    { "DNI": "78901234G", "nombre": "Manuel", "apellidos": "Ruiz López", "cod_departamento": 7 },
    { "DNI": "89012345H", "nombre": "Ana", "apellidos": "Sánchez Rodríguez", "cod_departamento": 8 },
    { "DNI": "90123456I", "nombre": "Elena", "apellidos": "Gómez Martínez", "cod_departamento": 9 },
    { "DNI": "01234567J", "nombre": "Carlos", "apellidos": "Fernández Pérez", "cod_departamento": 10 }
]);
