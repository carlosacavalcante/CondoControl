package io.github.carlosacavalcante.CondoControl.modules.morador.presentation.factory;

import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorRequestDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.usecase.CriarMoradorUseCase;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.usecase.ListarMoradoresUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UseCaseMorador {

    private final CriarMoradorUseCase criarMoradorUseCase;

    private final ListarMoradoresUseCase listarMoradoresUseCase;

    public MoradorDto criarMorador(MoradorRequestDto moradorRequestDto) {
        return criarMoradorUseCase.execute(moradorRequestDto);
    }

    public List<MoradorDto> listarMoradores(Long id) {
        return listarMoradoresUseCase.execute(id);
    }
}
