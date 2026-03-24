CREATE TABLE morador (
    id BIGSERIAL PRIMARY KEY,

    condominio_id BIGINT NOT NULL,

    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(150),
    telefone VARCHAR(20),

    numero_apartamento VARCHAR(20),
    bloco VARCHAR(20),

    tipo_morador VARCHAR(20) NOT NULL, -- PROPRIETARIO, INQUILINO

    sindico BOOLEAN DEFAULT FALSE,

    ativo BOOLEAN DEFAULT TRUE,

    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_morador_condominio
        FOREIGN KEY (condominio_id)
        REFERENCES condominio(id)
        ON DELETE CASCADE,

    CONSTRAINT uk_morador_cpf UNIQUE (cpf)
);