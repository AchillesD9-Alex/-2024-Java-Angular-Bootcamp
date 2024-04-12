CREATE DATABASE meteo;
USE meteo;
CREATE TABLE estacion (
    id MEDIUMINT UNSIGNED NOT NULL,
    lat VARCHAR(12) NOT NULL,
    longitud VARCHAR(15) NOT NULL,
    alt MEDIUMINT NOT NULL,
    PRIMARY KEY (id));

CREATE TABLE muestra (
    id_estacion MEDIUMINT UNSIGNED NOT NULL,
    fecha DATE NOT NULL,
    temp_min TINYINT,
    temp_max TINYINT,
    precipita SMALLINT UNSIGNED,
    hum_min TINYINT UNSIGNED,
    hum_max TINYINT UNSIGNED,
    vel_min SMALLINT UNSIGNED,
    vel_max SMALLINT UNSIGNED,
    KEY (id_estacion),
    FOREIGN KEY(id_estacion) REFERENCES estacion (id)
    ON DELETE NO ACTION ON UPDATE CASCADE);