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
    IVA DECIMAL (5,2), --DECIMAL (p, s). p --> precision, numero total de digitos. s --> escala, decimales despues de la coma.
        DEFAULT (CASE WHEN tipo_prod = 'E' THEN 4.00 ELSE 21.00 END), -- según tipo_prod especificado se aplicará el IVA.
    neto DECIMAL(8,2) DEFAULT (bruto * (1 + IVA/100))
    ); 
 
 --CORRECCION A:
 CREATE TABLE productos(
    id_producto CHAR(2), -- Simboliza el listado de los productos y la lugar a la capacidad max. de la tienda (100 productos, 0-99).
    PRIMARY KEY (id_producto),
    nom_prod VARCHAR(50) UNIQUE,
    qty_producto INT,
    bruto DECIMAL (8,2),
    tipo_prod CHAR(1) NOT NULL CHECK (tipo_prod IN ('E', 'N')), -- si o si, deberá expresarse el tipo de prod.
    IVA DECIMAL (5,2) DEFAULT 21.00, -- Establecemos un valor predeterminado simple para IVA (por ejemplo, 21.00).
    neto DECIMAL(8,2) DEFAULT 0.00, -- Establecemos un valor predeterminado simple para neto.
    CONSTRAINT chk_IVA CHECK (IVA >= 0), -- Aseguramos que el IVA sea un valor no negativo.
    CONSTRAINT chk_bruto CHECK (bruto >= 0), -- Aseguramos que el valor bruto sea no negativo.
    CONSTRAINT chk_qty_producto CHECK (qty_producto >= 0) -- Aseguramos que la cantidad de productos sea no negativa.
);
-- +
DELIMITER //
CREATE FUNCTION calcular_neto(bruto DECIMAL(8,2), IVA DECIMAL(5,2))
RETURNS DECIMAL(8,2)
BEGIN
    DECLARE neto DECIMAL(8,2);
    SET neto = bruto * (1 + IVA/100);
    RETURN neto;
END//
DELIMITER ;

--old
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
-- ACTUALIZADA A:
CREATE TABLE suministrar (
    id_factura CHAR(4),
    id_producto CHAR(2),
    id_proveedor INT,
    qty_suministro INT,
    precio_prod_proveedor DECIMAL (8,2),
    IVA DECIMAL (5,2),
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
    nom_prod VARCHAR(50) UNIQUE,
    FOREIGN KEY (nom_prod) REFERENCES productos(nom_prod),
    qty_prod_pedido INT
);


--old
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

--modificada a:
CREATE TABLE pedidos (
    id_pedido CHAR(10),
    PRIMARY KEY (id_pedido),
    nom_prod VARCHAR(50) UNIQUE,
    qty_prod_pedido INT,
    bruto DECIMAL (8,2),
    IVA DECIMAL (5,2),
    coste_compra_bruto DECIMAL (8,2) GENERATED ALWAYS AS (qty_prod_pedido * bruto) STORED,
    coste_compra_neto DECIMAL (8,2) GENERATED ALWAYS AS (qty_prod_pedido * (bruto * (1 + IVA/100))) STORED,
    tipo_pago CHAR(1) NOT NULL CHECK (tipo_pago IN ('E', 'T')),
    pago_realizado DECIMAL (8,2),
    devolucion DECIMAL(8,2) DEFAULT 0,
    id_cliente CHAR(4),
    FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),
    fecha_pedido DATE DEFAULT CURRENT_DATE
);


DELIMITER //

CREATE PROCEDURE calcular_devolucion(IN pedido_id CHAR(10))
BEGIN
    DECLARE tipo_prod CHAR(1);
    DECLARE prod_bruto DECIMAL(8,2);
    DECLARE pago_realizado DECIMAL(8,2);
    DECLARE devolucion_amount DECIMAL(8,2);

    SELECT tipo_prod, bruto, pago_realizado
    INTO tipo_prod, prod_bruto, pago_realizado
    FROM pedidos
    WHERE id_pedido = pedido_id;

    IF tipo_prod = 'E' THEN
        SET devolucion_amount = 0;
    ELSE
        SET devolucion_amount = prod_bruto - pago_realizado;
    END IF;

    UPDATE pedidos
    SET devolucion = devolucion_amount
    WHERE id_pedido = pedido_id;
