CREATE DATABASE academia;
USE academia;

CREATE TABLE profesores(
    DNI_profesor VARCHAR(8),
    PRIMARY KEY (DNI_profesor),
    nom_apels_prof VARCHAR (255),
    UNIQUE (nom_apels_prof),
    direccion VARCHAR(100),
    titulacion VARCHAR(50),
    sueldo SMALLINT NOT NULL);

CREATE TABLE cursos(
    cod_curso INT,
    PRIMARY KEY (cod_curso),
    nom_curso VARCHAR(100),
    UNIQUE (nom_curso),
    horas INT NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    CONSTRAINT fecha_curso CHECK (fecha_inicio<fecha_fin),
    num_max_alumn INT,
    DNI_profesor varchar(8),
    FOREIGN KEY (DNI_profesor) REFERENCES profesores (DNI_profesor)
    ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE alumnos(
    nom_apels_alumn VARCHAR (255),
    UNIQUE (nom_apels_alumn),
    DNI_alumn VARCHAR(8),
    PRIMARY KEY (DNI_alumn),
    direccion VARCHAR(100),
    fecha_nacimiento DATE,
    sexo CHAR(1) CHECK (sexo IN ('H', 'M')),
    cod_curso INT,
    FOREIGN KEY (cod_curso) REFERENCES cursos (cod_curso)
    ON DELETE CASCADE ON UPDATE CASCADE);
