package io.github.carlosacavalcante.CondoControl.modules.condominio.presentation.factory;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase.ConsultarCondominioUseCase;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase.CriarCondominioUseCase;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase.EditarCondominioUseCase;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.model.Condominio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UseCaseFactory {

    private final CriarCondominioUseCase criarUseCase;

    private final ConsultarCondominioUseCase consultarUseCase;

    private final EditarCondominioUseCase editarUseCase;

    public CondominioDto criarCondominio(CondominioRequestDTO requestDTO){
        return criarUseCase.execute(requestDTO);
    }

    public CondominioDto consultarCondominio(Long id){
        return consultarUseCase.execute(id);
    }

    public CondominioDto editarCondominio(Long id, CondominioRequestDTO requestDTO){
        return editarUseCase.execute(id, requestDTO);
    }
}
