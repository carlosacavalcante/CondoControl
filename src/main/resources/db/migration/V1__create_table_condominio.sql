CREATE TABLE condominio (
    id BIGSERIAL PRIMARY KEY,

    nome VARCHAR(150) NOT NULL,
    cnpj VARCHAR(18),

    endereco VARCHAR(255),
    numero VARCHAR(20),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    cep VARCHAR(10),

    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ativo BOOLEAN DEFAULT TRUE
);