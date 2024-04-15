CREATE DATABASE piezas_proveedores;
USE piezas_proveedores;

CREATE TABLE piezas(
    cod_pieza INT,
    PRIMARY KEY (cod_pieza),
    nombre VARCHAR(100));

CREATE TABLE proveedores(
    id_proveedor CHAR(4),
    PRIMARY KEY (id_proveedor),
    nombre VARCHAR(100));

CREATE TABLE suministra(
    precio INT,
    id_proveedor CHAR(4),
    cod_pieza INT,
    PRIMARY KEY (id_proveedor, cod_pieza),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores (id_proveedor)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (cod_pieza) REFERENCES piezas (cod_pieza)
    ON DELETE CASCADE ON UPDATE CASCADE);