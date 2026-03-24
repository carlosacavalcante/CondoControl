package io.github.carlosacavalcante.CondoControl.modules.morador.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.service.CondominioDomainService;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorRequestDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.domain.service.MoradorDomainService;
import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.mapper.MoradorMapper;
import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.repository.JpaMoradorRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CriarMoradorUseCase {

    private final JpaMoradorRepository repository;

    private final CondominioDomainService condominioDomainService;

    private final MoradorDomainService moradorDomainService;

    private final MoradorMapper mapper;

    @Transactional
    public MoradorDto execute(MoradorRequestDto moradorRequestDto){
        validarValoresUnicos(moradorRequestDto);
        condominioDomainService.validarIdCondominio(moradorRequestDto.condominioId());
        moradorDomainService.existeSindico(moradorRequestDto.condominioId(), moradorRequestDto.sindico());
        return mapper.toMorador(repository.save(mapper.toSave(moradorRequestDto)));
    }

    private void validarValoresUnicos(MoradorRequestDto moradorRequestDto) {
        validarCpfUnico(moradorRequestDto.cpf());
        validarEmailUnico(moradorRequestDto.email());
    }

    private void validarEmailUnico(String email) {
        if(repository.findIdByEmail(email).isPresent()){
            throw new RuntimeException("Email informado já esta cadastrado");
        }
    }

    private void validarCpfUnico(String cpf) {
       if (repository.findIdByCpf(cpf).isPresent()){
           throw new RuntimeException("Cpf informado já esta cadastrado");
       }
    }
}
