INSERT INTO proveedores (id_proveedor, nombre_prov) VALUES 
(1, 'Microsoft'),
(2, 'Apple'),
(3, 'LG'),
(4, 'Lenovo'),
(5, 'Xiaomi');
(6, 'Distribuidora de Lácteos S.A.'),
(7, 'Panadería Hermanos García'),
(8, 'Frutas y Verduras Frescas SL');

INSERT INTO facturas (id_factura, descripcion, fecha_factura) VALUES 
('F001', 'Compra de productos de electrónica', '2024-04-25'),
('F002', 'Compra de suministros de oficina', '2024-04-26'),
('F003', 'Compra de mobiliario', '2024-04-27'),
('F004', 'Compra de productos de limpieza', '2024-04-28'),
('F005', 'Compra de herramientas', '2024-04-29');

INSERT INTO productos (id_producto, nom_prod, qty_producto, bruto, tipo_prod) VALUES 
('1', 'Portátil HP EliteBook', 50, 1200.00, 'N'),
('2', 'Monitor Dell 27"', 100, 299.99, 'N'),
('3', 'Silla ergonómica', 30, 199.99, 'N'),
('4', 'Impresora multifunción Epson', 40, 199.00, 'N'),
('5', 'Teclado inalámbrico Logitech', 80, 49.99, 'N');
('6', 'Café gourmet', 80, 5.00, 'N'),  -- No esencial
('7', 'Yogur natural', 120, 0.80, 'E'),  -- Esencial
('8', 'Galletas de chocolate', 100, 1.50, 'N'),

INSERT INTO clientes (id_cliente, nombre, apel1, apel2, DNI, fecha_nacimiento, telefono, mail) VALUES 
('C001', 'María', 'González', 'López', '12345678A', '1990-03-15', 987654321, 'maria@example.com'),
('C002', 'Carlos', 'Martínez', 'Ruiz', '23456789B', '1985-07-20', 654987321, 'carlos@example.com'),
('C003', 'Laura', 'Sánchez', 'García', '34567890C', '2000-01-05', 789654123, 'laura@example.com'),
('C004', 'Javier', 'Fernández', 'Díaz', '45678901D', '1978-11-28', 456123789, 'javier@example.com'),
('C005', 'Ana', 'Pérez', 'Martín', '56789012E', '1982-09-10', 321456987, 'ana@example.com');

-- Insertar datos en la tabla de pedidos
INSERT INTO pedidos (id_pedido, qty_prod_pedido, bruto, IVA, neto, tipo_pago, pago_realizado, devolucion, id_cliente)
VALUES 
('P001', 2, 500.00, 21.00, 605.00, 'E', 605.00, 0.00, 'C001'),
('P002', 3, 1000.00, 21.00, 1263.00, 'T', 1263.00, 0.00, 'C002'),
('P003', 1, 200.00, 21.00, 242.00, 'E', 242.00, 0.00, 'C003'),
('P004', 4, 800.00, 21.00, 1012.00, 'T', 1012.00, 0.00, 'C004'),
('P005', 2, 600.00, 21.00, 726.00, 'E', 726.00, 0.00, 'C005');

-- Insertar datos en la tabla de incluir (relacionada con pedidos)
INSERT INTO incluir (id_pedido, nom_prod, qty_prod_pedido)
VALUES 
('P001', 'Portátil HP EliteBook', 1),
('P001', 'Monitor Dell 27"', 1),
('P002', 'Silla ergonómica', 2),
('P002', 'Impresora multifunción Epson', 1),
('P003', 'Teclado inalámbrico Logitech', 1),
('P004', 'Portátil HP EliteBook', 2),
('P004', 'Silla ergonómica', 1),
('P004', 'Teclado inalámbrico Logitech', 1),
('P005', 'Monitor Dell 27"', 2);

