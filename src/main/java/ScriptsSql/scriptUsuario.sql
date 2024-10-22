
-- Crear la base de datos transicionEnergeticaJusta
CREATE DATABASE transicionEnergeticaJusta;


-- Usar la base de datos
USE transicionEnergeticaJusta;

-- Crear tabla ROL
CREATE TABLE ROL (
    ID SERIAL PRIMARY KEY,
    NOMBRE VARCHAR(50) NOT NULL UNIQUE
);

-- Crear tabla USUARIO
CREATE TABLE USUARIO (
    ID SERIAL PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(150) NOT NULL UNIQUE,
    CONTRASENIA VARCHAR(255) NOT NULL,
    ROL_ID INT,
    FOREIGN KEY (ROL_ID) REFERENCES ROL(ID)  -- Clave foránea
);

-- Insertar algunos roles de ejemplo
INSERT INTO ROL (NOMBRE)
VALUES 
('Admin'),
('Usuario'),
('Moderador');

-- Insertar usuarios con roles y correos electrónicos diferentes
INSERT INTO USUARIO (NOMBRE, EMAIL, CONTRASENIA, ROL_ID)
VALUES 
('Juan Perez', 'juan.perez123@example.com', 'password123', 1),  
('Maria Lopez', 'maria.lopez456@example.com', 'pass456789', 2),  
('Carlos Sanchez', 'carlos.sanchez789@example.com', 'secretpass789', 3),  
('Ana Gómez', 'ana.gomez101@example.com', 'ana1234', 2),         
('Luis Martínez', 'luis.martinez202@example.com', 'luis5678', 3), 
('Natalia Cordero', 'natalia.cordero303@example.com', 'nat4567', 2),  
('Pedro Jiménez', 'pedro.jimenez404@example.com', 'pedro9876', 1);


SELECT 
    u.id, 
    u.nombre, 
    u.email, 
    r.nombre AS rol 
FROM 
    usuario u 
JOIN 
    rol r ON u.rol_id = r.id;


