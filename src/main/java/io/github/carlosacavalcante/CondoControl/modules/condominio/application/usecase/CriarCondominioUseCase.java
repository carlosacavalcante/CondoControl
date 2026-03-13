package io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
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

    public CondominioDto execute(CondominioRequestDTO requestDTO) {
        if(repository.existsByCnpj(requestDTO.cnpj())){
            throw new RuntimeException("Já existe um condominio com o cnpj informado!");
        }
        return mapper.toCondominio(repository.save(mapper.toSave(requestDTO)));
    }
}
