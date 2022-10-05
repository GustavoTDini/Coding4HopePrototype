-- Gerado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   em:        2022-10-04 18:29:59 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_c4h_assinatura (
                                  id_assinatura            VARCHAR(40) NOT NULL,
                                  vl_doacao                FLOAT(21),
                                  nr_dia_doacao            NUMBER(2),
                                  dt_inicio                DATE,
                                  dt_fim                   DATE,
                                  t_c4h_usuario_id_usuario VARCHAR(40) NOT NULL
);

CREATE UNIQUE INDEX t_c4h_assinatura__idx ON
    t_c4h_assinatura (
                      t_c4h_usuario_id_usuario
                      ASC );

ALTER TABLE t_c4h_assinatura ADD CONSTRAINT t_c4h_assinatura_pk PRIMARY KEY ( id_assinatura );

CREATE TABLE t_c4h_blog_entry (
                                  id_blog                  VARCHAR(40) NOT NULL,
                                  nm_titulo                VARCHAR2(100),
                                  vl_url_imagem            VARCHAR2(100),
                                  tx_conteudo              CLOB,
                                  st_mostra                CHAR(1),
                                  dt_publicacao            DATE,
                                  t_c4h_usuario_id_usuario VARCHAR(40) NOT NULL
);

CREATE UNIQUE INDEX t_c4h_blog_entry__idx ON
    t_c4h_blog_entry (
                      t_c4h_usuario_id_usuario
                      ASC );

ALTER TABLE t_c4h_blog_entry ADD CONSTRAINT t_c4h_blog_entry_pk PRIMARY KEY ( id_blog );

CREATE TABLE t_c4h_doacao (
                              id_doacao                VARCHAR(40) NOT NULL,
                              dt_data_doacao           DATE,
                              vl_doacao                FLOAT(21),
                              t_c4h_usuario_id_usuario VARCHAR(40) NOT NULL
);

CREATE UNIQUE INDEX t_c4h_doacao__idx ON
    t_c4h_doacao (
                  t_c4h_usuario_id_usuario
                  ASC );

ALTER TABLE t_c4h_doacao ADD CONSTRAINT t_c4h_doacao_pk PRIMARY KEY ( id_doacao );

CREATE TABLE t_c4h_logradouro (
                                  id_logradouro            VARCHAR(40) NOT NULL,
                                  nm_tipo                  VARCHAR2(20),
                                  nm_logradouro            VARCHAR2(150),
                                  nr_logradouro            NUMBER(6),
                                  nr_cep                   NUMBER(8),
                                  vl_complemento           VARCHAR2(30),
                                  nm_bairro                VARCHAR2(100),
                                  nm_cidade                VARCHAR2(100),
                                  nm_estado                VARCHAR2(2),
                                  t_c4h_usuario_id_usuario VARCHAR(40) NOT NULL
);

ALTER TABLE t_c4h_logradouro ADD CONSTRAINT t_c4h_logradouro_pk PRIMARY KEY ( id_logradouro,
                                                                              t_c4h_usuario_id_usuario );

CREATE TABLE t_c4h_noticia (
                               id_noticia               VARCHAR(40) NOT NULL,
                               nm_titulo                VARCHAR2(100),
                               dt_publicado             DATE,
                               tx_conteudo              CLOB,
                               st_mostra                CHAR(1),
                               st_destaque              CHAR(1),
                               t_c4h_usuario_id_usuario VARCHAR(40) NOT NULL
);

CREATE UNIQUE INDEX t_c4h_noticia__idx ON
    t_c4h_noticia (
                   t_c4h_usuario_id_usuario
                   ASC );

ALTER TABLE t_c4h_noticia ADD CONSTRAINT t_c4h_noticia_pk PRIMARY KEY ( id_noticia );

CREATE TABLE t_c4h_telefone (
                                id_telefone              VARCHAR(40) NOT NULL,
                                nr_telefone              NUMBER(12),
                                nr_ddd                   NUMBER(3),
                                t_c4h_usuario_id_usuario VARCHAR(40) NOT NULL
);

ALTER TABLE t_c4h_telefone ADD CONSTRAINT t_c4h_telefone_pk PRIMARY KEY ( id_telefone,
                                                                          t_c4h_usuario_id_usuario );

CREATE TABLE t_c4h_usuario (
                               id_usuario      VARCHAR(40) NOT NULL,
                               nm_login        VARCHAR2(30) NOT NULL,
                               nm_email        VARCHAR2(100),
                               vl_senha        VARCHAR2(100) NOT NULL,
                               st_admin        CHAR(1),
                               st_doador       CHAR(1),
                               nm_razao_social VARCHAR2(100),
                               nm_nome         VARCHAR2(100),
                               vl_cpf          NUMBER(11),
                               vl_cnpj         VARCHAR2(14),
                               dt_nascimento   DATE,
                               vl_url          VARCHAR2(100)
);

ALTER TABLE t_c4h_usuario ADD CONSTRAINT t_c4h_usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE t_c4h_assinatura
    ADD CONSTRAINT assinatura_usuario_fk FOREIGN KEY ( t_c4h_usuario_id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_blog_entry
    ADD CONSTRAINT blog_entry_usuario_fk FOREIGN KEY ( t_c4h_usuario_id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_doacao
    ADD CONSTRAINT doacao_usuario_fk FOREIGN KEY ( t_c4h_usuario_id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_logradouro
    ADD CONSTRAINT logradouro_usuario_fk FOREIGN KEY ( t_c4h_usuario_id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_noticia
    ADD CONSTRAINT noticia_usuario_fk FOREIGN KEY ( t_c4h_usuario_id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_telefone
    ADD CONSTRAINT telefone_usuario_fk FOREIGN KEY ( t_c4h_usuario_id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler:
--
-- CREATE TABLE                             7
-- CREATE INDEX                             4
-- ALTER TABLE                             13
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
-- ERRORS                                   0
-- WARNINGS                                 0