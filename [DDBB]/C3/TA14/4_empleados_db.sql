CREATE DATABASE empleados_DB;
USE empleados_DB;

CREATE TABLE departamentos(
    cod_departamento INT,
    PRIMARY KEY (cod_departamento),
    nombre VARCHAR(100),
    presupuesto INT);

CREATE TABLE empleados(
    DNI VARCHAR(8),
    PRIMARY KEY (DNI),
    nombre VARCHAR(100),
    apellidos VARCHAR(255),
    cod_departamento INT,
    FOREIGN KEY (cod_departamento) REFERENCES departamentos (cod_departamento)
    ON DELETE CASCADE ON UPDATE CASCADE);
