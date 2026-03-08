package io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto;

public record CondominioRequestDTO(
        String nome,
        String cnpj,
        String endereco,
        String numero,
        String cidade,
        String estado,
        String cep
) {
}
