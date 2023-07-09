-- Datos para poblar la tabla producto:

INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 1', 'REF001', 10.99, 0.5, 'Electrónica', 50, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 2', 'REF002', 19.99, 1.2, 'Ropa', 20, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 3', 'REF003', 15.50, 0.8, 'Hogar', 30, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 4', 'REF004', 25.99, 1.5, 'Juguetes', 15, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 5', 'REF005', 9.99, 0.3, 'Alimentos', 100, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 6', 'REF006', 12.75, 0.6, 'Electrodomésticos', 50, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 7', 'REF007', 29.99, 1.8, 'Muebles', 10, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 8', 'REF008', 8.50, 0.4, 'Moda', 80, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 9', 'REF009', 18.49, 1.1, 'Deportes', 25, '2023-07-06');
INSERT INTO producto (nombre, referencia, precio, peso, categoria, stock, fecha_creacion)
VALUES ('Producto 10', 'REF010', 7.99, 0.2, 'Salud y Belleza', 60, '2023-07-06');

-- Datos para poblar la tabla venta:

INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 1', 'REF-001', 10.99, 0.5, 1);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 2', 'REF-002', 19.99, 1.2, 2);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 3', 'REF-003', 15.50, 0.8, 3);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 4', 'REF-004', 25.99, 1.5, 4);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 5', 'REF-005', 9.99, 0.3, 5);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 6', 'REF-006', 12.75, 0.6, 6);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 7', 'REF-007', 29.99, 1.8, 7);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 8', 'REF-008', 8.50, 0.4, 8);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 9', 'REF-009', 18.49, 1.1, 9);
INSERT INTO venta (nombre, referencia, precio, peso, producto_id) VALUES ('Producto 10', 'REF-010', 7.99, 0.2, 10);

-- Consultar todos los productos de las tablas producto y venta

select * from producto;
select * from venta;

SELECT p.*
FROM producto p
INNER JOIN venta v ON p.id = v.producto_id
GROUP BY p.id
ORDER BY COUNT(v.id) DESC
LIMIT 1;

-- Realizar una consulta que permita conocer cuál es el producto que más stock tiene:

SELECT * FROM producto p WHERE p.stock = (SELECT MAX(p2.stock) FROM producto p2) LIMIT 1;

SELECT p.*
FROM producto p
INNER JOIN venta v ON p.id = v.producto_id
GROUP BY p.id
ORDER BY COUNT(v.id) DESC
LIMIT 1;

-- Realizar una consulta que permita conocer cuál es el producto más vendido:

SELECT nombre AS Nombre_Producto, COUNT(*) AS Cantidad FROM venta GROUP BY nombre;

SELECT p.*
FROM producto p
WHERE p.id = (
  SELECT producto_id
  FROM venta
  GROUP BY producto_id
  ORDER BY COUNT(*) DESC
  LIMIT 1
);

-- Borrrar tablas producto y venta

drop table producto;
drop table venta;