package io.github.carlosacavalcante.CondoControl.modules.condominio.presentation.controller;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase.CriarCondominioUseCase;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.model.Condominio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/condominios")
@RequiredArgsConstructor
public class CondominioController {

    private final CriarCondominioUseCase criarUseCase;

    @PostMapping
    public ResponseEntity<Condominio> criarCondiminio (@RequestBody CondominioRequestDTO requestDTO){
        Condominio condominio = criarUseCase.excute(requestDTO);
        return ResponseEntity.ok(condominio);
    }

}
