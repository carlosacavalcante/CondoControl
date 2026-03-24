package io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.service.CondominioDomainService;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.mapper.CondominioMapper;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository.JpaCondominioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultarCondominioUseCase {

    private final JpaCondominioRepository repository;

    private final CondominioMapper mapper;

    private final CondominioDomainService condominioDomainService;


    public CondominioDto execute(Long id) {
        return mapper.toCondominio(condominioDomainService.validarIdCondominio(id));
    }

}
