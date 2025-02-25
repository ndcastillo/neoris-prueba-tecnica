CREATE SEQUENCE IF NOT EXISTS cliente_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS movimiento_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE cliente
(
    cliente_id     BIGINT  NOT NULL,
    id             BIGINT,
    nombre         VARCHAR(255),
    genero         VARCHAR(255),
    edad           INTEGER NOT NULL,
    identificacion VARCHAR(255),
    direccion      VARCHAR(255),
    telefono       VARCHAR(255),
    contrasena     VARCHAR(255),
    estado         BOOLEAN NOT NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (cliente_id)
);

CREATE TABLE cuenta
(
    numero_cuenta BIGINT           NOT NULL,
    tipo_cuenta   VARCHAR(255),
    saldo         DOUBLE PRECISION NOT NULL,
    estado        BOOLEAN          NOT NULL,
    cliente_id    BIGINT,
    CONSTRAINT pk_cuenta PRIMARY KEY (numero_cuenta)
);

CREATE TABLE movimiento
(
    movimiento_id   BIGINT           NOT NULL,
    fecha           TIMESTAMP WITHOUT TIME ZONE,
    tipo_movimiento VARCHAR(255),
    valor           DOUBLE PRECISION NOT NULL,
    saldo           DOUBLE PRECISION NOT NULL,
    numero_cuenta   BIGINT,
    CONSTRAINT pk_movimiento PRIMARY KEY (movimiento_id)
);