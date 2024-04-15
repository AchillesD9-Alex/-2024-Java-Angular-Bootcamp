CREATE DATABASE almacenes_db;
USE almacenes_db;

CREATE TABLE almacenes(
    cod_almacen INT,
    PRIMARY KEY (cod_almacen),
    lugar VARCHAR (100),
    capacidad INT);

CREATE TABLE cajas(
    num_referencia CHAR(5),
    PRIMARY KEY (num_referencia),
    contenido VARCHAR(100),
    valor INT,
    cod_almacen INT,
    FOREIGN KEY (cod_almacen) REFERENCES almacenes (cod_almacen)
    ON DELETE CASCADE ON UPDATE CASCADE);