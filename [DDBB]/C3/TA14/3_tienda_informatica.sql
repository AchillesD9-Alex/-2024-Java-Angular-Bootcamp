CREATE DATABASE tienda_infor;
USE tienda_infor;

CREATE TABLE fabricantes(
    cod_fabricantes INT,
    PRIMARY KEY (cod_fabricantes),
    nombre VARCHAR (100));

CREATE TABLE articulos(
    cod_articulos INT,
    PRIMARY KEY (cod_articulos),
    nombre VARCHAR (100),
    precio INT,
    cod_fabricantes INT,
    FOREIGN KEY (cod_fabricantes) REFERENCES fabricantes (cod_fabricantes)
        ON DELETE CASCADE
        ON UPDATE CASCADE);