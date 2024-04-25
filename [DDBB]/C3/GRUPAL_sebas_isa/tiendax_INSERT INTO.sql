-- tabla proveedores
INSERT INTO proveedores (id_proveedor, nombre_proveedor) VALUES
(1, 'Distribuidora de Lácteos S.A.'),
(2, 'Panadería Hermanos García'),
(3, 'Frutas y Verduras Frescas SL');

-- tabla facturas
INSERT INTO facturas (id_factura, descripcion, fecha_factura) VALUES
('F001', 'Compra de productos lácteos', '2024-04-25'),
('F002', 'Suministro diario de pan', '2024-04-24'),
('F003', 'Compra de frutas y verduras', '2024-04-23');

--tabla productos
INSERT INTO productos (id_producto, nom_prod, qty_producto, bruto, tipo_prod) VALUES
('P001', 'Leche entera', 200, 1.50, 'E'),  -- Esencial
('P002', 'Pan de molde integral', 150, 1.20, 'E'),  -- Esencial
('P003', 'Manzanas Golden', 100, 0.80, 'E'),  -- Esencial
('P004', 'Café gourmet', 80, 5.00, 'N'),  -- No esencial
('P005', 'Yogur natural', 120, 0.80, 'E'),  -- Esencial
('P006', 'Galletas de chocolate', 100, 1.50, 'N'),  -- No esencial
('P007', 'Pasta italiana', 150, 1.00, 'N'),  -- No esencial
('P008', 'Aceite de oliva virgen extra', 100, 3.50, 'E'),  -- Esencial
('P009', 'Refresco de cola', 120, 1.20, 'N'),  -- No esencial
('P010', 'Huevos de gallina campera', 80, 2.00, 'E');  -- Esencial


-- tabla suministrar
INSERT INTO suministrar (id_factura, id_producto, id_proveedor, qty_suministro, precio_prod_proveedor, IVA) VALUES
('F001', 'P001', 1, 50, 1.20, 4.00),
('F002', 'P002', 2, 200, 1.00, 4.00),
('F003', 'P003', 3, 100, 0.60, 4.00);

-- tabla clientes
INSERT INTO clientes (id_cliente, nombre, apel1, apel2, DNI, fecha_nacimiento, telefono, mail) VALUES
('C001', 'Juan', 'Gómez', 'Pérez', '12345678A', '1990-05-15', 123456789, 'juan@example.com'),
('C002', 'María', 'López', 'Martínez', '87654321B', '1985-10-20', 987654321, 'maria@example.com'),
('C003', 'Antonio', 'Ruiz', 'Sánchez', '56789123C', '1978-02-08', 654987321, 'antonio@example.com');

-- tabla incluir
INSERT INTO incluir (id_pedido, nom_prod, qty_prod_pedido) VALUES
('PED001', 'Leche entera', 7),
('PED001', 'Pan de molde integral', 5),
('PED001', 'Manzanas Golden', 4);
('PED002', 'Café gourmet', 2),
('PED002', 'Yogur natural', 3),
('PED002', 'Galletas de chocolate', 2);
('PED003', 'Pasta italiana', 3),
('PED003', 'Aceite de oliva virgen extra', 2),
('PED003', 'Refresco de cola', 4);

-- tabla pedidos
INSERT INTO pedidos (id_pedido, nom_prod, qty_prod_pedido, bruto, IVA, tipo_pago, pago_realizado, id_cliente) VALUES
('PED001', 'Leche entera', 7, 1.50, 4.00, 'E', 10.50, 'C001'),
('PED001', 'Pan de molde integral', 5, 1.20, 4.00, 'E', 6.00, 'C001'),
('PED001', 'Manzanas Golden', 4, 0.80, 4.00, 'E', 3.20, 'C001');
('PED002', 'Café gourmet', 2, 5.00, 4.00, 'E', 10.00, 'C002'),
('PED002', 'Yogur natural', 3, 0.80, 4.00, 'E', 2.40, 'C002'),
('PED002', 'Galletas de chocolate', 2, 1.50, 4.00, 'E', 3.00, 'C002');
('PED003', 'Pasta italiana', 3, 1.00, 4.00, 'E', 3.00, 'C003'),
('PED003', 'Aceite de oliva virgen extra', 2, 3.50, 4.00, 'E', 7.00, 'C003'),
('PED003', 'Refresco de cola', 4, 1.20, 4.00, 'E', 4.80, 'C003');
