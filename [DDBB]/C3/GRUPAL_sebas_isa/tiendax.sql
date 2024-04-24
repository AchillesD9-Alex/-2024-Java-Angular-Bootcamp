CREATE DATABASE tiendax;
USE tiendax;

CREATE TABLE proveedores(
    id_proveedor INT,
    PRIMARY KEY (id_proveedor),
    nombre_proveedor VARCHAR(100));

CREATE TABLE facturas(
    id_factura CHAR(4),
    PRIMARY KEY (id_factura),
    descripcion VARCHAR(100),
    fecha_factura DATE NOT NULL);

CREATE TABLE productos(
    id_producto CHAR(2), -- Simboliza el listado de los productos y la lugar a la capacidad max. de la tienda (100 productos, 0-99).
    PRIMARY KEY (id_producto),
    nom_prod VARCHAR(50),
    qty INT,
    price INT,
    tipo_prod CHAR(1) NOT NULL CHECK (tipo_prod IN ('E', 'N')), -- si o si, deberá expresarse el tipo de prod.
    IVA DECIMAL (5,2) --DECIMAL (p, s). p --> precision, numero total de digitos. s --> escala, decimales despues de la coma.
        DEFAULT (CASE WHEN tipo_prod = 'E' THEN 4.00 ELSE 21.00 END)); -- según tipo_prod especificado se aplicará el IVA.


CREATE TABLE suministrar (
    id_factura CHAR(4),
    id_producto CHAR(2),
    id_proveedor INT,
    cantidad_suministro INT,
    PRIMARY KEY (id_factura, id_producto, id_proveedor),
    FOREIGN KEY (id_factura) REFERENCES facturas(id_factura),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);


--CREAR CLIENTE
CREATE TABLE clientes (
    id_cliente CHAR(4),
    PRIMARY KEY (id_cliente),
    nombre VARCHAR(30),
    apel1 VARCHAR(30),
    apel2 VARCHAR(30),
    UNIQUE DNI  VARCHAR(9),
    fecha_nacimiento DATE,
    telefono INT,
    mail VARCHAR(50)
);


CREATE TABLE tickets (
    id_ticket CHAR(10),
    PRIMARY KEY (id_ticket),
    id_producto CHAR(2),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    qty_id_producto INT,
    price INT,
    FOREIGN KEY (price) REFERENCES productos(price), --mejor hacer bruto/neto en productos (?)
    coste_compra DECIMAL (8,2),
    pago_realizado DECIMAL (8,2), --tipo_pago añadir (?)
    devolución DECIMAL (8,2),
    id_cliente CHAR(4),
    PRIMARY KEY (id_cliente),
    fecha_compra DATE NOT NULL, --añadir fecha servidor auto
        
);

