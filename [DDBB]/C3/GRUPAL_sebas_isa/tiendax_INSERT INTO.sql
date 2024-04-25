INSERT INTO proveedores (nombre_proveedor)
VALUES 
    ('Distribuidora Alfa'),
    ('Comercial Beta'),
    ('Suministros Gamma'),
    ('Proveedora Delta'),
    ('Importadora Epsilon');


INSERT INTO productos (id_producto, nom_prod, qty_producto, bruto_prod, tipo_prod, IVA, neto_prod)
VALUES 
    ('1', 'Leche', 100, 0.80, 'E', 4.00, 0.83),
    ('2', 'Pan', 150, 1.20, 'E', 4.00, 1.25),
    ('3', 'Manzana', 200, 0.25, 'E', 4.00, 0.26),
    ('4', 'Pollo', 80, 3.50, 'E', 4.00, 3.64),
    ('5', 'Arroz', 120, 1.50, 'E', 4.00, 1.56),
    ('6', 'Televisor', 20, 199.99, 'N', 21.00, 242.99),
    ('7', 'Zapatillas deportivas', 30, 29.99, 'N', 21.00, 36.29),
    ('8', 'Mesa de comedor', 10, 89.99, 'N', 21.00, 109.19),
    ('9', 'Aspiradora', 15, 49.99, 'N', 21.00, 60.49),
    ('10', 'Maleta de viaje', 25, 39.99, 'N', 21.00, 48.39);


INSERT INTO facturas (id_factura, linea_factura, id_producto, qty_suministro, coste_prod_suministro, descripcion, fecha_factura)
VALUES 
    ('A', 1, '1', 50, 40.00, 'Lácteos', '2024-04-01'), -- Leche
    ('A', 2, '3', 20, 5.00, 'Frutas', '2024-04-01'), -- Manzana
    ('B', 1, '7', 10, 299.90, 'Calzado', '2024-04-02'), -- Zapatillas deportivas
    ('C', 1, '8', 5, 44.95, 'Muebles', '2024-04-03'), -- Mesa de comedor
    ('C', 2, '9', 10, 499.90, 'Electrodoméstico', '2024-04-03'), -- Aspiradora
    ('D', 1, '2', 15, 18.75, 'Panadería', '2024-04-04'), -- Pan
    ('D', 2, '5', 50, 75.00, 'Cereal', '2024-04-04'), -- Arroz
    ('D', 3, '10', 8, 319.92, 'Viaje', '2024-04-04'), -- Maleta de viaje
    ('D', 4, '6', 3, 599.97, 'Electrónica', '2024-04-04'); -- Televisor


INSERT INTO suministrar (id_factura, id_proveedor)
VALUES 
    ('A', 1), -- Proveedor 1 suministra a la factura A
    ('B', 2), -- Proveedor 2 suministra a la factura B
    ('C', 3); -- Proveedor 3 suministra a la factura C


INSERT INTO clientes (id_cliente, nombre, apel1, apel2, DNI, fecha_nacimiento, telefono, mail)
VALUES 
    ('C001', 'Juan', 'García', 'Pérez', '12345678A', '1990-05-15', 666555444, 'juan@gmail.com'),
    ('C002', 'María', 'Martínez', 'López', '87654321B', '1985-10-20', 611223344, 'maria@hotmail.com'),
    ('C003', 'Pedro', 'Fernández', 'Gómez', '56781234C', '1988-03-25', 688999000, 'pedro@yahoo.com'),
    ('C004', 'Laura', 'Rodríguez', 'Sánchez', '43218765D', '1992-07-12', 655667788, 'laura@gmail.com'),
    ('C005', 'Ana', 'López', 'Martín', '34567812E', '1979-12-05', 677889900, 'ana@hotmail.com');

INSERT INTO pedidos (id_pedido, coste_compra_bruto, coste_compra_neto, pago_realizado, devolución, id_cliente, fecha_pedido)
VALUES 
    ('PE01', 7.60, 7.90, 20.00, 12.40, 'C001', '2024-04-01'), -- Pedido 1
    ('PE02', 9.50, 9.88, 12.00, 2.50, 'C002', '2024-03-28'), -- Pedido 2
    ('PE03', 211.99, 255.47, 300.00, 88.01, 'C003', '2024-03-25'), -- Pedido 3
    ('PE04', 299.94, 361.52, 400.00, 38.48, 'C004', '2024-03-20'); -- Pedido 4

INSERT INTO incluir (id_pedido, linea_pedido, id_producto, qty_prod_pedido) VALUES
    ('PE01', 1, '1', 5),  -- Pedido P001: Leche
    ('PE01', 2, '2', 3),  -- Pedido P001: Pan
    ('PE02', 1, '3', 10), -- Pedido P002: Manzana
    ('PE02', 2, '4', 2),  -- Pedido P002: Pollo
    ('PE03', 1, '5', 8),  -- Pedido P003: Arroz
    ('PE03', 2, '6', 1),  -- Pedido P003: Televisor
    ('PE04', 1, '7', 4),  -- Pedido P004: Zapatillas deportivas
    ('PE04', 2, '8', 2);  -- Pedido P004: Mesa de comedor




