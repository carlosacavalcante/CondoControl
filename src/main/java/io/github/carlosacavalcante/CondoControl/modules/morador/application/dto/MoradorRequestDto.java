package io.github.carlosacavalcante.CondoControl.modules.morador.application.dto;

import io.github.carlosacavalcante.CondoControl.modules.morador.domain.enums.TipoMorador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MoradorRequestDto(
        @NotNull
        Long condominioId,
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String numeroApartamento,
        @NotBlank
        String bloco,
        @NotNull
        TipoMorador tipoMorador,
        @NotNull
        Boolean sindico
) {
}
