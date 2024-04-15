CREATE DATABASE peliculas_salas;
USE peliculas_salas;

CREATE TABLE peliculas(
    cod_pelicula INT,
    PRIMARY KEY (cod_pelicula),
    nombre VARCHAR (100),
    cal_edad INT);

CREATE TABLE salas(
    cod_sala CHAR(5),
    PRIMARY KEY (cod_sala),
    nombre VARCHAR(100),
    cod_pelicula INT,
    FOREIGN KEY (cod_pelicula) REFERENCES peliculas (cod_pelicula)
    ON DELETE CASCADE ON UPDATE CASCADE);