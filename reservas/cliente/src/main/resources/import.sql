
-- Insertamos con comillas simples porque mesa_id es String (character varying)
INSERT INTO mesas (mesa_id, numero_mesa, capacidad_mesa, ubicacion) VALUES ('m1', 1, 2, 'Terraza');
INSERT INTO mesas (mesa_id, numero_mesa, capacidad_mesa, ubicacion) VALUES ('m2', 2, 4, 'Interior');
INSERT INTO mesas (mesa_id, numero_mesa, capacidad_mesa, ubicacion) VALUES ('m3', 3, 6, 'VIP');

-- También para el administrador si su ID es String
INSERT INTO administradores (id, nombre_usuario, password) VALUES ('admin1', 'admin_luis', 'password123');