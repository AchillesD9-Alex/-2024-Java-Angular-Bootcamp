
-- ACTUALIZACIÓN / UPDATE -----------------------------
-- 1) Modificar el precio del producto 10
UPDATE productos
SET bruto_prod = 49.99, neto_prod = 60.49
WHERE id_producto = '10';

-- 2) Actualizar el precio del producto 10 en la factura D, línea 3
UPDATE facturas
SET coste_prod_suministro = 399.92
WHERE id_factura = 'D' AND linea_factura = 3;

-- 3) Cambiar el apellido 1 de C001 a "López"
UPDATE clientes
SET apel1 = 'López'
WHERE id_cliente = 'C001';

-- ELIMINACIÓN / DELETE -----------------------------
-- 1) Eliminar el cliente número 5
DELETE FROM clientes
WHERE id_cliente = 'C005';

-- 2) Eliminar el proveedor número 4
DELETE FROM proveedores
WHERE id_proveedor = 4;

-- 3) Eliminar el proveedor número 5
DELETE FROM proveedores
WHERE id_proveedor = 5;

-- BÚSQUEDA / SELECT -----------------------------
-- 1) Obtener todos los pedidos que contienen productos esenciales con su nombre
SELECT pedidos.id_pedido, productos.nom_prod
FROM pedidos
JOIN incluir ON pedidos.id_pedido = incluir.id_pedido
JOIN productos ON incluir.id_producto = productos.id_producto
WHERE productos.tipo_prod = 'E';


-- 2) Buscar todas las facturas en las que el proveedor A ha participado
SELECT facturas.id_factura, facturas.descripcion
FROM facturas
JOIN suministrar ON facturas.id_factura = suministrar.id_factura
JOIN proveedores ON suministrar.id_proveedor = proveedores.id_proveedor
WHERE proveedores.nombre_proveedor = 'Distribuidora Alfa';

-- 3) Verificar si el cliente C001 ha realizado algún pedido y contarlos
SELECT id_cliente, COUNT(*) AS total_compras
FROM pedidos
WHERE id_cliente = 'C001';