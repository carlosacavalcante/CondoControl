package io.github.carlosacavalcante.CondoControl.modules.morador.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.service.CondominioDomainService;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorRequestDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.domain.service.MoradorDomainService;
import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.mapper.MoradorMapper;
import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.repository.JpaMoradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarMoradorUseCase {

    private final  JpaMoradorRepository repository;

    private final CondominioDomainService condominioDomainService;

    private final MoradorDomainService moradorDomainService;

    private final MoradorMapper mapper;

    public MoradorDto execute(MoradorRequestDto moradorRequestDto){
        condominioDomainService.validarIdCondominio(moradorRequestDto.condominioId());
        moradorDomainService.existeSindico(moradorRequestDto.condominioId());
        return mapper.toMorador(repository.save(mapper.toSave(moradorRequestDto)));
    }
}
