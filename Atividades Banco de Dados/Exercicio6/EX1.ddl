-- Gerado por Oracle SQL Developer Data Modeler 21.4.2.059.0838
--   em:        2022-07-01 21:05:19 GMT-03:00
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE departamento (
    numero NUMBER(5) NOT NULL,
    nome   VARCHAR2(55) NOT NULL
);

ALTER TABLE departamento ADD CONSTRAINT departamento_pk PRIMARY KEY ( numero,
                                                                      nome );

CREATE TABLE dependente (
    nome            VARCHAR2(55) NOT NULL,
    sexo            VARCHAR2(1),
    parentesco      VARCHAR2(55),
    data_nascimento DATE,
    cpf_funcionario NUMBER(11) NOT NULL
);

ALTER TABLE dependente ADD CONSTRAINT dependente_pk PRIMARY KEY ( nome,
                                                                  cpf_funcionario );

CREATE TABLE funcionario (
    cpf             NUMBER(11) NOT NULL,
    data_nascimento DATE,
    endereco        VARCHAR2(55),
    salario         NUMBER(8, 2),
    sexo            VARCHAR2(1),
    supervisor      NUMBER(11),
    ultimo_nome     VARCHAR2(20) NOT NULL,
    nome_meio       VARCHAR2(20) NOT NULL,
    primeir_nome    VARCHAR2(20) NOT NULL
);

ALTER TABLE funcionario ADD CONSTRAINT funcionario_pk PRIMARY KEY ( cpf );

CREATE TABLE gerencia (
    data_inicio unknown 
--  ERROR: Datatype UNKNOWN is not allowed 
    ,
    cpf_gerente NUMBER(11) NOT NULL,
    numero_dept NUMBER(5) NOT NULL,
    nome_dept   VARCHAR2(55) NOT NULL
);

CREATE TABLE localizacoes (
    endereco    VARCHAR2(55) NOT NULL,
    numero_dept NUMBER(5) NOT NULL,
    nome_dept   VARCHAR2(55) NOT NULL
);

ALTER TABLE localizacoes ADD CONSTRAINT localizacoes_pk PRIMARY KEY ( endereco );

CREATE TABLE nome (
    primerio VARCHAR2(20) NOT NULL,
    meio     VARCHAR2(20) NOT NULL,
    ultimo   VARCHAR2(20) NOT NULL
);

ALTER TABLE nome
    ADD CONSTRAINT table_9_pk PRIMARY KEY ( ultimo,
                                            meio,
                                            primerio );

CREATE TABLE projeto (
    nome        VARCHAR2 
--  ERROR: VARCHAR2 size not specified 
     NOT NULL,
    numero      VARCHAR2 
--  ERROR: VARCHAR2 size not specified 
     NOT NULL,
    localizacao VARCHAR2 
--  ERROR: VARCHAR2 size not specified 

);

ALTER TABLE projeto ADD CONSTRAINT projeto_pk PRIMARY KEY ( nome,
                                                            numero );

CREATE TABLE trabalha_em (
    cpf_funcionario NUMBER(11) NOT NULL,
    nome_projeto    VARCHAR2 
--  ERROR: VARCHAR2 size not specified 
     NOT NULL,
    numero_projeto  VARCHAR2 
--  ERROR: VARCHAR2 size not specified 
     NOT NULL
);

ALTER TABLE dependente
    ADD CONSTRAINT dependente_funcionario_fk FOREIGN KEY ( cpf_funcionario )
        REFERENCES funcionario ( cpf );

ALTER TABLE funcionario
    ADD CONSTRAINT funcionario_funcionario_fk FOREIGN KEY ( supervisor )
        REFERENCES funcionario ( cpf );

ALTER TABLE funcionario
    ADD CONSTRAINT funcionario_nome_fk FOREIGN KEY ( ultimo_nome,
                                                     nome_meio,
                                                     primeir_nome )
        REFERENCES nome ( ultimo,
                          meio,
                          primerio );

ALTER TABLE gerencia
    ADD CONSTRAINT gerencia_departamento_fk FOREIGN KEY ( numero_dept,
                                                          nome_dept )
        REFERENCES departamento ( numero,
                                  nome );

ALTER TABLE gerencia
    ADD CONSTRAINT gerencia_funcionario_fk FOREIGN KEY ( cpf_gerente )
        REFERENCES funcionario ( cpf );

ALTER TABLE localizacoes
    ADD CONSTRAINT localizacoes_departamento_fk FOREIGN KEY ( numero_dept,
                                                              nome_dept )
        REFERENCES departamento ( numero,
                                  nome );

ALTER TABLE trabalha_em
    ADD CONSTRAINT trabalha_em_funcionario_fk FOREIGN KEY ( cpf_funcionario )
        REFERENCES funcionario ( cpf );

ALTER TABLE trabalha_em
    ADD CONSTRAINT trabalha_em_projeto_fk FOREIGN KEY ( nome_projeto,
                                                        numero_projeto )
        REFERENCES projeto ( nome,
                             numero );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             0
-- ALTER TABLE                             14
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
-- ERRORS                                   6
-- WARNINGS                                 0
