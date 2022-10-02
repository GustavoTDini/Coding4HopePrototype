-- Gerado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   em:        2022-10-01 23:48:50 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE c4h_bairro (
    id_bairro CHAR(36) NOT NULL,
    nm_bairro VARCHAR2(150),
    id_cidade CHAR(36) NOT NULL,
    id_estado CHAR(36) NOT NULL
);

ALTER TABLE c4h_bairro
    ADD CONSTRAINT c4h_bairro_pk PRIMARY KEY ( id_bairro,
                                               id_cidade,
                                               id_estado );

CREATE TABLE t_c4h_admin (
    dt_inicio  DATE,
    dt_fim     DATE,
    id_usuario CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_admin ADD CONSTRAINT t_c4h_admin_pk PRIMARY KEY ( id_usuario );

CREATE TABLE t_c4h_assinatura (
    id_assinatura CHAR(36) NOT NULL,
    vl_doacao     FLOAT(21),
    nr_dia_doacao NUMBER(2),
    dt_inicio     DATE,
    dt_fim        DATE,
    id_usuario    CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_assinatura ADD CONSTRAINT t_c4h_assinatura_pk PRIMARY KEY ( id_assinatura,
                                                                              id_usuario );

CREATE TABLE t_c4h_blog_entry (
    id_blog       CHAR(36) NOT NULL,
    nm_titulo     VARCHAR2(100),
    vl_url_imagem VARCHAR2(100),
    tx_conteudo   CLOB,
    st_mostra     CHAR(1),
    id_usuario    CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_blog_entry ADD CONSTRAINT t_c4h_blog_entry_pk PRIMARY KEY ( id_blog,
                                                                              id_usuario );

CREATE TABLE t_c4h_cadastro_logradouro (
    id_cadastro_logradouro CHAR(36) NOT NULL,
    dt_inicio              DATE,
    dt_fim                 DATE,
    st_ativo               CHAR(1),
    id_usuario             CHAR(36) NOT NULL,
    id_logradouro          CHAR(36) NOT NULL,
    id_bairro              CHAR(36) NOT NULL,
    id_cidade              CHAR(36) NOT NULL,
    id_estado              CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_cadastro_logradouro ADD CONSTRAINT t_c4h_cadastro_logradouro_pk PRIMARY KEY ( id_cadastro_logradouro );

CREATE TABLE t_c4h_cadastro_pf (
    nm_razao_social VARCHAR2(100),
    dt_nascimento   DATE,
    vl_url          VARCHAR2(100),
    vl_cpf          NUMBER(11),
    id_usuario      CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_cadastro_pf ADD CONSTRAINT t_c4h_cadastro_pf_pk PRIMARY KEY ( id_usuario );

CREATE TABLE t_c4h_cadastro_pj (
    nm_empresa VARCHAR2(100),
    vl_url     VARCHAR2(100),
    vl_cnpj    NUMBER(14),
    id_usuario CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_cadastro_pj ADD CONSTRAINT t_c4h_cadastro_pj_pk PRIMARY KEY ( id_usuario );

CREATE TABLE t_c4h_cadastro_rede_social (
    id_cadastro_rede   CHAR(36) NOT NULL,
    dt_inicio          DATE,
    dt_fim             DATE,
    st_ativo           CHAR(1),
    id_usuario         CHAR(36) NOT NULL,
    id_rede_social_url CHAR(36) NOT NULL,
    id_rede_social     CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_cadastro_rede_social
    ADD CONSTRAINT t_c4h_cadastro_rede_social_pk PRIMARY KEY ( id_cadastro_rede,
                                                               id_rede_social_url,
                                                               id_rede_social );

CREATE TABLE t_c4h_cadastro_telefone (
    id_cadastro_telefone CHAR(36) NOT NULL,
    dt_inicio            DATE,
    dt_fim               DATE,
    st_ativo             CHAR(1),
    id_usuario           CHAR(36) NOT NULL,
    id_telefone          CHAR(36) NOT NULL,
    id_ddd               CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_cadastro_telefone ADD CONSTRAINT t_c4h_cadastro_telefone_pk PRIMARY KEY ( id_cadastro_telefone );

CREATE TABLE t_c4h_cidade (
    id_cidade CHAR(36) NOT NULL,
    nm_cidade VARCHAR2(150),
    id_estado CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_cidade ADD CONSTRAINT t_c4h_cidade_pk PRIMARY KEY ( id_cidade,
                                                                      id_estado );

CREATE TABLE t_c4h_ddd (
    id_ddd CHAR(36) NOT NULL,
    nr_ddd NUMBER(3)
);

ALTER TABLE t_c4h_ddd ADD CONSTRAINT t_c4h_ddd_pk PRIMARY KEY ( id_ddd );

CREATE TABLE t_c4h_doacao (
    id_doacao      CHAR(36) NOT NULL,
    dt_data_doacao DATE,
    vl_doacao      FLOAT(21),
    id_usuario     CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_doacao ADD CONSTRAINT t_c4h_doacao_pk PRIMARY KEY ( id_doacao,
                                                                      id_usuario );

CREATE TABLE t_c4h_doador (
    dt_inicio  DATE,
    dt_fim     DATE,
    id_usuario CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_doador ADD CONSTRAINT t_c4h_doador_pk PRIMARY KEY ( id_usuario );

CREATE TABLE t_c4h_estado (
    id_estado CHAR(36) NOT NULL,
    nm_estado VARCHAR2(50)
);

ALTER TABLE t_c4h_estado ADD CONSTRAINT t_c4h_estado_pk PRIMARY KEY ( id_estado );

CREATE TABLE t_c4h_logradouro (
    id_logradouro  CHAR(36) NOT NULL,
    nm_tipo        VARCHAR2(20),
    nm_logradouro  VARCHAR2(150),
    nr_logradouro  NUMBER(6),
    nr_cep         NUMBER(8),
    vl_complemento VARCHAR2(30),
    id_bairro      CHAR(36) NOT NULL,
    id_cidade      CHAR(36) NOT NULL,
    id_estado      CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_logradouro
    ADD CONSTRAINT t_c4h_logradouro_pk PRIMARY KEY ( id_logradouro,
                                                     id_bairro,
                                                     id_cidade,
                                                     id_estado );

CREATE TABLE t_c4h_noticia (
    id_noticia   CHAR(36) NOT NULL,
    nm_titulo    VARCHAR2(100),
    dt_publicado DATE,
    tx_conteudo  CLOB,
    st_mostra    CHAR(1),
    st_destaque  CHAR(1),
    id_usuario   CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_noticia ADD CONSTRAINT t_c4h_noticia_pk PRIMARY KEY ( id_noticia,
                                                                        id_usuario );

CREATE TABLE t_c4h_rede_social (
    id_rede_social CHAR(36) NOT NULL,
    nm_rede_social VARCHAR2(10),
    im_logo        BLOB
);

ALTER TABLE t_c4h_rede_social ADD CONSTRAINT t_c4h_rede_social_pk PRIMARY KEY ( id_rede_social );

CREATE TABLE t_c4h_rede_social_url (
    id_rede_social_url CHAR(36) NOT NULL,
    vl_rede_social_url VARCHAR2(100),
    id_rede_social     CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_rede_social_url ADD CONSTRAINT t_c4h_rede_social_url_pk PRIMARY KEY ( id_rede_social_url,
                                                                                        id_rede_social );

CREATE TABLE t_c4h_telefone (
    id_telefone      CHAR(36) NOT NULL,
    nr_telefone      NUMBER(12),
    t_c4h_ddd_id_ddd CHAR(36) NOT NULL
);

ALTER TABLE t_c4h_telefone ADD CONSTRAINT t_c4h_telefone_pk PRIMARY KEY ( id_telefone,
                                                                          t_c4h_ddd_id_ddd );

CREATE TABLE t_c4h_usuario (
    id_usuario CHAR(36) NOT NULL,
    nm_login   VARCHAR2(30) NOT NULL,
    nm_email   VARCHAR2(100),
    vl_senha   VARCHAR2(100) NOT NULL,
    st_admin   CHAR(1),
    st_doador  CHAR(1)
);

ALTER TABLE t_c4h_usuario ADD CONSTRAINT t_c4h_usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE t_c4h_admin
    ADD CONSTRAINT c4h_admin_pf_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_cadastro_pf ( id_usuario );

ALTER TABLE t_c4h_assinatura
    ADD CONSTRAINT c4h_assinatura_doador_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_doador ( id_usuario );

ALTER TABLE c4h_bairro
    ADD CONSTRAINT c4h_bairro_t_c4h_cidade_fk FOREIGN KEY ( id_cidade,
                                                            id_estado )
        REFERENCES t_c4h_cidade ( id_cidade,
                                  id_estado );

ALTER TABLE t_c4h_blog_entry
    ADD CONSTRAINT c4h_blog_entry_admin_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_admin ( id_usuario );

ALTER TABLE t_c4h_cadastro_logradouro
    ADD CONSTRAINT c4h_cad_log_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_cadastro_logradouro
    ADD CONSTRAINT c4h_cad_logradouro_fk FOREIGN KEY ( id_logradouro,
                                                       id_bairro,
                                                       id_cidade,
                                                       id_estado )
        REFERENCES t_c4h_logradouro ( id_logradouro,
                                      id_bairro,
                                      id_cidade,
                                      id_estado );

ALTER TABLE t_c4h_cadastro_pf
    ADD CONSTRAINT c4h_cad_pf_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_cadastro_pj
    ADD CONSTRAINT c4h_cad_pj_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_cadastro_rede_social
    ADD CONSTRAINT c4h_cad_rede_social_fk FOREIGN KEY ( id_rede_social_url,
                                                        id_rede_social )
        REFERENCES t_c4h_rede_social_url ( id_rede_social_url,
                                           id_rede_social );

ALTER TABLE t_c4h_cadastro_rede_social
    ADD CONSTRAINT c4h_cad_rede_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_cadastro_telefone
    ADD CONSTRAINT c4h_cad_tel_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_cadastro_telefone
    ADD CONSTRAINT c4h_cad_telefone_fk FOREIGN KEY ( id_telefone,
                                                     id_ddd )
        REFERENCES t_c4h_telefone ( id_telefone,
                                    t_c4h_ddd_id_ddd );

ALTER TABLE t_c4h_doacao
    ADD CONSTRAINT c4h_doacao_doador_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_doador ( id_usuario );

ALTER TABLE t_c4h_doador
    ADD CONSTRAINT c4h_doador_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_usuario ( id_usuario );

ALTER TABLE t_c4h_logradouro
    ADD CONSTRAINT c4h_logradouro_bairro_fk FOREIGN KEY ( id_bairro,
                                                          id_cidade,
                                                          id_estado )
        REFERENCES c4h_bairro ( id_bairro,
                                id_cidade,
                                id_estado );

ALTER TABLE t_c4h_noticia
    ADD CONSTRAINT c4h_noticia_admin_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_c4h_admin ( id_usuario );

ALTER TABLE t_c4h_rede_social_url
    ADD CONSTRAINT c4h_rede_url_rede_fk FOREIGN KEY ( id_rede_social )
        REFERENCES t_c4h_rede_social ( id_rede_social );

ALTER TABLE t_c4h_cidade
    ADD CONSTRAINT t_c4h_cidade_t_c4h_estado_fk FOREIGN KEY ( id_estado )
        REFERENCES t_c4h_estado ( id_estado );

ALTER TABLE t_c4h_telefone
    ADD CONSTRAINT t_c4h_telefone_t_c4h_ddd_fk FOREIGN KEY ( t_c4h_ddd_id_ddd )
        REFERENCES t_c4h_ddd ( id_ddd );

CREATE OR REPLACE TRIGGER arc_c4h_arco_t_c4h_cadastro_pf BEFORE
    INSERT OR UPDATE OF id_usuario ON t_c4h_cadastro_pf
    FOR EACH ROW
DECLARE
    d CHAR(36);
BEGIN
    SELECT
        a.id_usuario
    INTO d
    FROM
        t_c4h_usuario a
    WHERE
        a.id_usuario = :new.id_usuario;

    IF ( d IS NULL OR d <> 'PF' ) THEN
        raise_application_error(-20223, 'FK C4H_CAD_PF_USUARIO_FK in Table T_C4H_CADASTRO_PF violates Arc constraint on Table T_C4H_USUARIO - discriminator column ID_USUARIO doesn''t have value ''PF'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_c4h_arco_t_c4h_cadastro_pj BEFORE
    INSERT OR UPDATE OF id_usuario ON t_c4h_cadastro_pj
    FOR EACH ROW
DECLARE
    d CHAR(36);
BEGIN
    SELECT
        a.id_usuario
    INTO d
    FROM
        t_c4h_usuario a
    WHERE
        a.id_usuario = :new.id_usuario;

    IF ( d IS NULL OR d <> 'PJ' ) THEN
        raise_application_error(-20223, 'FK C4H_CAD_PJ_USUARIO_FK in Table T_C4H_CADASTRO_PJ violates Arc constraint on Table T_C4H_USUARIO - discriminator column ID_USUARIO doesn''t have value ''PJ'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            20
-- CREATE INDEX                             0
-- ALTER TABLE                             39
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           2
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
