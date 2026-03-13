package io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.mapper;


import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.model.Condominio;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity.CondominioEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CondominioMapper {

    public CondominioEntity toEntity(Condominio condominio) {

        CondominioEntity entity = new CondominioEntity();

        entity.setId(condominio.id());
        entity.setNome(condominio.nome());
        entity.setCnpj(condominio.cnpj());
        entity.setAtivo(condominio.ativo());

        return entity;
    }

    public CondominioDto toCondominio(CondominioEntity entity){
        return new CondominioDto(
                entity.getId(),
                entity.getNome(),
                entity.getCnpj(),
                entity.getEndereco(),
                entity.getNumero(),
                entity.getCidade(),
                entity.getEstado(),
                entity.getCep(),
                entity.getAtivo()
        );
    }

    public CondominioEntity toSave(CondominioRequestDTO requestDTO) {
        CondominioEntity entity = new CondominioEntity();

        entity.setNome(requestDTO.nome());
        entity.setCnpj(requestDTO.cnpj());
        entity.setEndereco(requestDTO.endereco());
        entity.setNumero(requestDTO.numero());
        entity.setCidade(requestDTO.cidade());
        entity.setEstado(requestDTO.estado());
        entity.setCep(requestDTO.cep());
        entity.setDataCriacao(LocalDateTime.now());
        entity.setAtivo(true);

        return entity;

    }

    public CondominioEntity toEditar(CondominioRequestDTO requestDTO, CondominioEntity entity) {
        entity.setNome(requestDTO.nome());
        entity.setCnpj(requestDTO.cnpj());
        entity.setEndereco(requestDTO.endereco());
        entity.setNumero(requestDTO.numero());
        entity.setCidade(requestDTO.cidade());
        entity.setEstado(requestDTO.estado());
        entity.setCep(requestDTO.cep());
        return entity;
    }
}