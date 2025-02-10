CREATE DATABASE IF NOT EXISTS tienda_de_zapatillas;

USE tienda_de_zapatillas;
CREATE TABLE usuarios (
                          id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          nombre_usuario VARCHAR(100) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          telefono VARCHAR(9)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de Clientes
CREATE TABLE clientes (
                          id_cliente INT AUTO_INCREMENT PRIMARY KEY,
                          nombre_apellido VARCHAR(100) NOT NULL,
                          telefono VARCHAR(9)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de Inventario de Zapatillas
CREATE TABLE inventario (
                            id_inventario INT AUTO_INCREMENT PRIMARY KEY,
                            marca VARCHAR(100) NOT NULL,
                            talla INT NOT NULL,
                            codigo VARCHAR(20) NOT NULL,
                            descripcion TEXT,
                            color VARCHAR(50),
                            precio_compra DECIMAL(10,2) NOT NULL,
                            precio_venta DECIMAL(10,2) NOT NULL,
                            stock INT NOT NULL DEFAULT  0,
                            estado ENUM('activo','inactivo') DEFAULT 'activo' NOT NULL ,
                            fecha_entrada TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de Ventas
CREATE TABLE ventas (
                        id_venta INT AUTO_INCREMENT PRIMARY KEY,
                        id_cliente INT,
                        fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        total_venta DECIMAL(10,2) NOT NULL,
                        metodo_pago VARCHAR(50) NOT NULL,
                        FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de Detalles de Venta (líneas de venta)
CREATE TABLE detalle_ventas (
                                id_detalle_venta INT AUTO_INCREMENT PRIMARY KEY,
                                id_venta INT,
                                id_inventario INT,
                                cantidad INT NOT NULL,
                                precio_unitario DECIMAL(10,2) NOT NULL,
                                subtotal DECIMAL(10,2) NOT NULL,
                                FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
                                FOREIGN KEY (id_inventario) REFERENCES inventario(id_inventario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE carrito (
                         id_carrito INT AUTO_INCREMENT PRIMARY KEY,
                         id_cliente INT NOT NULL,
                         id_inventario INT NOT NULL,
                         cantidad INT NOT NULL,
                         precio_unitario DECIMAL(10,2),
                         subtotal DECIMAL(10,2),
                         FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
                         FOREIGN KEY (id_inventario) REFERENCES inventario(id_inventario)

)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO usuarios(nombre , nombre_usuario ,telefono ,  password) VALUES('Richard Aguilar Bendezu Kofi' , 'Usuario' ,'969104924','$2a$10$DRcWZfDGH2q3CIOAHT1gte56c5xYyiBWqXHuUrjxGiL6yY3L4b9N6');

DELIMITER $$
CREATE PROCEDURE confirmar_venta(IN p_id_cliente INT, IN p_metodo_pago VARCHAR(50))
BEGIN
    DECLARE v_total DECIMAL(10,2);

    -- Crear la venta
    INSERT INTO ventas (id_cliente, metodo_pago, total_venta)
    VALUES (p_id_cliente, p_metodo_pago, 0);

    -- Obtener el ID de la venta recién creada
    SET @id_venta = LAST_INSERT_ID();

    -- Insertar los detalles desde el carrito
    INSERT INTO detalle_ventas (id_venta, id_inventario, cantidad, precio_unitario, subtotal)
    SELECT @id_venta, id_inventario, cantidad, precio_unitario, subtotal
    FROM carrito
    WHERE id_cliente = p_id_cliente;

    -- Actualizar el stock en inventario
    UPDATE inventario i
        JOIN carrito c ON i.id_inventario = c.id_inventario
    SET i.stock = i.stock - c.cantidad  , i.estado = CASE WHEN i.stock - c.cantidad = 0 THEN 'inactivo' ELSE i.estado END
    WHERE c.id_cliente = p_id_cliente;

    -- Calcular el total de la venta
    SELECT SUM(subtotal) INTO v_total
    FROM detalle_ventas
    WHERE id_venta = @id_venta;

    -- Actualizar el total en la tabla ventas
    UPDATE ventas
    SET total_venta = v_total
    WHERE id_venta = @id_venta;

    -- Limpiar el carrito del cliente
    DELETE FROM carrito WHERE id_cliente = p_id_cliente;
END$$

DELIMITER $$;