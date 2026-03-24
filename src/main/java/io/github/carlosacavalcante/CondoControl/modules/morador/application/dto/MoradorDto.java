package io.github.carlosacavalcante.CondoControl.modules.morador.application.dto;

import io.github.carlosacavalcante.CondoControl.modules.morador.domain.enums.TipoMorador;

import java.time.LocalDateTime;

public record MoradorDto(
         Long id,
         Long condominioId,
         String nome,
         String cpf,
         String email,
         String telefone,
         String numeroApartamento,
         String bloco,
         TipoMorador tipoMorador,
         Boolean sindico,
         Boolean ativo ,
         LocalDateTime dataCriacao
) {
}
