package io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto;

import io.github.carlosacavalcante.CondoControl.shared.validation.ValidCnpj;
import jakarta.validation.constraints.NotBlank;

public record CondominioRequestDTO(
        @NotBlank
        String nome,
        @ValidCnpj
        String cnpj,
        String endereco,
        String numero,
        String cidade,
        String estado,
        String cep
) {
}
