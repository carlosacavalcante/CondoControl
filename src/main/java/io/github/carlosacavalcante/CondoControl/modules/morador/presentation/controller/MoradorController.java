package io.github.carlosacavalcante.CondoControl.modules.morador.presentation.controller;

import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.application.dto.MoradorRequestDto;
import io.github.carlosacavalcante.CondoControl.modules.morador.presentation.factory.UseCaseMorador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/morador")
@RequiredArgsConstructor
public class MoradorController {

    private final UseCaseMorador useCaseMorador;

    @PostMapping
    public ResponseEntity<MoradorDto>criarMorador(@RequestBody MoradorRequestDto moradorRequestDto){
        return ResponseEntity.ok(useCaseMorador.criarMorador(moradorRequestDto));
    }

    @GetMapping("/moradores/{id}")
    public ResponseEntity<List<MoradorDto>> listarMoradoresPorIdCondominio(@PathVariable Long id){
        List<MoradorDto> moradores = useCaseMorador.listarMoradores(id);
        return ResponseEntity.ok(moradores);
    }


}
