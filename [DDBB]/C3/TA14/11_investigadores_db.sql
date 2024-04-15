CREATE DATABASE investigadores_db;
USE investigadores_db;

CREATE TABLE facultad(
    cod_facultad INT,
    PRIMARY KEY (cod_facultad),
    nombre VARCHAR(100));

CREATE TABLE investigadores(
    DNI VARCHAR(8),
    PRIMARY KEY (DNI),
    nom_apels VARCHAR(255),
    cod_facultad INT,
    FOREIGN KEY (cod_facultad) REFERENCES facultad (cod_facultad)
    ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE equipos(
    num_serie CHAR(4),
    PRIMARY KEY (num_serie),
    nombre VARCHAR(100),
    cod_facultad INT,
    FOREIGN KEY (cod_facultad) REFERENCES facultad (cod_facultad)
    ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE reserva(
    comienzo DATE,
    fin DATE,
    DNI VARCHAR(8),
    num_serie CHAR(4),
    PRIMARY KEY (DNI, num_serie),
    FOREIGN KEY (DNI) REFERENCES investigadores (DNI)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (num_serie) REFERENCES equipos (num_serie)
    ON DELETE CASCADE ON UPDATE CASCADE);