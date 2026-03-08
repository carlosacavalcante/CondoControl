package io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.model.Condominio;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.mapper.CondominioMapper;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository.JpaCondominioRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarCondominioUseCase {

    private final JpaCondominioRepository repository;

    private final CondominioMapper mapper;

    public CriarCondominioUseCase(JpaCondominioRepository repository, CondominioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Condominio excute(CondominioRequestDTO requestDTO) {
        return mapper.toCondominio(repository.save(mapper.toSave(requestDTO)));
    }
}