END //

DELIMITER ;


-- +
DELIMITER //
CREATE PROCEDURE calcular_coste_compra_neto()
BEGIN
    DECLARE bruto_val DECIMAL(8,2);
    DECLARE IVA_val DECIMAL(5,2);
    DECLARE neto_val DECIMAL(8,2);

    -- Recorre los registros en la tabla pedidos
    FOR EACH_ROW IN (SELECT * FROM pedidos) DO
        -- Obtén los valores de bruto e IVA para el registro actual
        SET bruto_val = EACH_ROW.bruto;
        SET IVA_val = EACH_ROW.IVA;

        -- Calcula el valor neto usando la función calcular_neto()
        SET neto_val = calcular_neto(bruto_val, IVA_val);

        -- Actualiza el valor de coste_compra_neto para el registro actual
        UPDATE pedidos
        SET coste_compra_neto = neto_val
        WHERE id_pedido = EACH_ROW.id_pedido;
    END FOR;
END //
DELIMITER ;

-- ISA
CREATE DATABASE tiendax;
USE tiendax;

CREATE TABLE proveedores (
     id_proveedor INT,
     PRIMARY KEY (id_proveedor),
     nombre_prov CHAR(50)
     );

CREATE TABLE facturas (
    id_factura CHAR(4),
    PRIMARY KEY (id_factura),
    descripcion VARCHAR(100),
    fecha_factura DATE NOT NULL
     );

CREATE TABLE productos (
    id_producto CHAR(2),
    PRIMARY KEY (id_producto),
    nom_prod VARCHAR(50) UNIQUE,
    qty_producto INT,
    bruto DECIMAL(8,2),
    tipo_prod CHAR(1) NOT NULL CHECK (tipo_prod IN ('E', 'N')),
    IVA DECIMAL(5,2) DEFAULT (CASE WHEN tipo_prod = 'E' THEN 4.00 ELSE 21.00 END),
    neto DECIMAL(8,2) DEFAULT (bruto * (1 + IVA/100))
     );

CREATE TABLE suministrar(
    id_factura CHAR(4),
    id_producto CHAR(2),
    id_proveedor INT,
    qty_suministro INT,
    precio_prod_proveedor DECIMAL(8,2),
    IVA DECIMAL(5,2),
    coste_suministro DECIMAL(8,2) AS (precio_prod_proveedor * (1 + IVA/100)),
    PRIMARY KEY (id_factura, id_producto, id_proveedor),
    FOREIGN KEY (id_factura) REFERENCES facturas(id_factura),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto), FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
     );

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
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    nom_prod VARCHAR(50),
    qty_prod_pedido INT,
    FOREIGN KEY (nom_prod) REFERENCES productos(nom_prod)
    );

CREATE TABLE pedidos (
    id_pedido CHAR(10),
    PRIMARY KEY (id_pedido),
    qty_prod_pedido INT,
    bruto DECIMAL (8,2),
    IVA DECIMAL (5,2),
    neto DECIMAL(8,2), -- Definir la columna neto
    coste_compra_bruto DECIMAL (8,2) AS (qty_prod_pedido * bruto) STORED, -- Calcular el coste bruto basado en las columnas existentes
    coste_compra_neto DECIMAL (8,2) AS (qty_prod_pedido * neto) STORED, -- Calcular el coste neto basado en las columnas existentes
    tipo_pago CHAR(1) NOT NULL CHECK (tipo_pago IN ('E', 'T')),
    pago_realizado DECIMAL (8,2),
    devolucion DECIMAL(8,2),
    id_cliente CHAR(4),
    FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),
    fecha_pedido DATE DEFAULT CURRENT_DATE
    );

