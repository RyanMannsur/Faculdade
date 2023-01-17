-- Gerado por Oracle SQL Developer Data Modeler 21.4.2.059.0838
--   em:        2022-07-01 21:16:47 GMT-03:00
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE agencia (
    endereco     VARCHAR2(55),
    num_agencia  VARCHAR2(5) NOT NULL,
    codigo_banco NUMBER(5) NOT NULL
);

ALTER TABLE agencia ADD CONSTRAINT agencia_pk PRIMARY KEY ( num_agencia,
                                                            codigo_banco );

CREATE TABLE banco (
    codigo   NUMBER(5) NOT NULL,
    nome     VARCHAR2(55),
    endereco VARCHAR2(55)
);

ALTER TABLE banco ADD CONSTRAINT banco_pk PRIMARY KEY ( codigo );

CREATE TABLE cliente (
    ssn      NUMBER(7) NOT NULL,
    nome     VARCHAR2(55),
    endereco VARCHAR2(55),
    telefone VARCHAR2(15)
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( ssn );

CREATE TABLE conta (
    numero               NUMBER(5) NOT NULL,
    saldo                NUMBER(10, 2),
    tipo                 VARCHAR2(10),
    agencia_num_agencia  VARCHAR2(5) NOT NULL,
    agencia_codigo_banco NUMBER(5) NOT NULL
);

ALTER TABLE conta ADD CONSTRAINT conta_pk PRIMARY KEY ( numero );

CREATE TABLE conta_cliente (
    numero_conta NUMBER(5) NOT NULL,
    ssn_cliente  NUMBER(7) NOT NULL
);

CREATE TABLE emprestimo (
    num_emprestimo       NUMBER(4) NOT NULL,
    tipo                 VARCHAR2(10),
    valor                NUMBER(10, 2),
    agencia_num_agencia  VARCHAR2(5) NOT NULL,
    agencia_codigo_banco NUMBER(5) NOT NULL
);

ALTER TABLE emprestimo ADD CONSTRAINT emprestimo_pk PRIMARY KEY ( num_emprestimo );

CREATE TABLE emprestimo_cliente (
    ssn_client     NUMBER(7) NOT NULL,
    num_emprestimo NUMBER(4) NOT NULL
);

ALTER TABLE agencia
    ADD CONSTRAINT agencia_banco_fk FOREIGN KEY ( codigo_banco )
        REFERENCES banco ( codigo );

ALTER TABLE conta
    ADD CONSTRAINT conta_agencia_fk FOREIGN KEY ( agencia_num_agencia,
                                                  agencia_codigo_banco )
        REFERENCES agencia ( num_agencia,
                             codigo_banco );

ALTER TABLE conta_cliente
    ADD CONSTRAINT conta_cliente_cliente_fk FOREIGN KEY ( ssn_cliente )
        REFERENCES cliente ( ssn );

ALTER TABLE conta_cliente
    ADD CONSTRAINT conta_cliente_conta_fk FOREIGN KEY ( numero_conta )
        REFERENCES conta ( numero );

ALTER TABLE emprestimo
    ADD CONSTRAINT emprestimo_agencia_fk FOREIGN KEY ( agencia_num_agencia,
                                                       agencia_codigo_banco )
        REFERENCES agencia ( num_agencia,
                             codigo_banco );

ALTER TABLE emprestimo_cliente
    ADD CONSTRAINT emprestimo_cliente_cliente_fk FOREIGN KEY ( ssn_client )
        REFERENCES cliente ( ssn );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE emprestimo_cliente
    ADD CONSTRAINT emprestimo_cliente_emprestimo_fk FOREIGN KEY ( num_emprestimo )
        REFERENCES emprestimo ( num_emprestimo );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             0
-- ALTER TABLE                             12
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0
