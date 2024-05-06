INSERT INTO departamentos (cod_departamento, nombre, presupuesto) VALUES
(1, 'Ventas', 100000),
(2, 'Marketing', 80000),
(3, 'Recursos Humanos', 120000),
(4, 'Producción', 150000),
(5, 'Finanzas', 90000),
(6, 'Tecnología', 200000),
(7, 'Logística', 110000),
(8, 'Administración', 130000),
(9, 'Calidad', 100000),
(10, 'Investigación y Desarrollo', 180000);

INSERT INTO empleados (DNI, nombre, apellidos, cod_departamento) VALUES
('12345678A', 'Juan', 'García Pérez', 1),
('23456789B', 'María', 'López Martínez', 2),
('34567890C', 'Antonio', 'Rodríguez Sánchez', 3),
('45678901D', 'Laura', 'González Fernández', 4),
('56789012E', 'David', 'Martín Hernández', 5),
('67890123F', 'Sofía', 'Pérez Díaz', 6),
('78901234G', 'Manuel', 'Ruiz López', 7),
('89012345H', 'Ana', 'Sánchez Rodríguez', 8),
('90123456I', 'Elena', 'Gómez Martínez', 9),
('01234567J', 'Carlos', 'Fernández Pérez', 10);

-- Obtener los apellidos de los empleados
SELECT apellidos FROM empleados;

-- Obtener los apellidos de los empleados sin repeticiones
SELECT DISTINCT apellidos FROM empleados;

-- Obtener todos los datos de los empleados que se apellidan 'López' (usamos LIKE '%string%' porque tengo 2 apellidos en la columna de apellidos; asi busco la cadena 'López' en la cadena 'Apellido1 Apellido2'; si Apellido1 o Apellido2 = la cadena buscada, aparecerá en la consulta).
SELECT * FROM empleados WHERE apellidos LIKE '%López%';

-- Obtener todos los datos de los empleados que se apellidan 'López' y 'Pérez'
SELECT * FROM empleados WHERE apellidos LIKE '%López%' OR apellidos LIKE '%Pérez%';

-- Obtener todos los datos de los empleados que trabajan para el departamento 4
SELECT * FROM empleados WHERE cod_departamento = 4;

-- Obtener todos los datos de los empleados que trabajan para el departamento 3 y para el departamento 7
SELECT * FROM empleados WHERE cod_departamento IN (3, 7);

-- Obtener todos los datos de los empleados cuyo apellido comience por P
SELECT * FROM empleados WHERE apellidos LIKE 'P%';

-- Obtener el presupuesto total de todos los departamentos
SELECT SUM(presupuesto) AS presupuesto_total FROM departamentos;

-- Obtener el número de empleados en cada departamento
SELECT cod_departamento, COUNT(*) AS numero_empleados FROM empleados GROUP BY cod_departamento;

-- Obtener un listado completo de empleados, incluyendo por cada empleado los datos del empleado y de su departamento
SELECT e.*, d.nombre AS nombre_departamento, d.presupuesto 
FROM empleados AS e 
JOIN departamentos AS d ON e.cod_departamento = d.cod_departamento;

-- Obtener un listado completo de empleados, incluyendo el nombre y apellidos del empleado junto al nombre y presupuesto de su departamento
SELECT e.nombre, e.apellidos, d.nombre AS nombre_departamento, d.presupuesto 
FROM empleados AS e 
JOIN departamentos AS d ON e.cod_departamento = d.cod_departamento;

-- Obtener los nombres y apellidos de los empleados que trabajen en departamentos cuyo presupuesto sea mayor a 12.000€
SELECT e.nombre, e.apellidos 
FROM empleados e 
JOIN departamentos d ON e.cod_departamento = d.cod_departamento 
WHERE d.presupuesto > 12000;

-- Obtener los datos de los departamentos cuyo presupuesto es superior al presupuesto medio de todos los departamentos
SELECT * 
FROM departamentos 
WHERE presupuesto > (SELECT AVG(presupuesto) FROM departamentos);

-- Obtener los nombres (únicamente los nombres) de los departamentos que tienen más de 2 empleados
SELECT d.nombre 
FROM empleados e 
JOIN departamentos d ON e.cod_departamento = d.cod_departamento 
GROUP BY d.nombre 
HAVING COUNT(*) > 2;

-- Añadir un nuevo departamento: 'Nueva_Calidad', con presupuesto de 40.000€ y código 11
INSERT INTO departamentos (cod_departamento, nombre, presupuesto) VALUES (11, 'Nueva_Calidad', 40000);

-- Añadir un empleado vinculado al departamento recién creado: Esther Vázquez, DNI 89267109
INSERT INTO empleados (dni, nombre, apellidos, cod_departamento) VALUES ('89267109', 'Esther', 'Vázquez', 11);

-- Aplicar un recorte presupuestario del 10% a todos los departamentos
UPDATE departamentos SET presupuesto = presupuesto * 0.9;

-- Reasignar a los empleados del departamento Administración (código 10) al departamento Tecnología (código 5)
UPDATE empleados SET cod_departamento = 5 WHERE cod_departamento = 10;

-- Despedir a todos los empleados que trabajan para el departamento de Tecnología (código 5)
DELETE FROM empleados WHERE cod_departamento = 5;

-- Despedir a todos los empleados que trabajen para departamentos cuyo presupuesto sea superior a los 15.000€
DELETE FROM empleados WHERE cod_departamento IN (SELECT cod_departamento FROM departamentos WHERE presupuesto > 15000);

-- 2.20 Despedir a todos los empleados
DELETE FROM empleados;
