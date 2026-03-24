package io.github.carlosacavalcante.CondoControl.modules.morador.presentation.factory;

import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorRequestDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.usecase.CriarMoradorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UseCaseMorador {

    private final CriarMoradorUseCase criarMoradorUseCase;

    public MoradorDto criarMorador(MoradorRequestDto moradorRequestDto) {
        return criarMoradorUseCase.execute(moradorRequestDto);
    }
}
