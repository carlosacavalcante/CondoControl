package io.github.carlosacavalcante.CondoControl.modules.condominio.presentation.controller;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase.ConsultarCondominioUseCase;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase.CriarCondominioUseCase;
import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.model.Condominio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/condominios")
@RequiredArgsConstructor
public class CondominioController {

    private final CriarCondominioUseCase criarUseCase;

    private final ConsultarCondominioUseCase consultarCondominio;

    @PostMapping
    public ResponseEntity<Condominio> criarCondominio (@RequestBody CondominioRequestDTO requestDTO){
        Condominio condominio = criarUseCase.excute(requestDTO);
        return ResponseEntity.ok(condominio);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Condominio> consultarCondominioPorId(@PathVariable Long id){
        Condominio condominio = consultarCondominio.excute(id);
        return ResponseEntity.ok(condominio);
    }

}
