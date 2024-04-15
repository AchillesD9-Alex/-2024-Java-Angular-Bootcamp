CREATE DATABASE cientificos_db;
USE cientificos_db;

CREATE TABLE cientificos(
    DNI VARCHAR(8),
    PRIMARY KEY (DNI),
    nom_apels VARCHAR(255));

CREATE TABLE proyecto(
    id_proyecto CHAR(4),
    PRIMARY KEY (id_proyecto),
    nombre VARCHAR(255),
    horas INT);

CREATE TABLE asignado_a(
    id_proyecto CHAR(4),
    DNI VARCHAR(8),
    PRIMARY KEY (id_proyecto, DNI),
    FOREIGN KEY (id_proyecto) REFERENCES proyecto (id_proyecto)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (DNI) REFERENCES cientificos (DNI)
    ON DELETE CASCADE ON UPDATE CASCADE);