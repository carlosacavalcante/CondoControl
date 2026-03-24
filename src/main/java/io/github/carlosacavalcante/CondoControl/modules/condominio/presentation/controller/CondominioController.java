package io.github.carlosacavalcante.CondoControl.modules.condominio.presentation.controller;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.presentation.factory.UseCaseCondominio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/condominios")
@RequiredArgsConstructor
public class CondominioController {

    private final UseCaseCondominio factory;

    @PostMapping
    public ResponseEntity<CondominioDto> criarCondominio (@RequestBody CondominioRequestDTO requestDTO){
        return ResponseEntity.ok(factory.criarCondominio(requestDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CondominioDto> consultarCondominioPorId(@PathVariable Long id){
        return ResponseEntity.ok(factory.consultarCondominio(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CondominioDto> editarCondominio(@PathVariable Long id,
                                                       @RequestBody CondominioRequestDTO requestDTO){
        return ResponseEntity.ok(factory.editarCondominio(id,requestDTO));
    }

}
