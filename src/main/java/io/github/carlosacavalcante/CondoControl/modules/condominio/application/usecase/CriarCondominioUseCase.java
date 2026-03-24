package io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.service.CondominioDomainService;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.mapper.CondominioMapper;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository.JpaCondominioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarCondominioUseCase {

    private final JpaCondominioRepository repository;

    private final CondominioMapper mapper;

    private final CondominioDomainService condominioDomainService;


    public CondominioDto execute(CondominioRequestDTO requestDTO) {
        condominioDomainService.existeCnpjInformado(requestDTO.cnpj());
        return mapper.toCondominio(repository.save(mapper.toSave(requestDTO)));
    }
}
