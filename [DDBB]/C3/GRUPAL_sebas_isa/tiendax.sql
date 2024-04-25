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
    nom_prod VARCHAR(50) UNIQUE,
    qty_producto INT,
    bruto DECIMAL (8,2),
    tipo_prod CHAR(1) NOT NULL CHECK (tipo_prod IN ('E', 'N')), -- si o si, deberá expresarse el tipo de prod.
    IVA DECIMAL (5,2) --DECIMAL (p, s). p --> precision, numero total de digitos. s --> escala, decimales despues de la coma.
        DEFAULT (CASE WHEN tipo_prod = 'E' THEN 4.00 ELSE 21.00 END), -- según tipo_prod especificado se aplicará el IVA.
    neto DECIMAL(8,2) DEFAULT (bruto * (1 + IVA/100))
    ); 


CREATE TABLE suministrar (
    id_factura CHAR(4),
    id_producto CHAR(2),
    id_proveedor INT,
    qty_suministro INT,
    precio_prod_proveedor DECIMAL (8,2),
    IVA DECIMAL (5,2),
        FOREIGN KEY (IVA) REFERENCES productos(IVA),
    coste_suministro DECIMAL (8,2) AS (precio_prod_proveedor * (1 + IVA/100)),
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
    DNI VARCHAR(9) UNIQUE NOT NULL,
    fecha_nacimiento DATE,
    telefono INT,
    mail VARCHAR(50)
);


CREATE TABLE incluir (
    id_pedido CHAR(10),
    PRIMARY KEY (id_pedido),
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    nom_prod VARCHAR(50),
    FOREIGN KEY (nom_prod) REFERENCES productos(nom_prod),
    qty_prod_pedido INT,
);


CREATE TABLE pedidos (
    id_pedido CHAR(10),
    PRIMARY KEY (id_pedido),
    nom_prod VARCHAR(50) UNIQUE,
        FOREIGN KEY (nom_prod) REFERENCES productos(nom_prod),
    qty_prod_pedido INT,
        FOREIGN KEY (qty_prod_pedido) REFERENCES incluir(qty_prod_pedido),
    bruto DECIMAL (8,2),
        FOREIGN KEY (bruto) REFERENCES productos(bruto),
    IVA DECIMAL (5,2),
        FOREIGN KEY (IVA) REFERENCES productos(IVA),
    coste_compra_bruto DECIMAL (8,2) GENERATED ALWAYS AS --indica cómo se genera el valor de la columna.
                    (qty_prod_pedido * bruto) STORED, --STORED: el valor calculado se almacena físicamente en la base de datos. Esto significa que se guarda en la tabla Y NO SE CALCULA cada vez que se consulta la columna.
    coste_compra_neto DECIMAL (8,2) GENERATED ALWAYS AS (qty_prod_pedido * neto) STORED,
    tipo_pago CHAR(1) NOT NULL CHECK (tipo_pago IN ('E', 'T')),
    pago_realizado DECIMAL (8,2),
    devolución DECIMAL(8,2)
        DEFAULT (CASE WHEN (SELECT tipo_prod FROM productos WHERE nom_prod = pedidos.nom_prod) = 'E' THEN 0
                        ELSE (coste_compra_bruto - pago_realizado) END),

    id_cliente CHAR(4),
    FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),
    fecha_pedido DATE DEFAULT CURRENT_DATE, -- Se establece automáticamente la fecha actual al momento de la inserción de datos

);

