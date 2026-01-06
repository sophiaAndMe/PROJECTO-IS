
-- Insertamos con comillas simples porque mesa_id es String (character varying)
INSERT INTO mesas (mesa_id, numero_mesa, capacidad_mesa, ubicacion, estado) VALUES ('m1', 1, 2, 'Terraza', 'DISPONIBLE');
INSERT INTO mesas (mesa_id, numero_mesa, capacidad_mesa, ubicacion, estado) VALUES ('m2', 2, 4, 'Interior', 'DISPONIBLE');
INSERT INTO mesas (mesa_id, numero_mesa, capacidad_mesa, ubicacion, estado) VALUES ('m3', 3, 6, 'VIP', 'DISPONIBLE');

-- También para el administrador si su ID es String
INSERT INTO administradores (id, nombre_usuario, password) VALUES ('admin1', 'admin_luis', 'password123');