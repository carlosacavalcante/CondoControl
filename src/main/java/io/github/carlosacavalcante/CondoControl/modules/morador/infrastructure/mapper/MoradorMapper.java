package io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.mapper;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity.CondominioEntity;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorRequestDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.domain.enums.TipoMorador;
import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.entity.MoradorEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class MoradorMapper {

    public MoradorEntity toSave(MoradorRequestDto moradorRequestDto) {
        MoradorEntity entity = new MoradorEntity();
        entity.setAtivo(Boolean.TRUE);
        entity.setCpf(moradorRequestDto.cpf());
        entity.setCondominioId(moradorRequestDto.condominioId());
        entity.setNome(moradorRequestDto.nome());
        entity.setEmail(moradorRequestDto.email());
        entity.setTelefone(moradorRequestDto.telefone());
        entity.setNumeroApartamento(moradorRequestDto.numeroApartamento());
        entity.setBloco(moradorRequestDto.bloco());
        entity.setTipoMorador(moradorRequestDto.tipoMorador());
        entity.setSindico(moradorRequestDto.sindico());
        entity.setDataCriacao(LocalDateTime.now());
        return entity;

    }

    public MoradorDto toMorador(MoradorEntity entity){
        return new MoradorDto(
                entity.getId(),
                entity.getCondominioId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getNumeroApartamento(),
                entity.getBloco(),
                entity.getTipoMorador(),
                entity.getSindico(),
                entity.getAtivo(),
                entity.getDataCriacao()
        );
    }

    public List<MoradorDto> toMoradorList(List<MoradorEntity> moradores) {
        return moradores.stream()
                .map(this::toMorador)
                .toList();
    }
}
