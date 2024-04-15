CREATE DATABASE grandes_almacenes;
USE grandes_almacenes;

CREATE TABLE cajeros(
    cod_cajero INT,
    PRIMARY KEY (cod_cajero),
    nom_apels VARCHAR(255));

CREATE TABLE productos(
    cod_productos INT,
    PRIMARY KEY (cod_productos),
    nombre VARCHAR(100),
    precio INT);

CREATE TABLE maq_registradoras(
    cod_maq INT,
    PRIMARY KEY (cod_maq),
    piso INT);

CREATE TABLE venta(
    cod_productos INT,
    cod_cajero INT,
    cod_maq INT,
    PRIMARY KEY (cod_productos, cod_cajero, cod_maq),
    FOREIGN KEY (cod_productos) REFERENCES productos (cod_productos)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (cod_cajero) REFERENCES cajeros (cod_cajero)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (cod_maq) REFERENCES maq_registradoras (cod_maq)
    ON DELETE CASCADE ON UPDATE CASCADE);