package io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.model.Condominio;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.mapper.CondominioMapper;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository.JpaCondominioRepository;
import io.github.carlosacavalcante.CondoControl.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConsultarCondominioUseCase {

    private final JpaCondominioRepository repository;

    private final CondominioMapper mapper;

    public ConsultarCondominioUseCase(JpaCondominioRepository repository, CondominioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CondominioDto execute(Long id) {
        return mapper.toCondominio(repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Condominio informado não encontrado!")));
    }

}
