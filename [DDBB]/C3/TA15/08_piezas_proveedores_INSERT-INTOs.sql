INSERT INTO piezas (nombre) VALUES
('tornillo'),('muelle'),('rosca'),('tope'),('abrazadera'),('brida'),('tuerca'),('perno'),('ya no se cual mas poner'),('esta tambien me la invento');

INSERT INTO proveedores (id_proveedor, nombre) VALUES
('1000', 'LeroyMerlin'), ('2000', 'BauHaus'), ('3000', 'Carrefour'), ('4000', 'IKEA'), ('5000', 'CasaPacoSL'), ('6000', 'CasamariaSA'),
('7000', 'InventoNamberJuan'), ('8000', '2Good2Go'), ('9000', 'ElCorteIngles'), ('0000', 'MercadilloTorreforta');

--Inicial prueba 

INSERT INTO suministra (cod_pieza, id_proveedor, precio) VALUES
(1, '1000', 2),
(2, '2000', 3),
(3, '3000', 1),
(4, '4000', 2), 
(5, '5000', 3), 
(6, '6000', 4), 
(7, '7000', 5),
(8, '8000', 4),
(9, '9000', 1),
(10, '0000', 2);
