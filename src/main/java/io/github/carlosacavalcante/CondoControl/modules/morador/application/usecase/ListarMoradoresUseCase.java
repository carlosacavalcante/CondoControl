package io.github.carlosacavalcante.CondoControl.modules.morador.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.service.CondominioDomainService;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.mapper.MoradorMapper;
import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.repository.JpaMoradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarMoradoresUseCase {

    private final JpaMoradorRepository repository;

    private final CondominioDomainService condominioDomainService;

    private final MoradorMapper mapper;


    public List<MoradorDto> execute(Long id){
        condominioDomainService.validarIdCondominio(id);
        return mapper.toMoradorList(repository.findByCondominioId(id));
    }
}
