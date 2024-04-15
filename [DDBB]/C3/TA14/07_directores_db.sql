CREATE DATABASE directores_db;
use directores_db

CREATE TABLE despachos(
    num_despacho INT,
    PRIMARY KEY (num_despacho),
    capacidad INT);

CREATE TABLE directores(
    DNI VARCHAR(8),
    PRIMARY KEY (DNI),
    nom_apels VARCHAR(255),
    DNI_jefe VARCHAR(8),
    FOREIGN KEY (DNI_jefe) REFERENCES directores (DNI)
    ON DELETE CASCADE ON UPDATE CASCADE,
    num_despacho INT,
    FOREIGN KEY (num_despacho) REFERENCES despachos (num_despacho)
    ON DELETE CASCADE ON UPDATE CASCADE);