package io.github.carlosacavalcante.CondoControl.modules.morador.presentation.controller;

import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorRequestDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.presentation.factory.UseCaseMorador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morador")
@RequiredArgsConstructor
public class MoradorController {

    private final UseCaseMorador useCaseMorador;

    @PostMapping
    public ResponseEntity<MoradorDto>criarMorador(@RequestBody MoradorRequestDto moradorRequestDto){
        return ResponseEntity.ok(useCaseMorador.criarMorador(moradorRequestDto));

    }


}
