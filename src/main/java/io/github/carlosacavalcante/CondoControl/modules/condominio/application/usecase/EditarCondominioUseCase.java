package io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.service.CondominioDomainService;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity.CondominioEntity;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.mapper.CondominioMapper;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository.JpaCondominioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EditarCondominioUseCase {

    private final JpaCondominioRepository repository;

    private final CondominioMapper mapper;

    private final CondominioDomainService condominioService;


    @Transactional
    public CondominioDto execute(Long id, CondominioRequestDTO requestDTO){
        return editarCondominio(condominioService.validarIdCondominio(id), requestDTO);
    }

    private CondominioDto editarCondominio(CondominioEntity entity, CondominioRequestDTO requestDTO) {
        condominioService.validarCnpj(requestDTO, entity.getId());
        return  mapper.toCondominio(repository.save(mapper.toEditar(requestDTO, entity)));
    }
}
