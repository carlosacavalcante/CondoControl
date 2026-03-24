package io.github.carlosacavalcante.CondoControl.modules.morador.domain.service;

import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.repository.JpaMoradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoradorDomainService {

    private final JpaMoradorRepository repository;

    public void existeSindico(Long id){
       var condominio =  repository.consultarSeCondominioExisteSindico(id);
       if(condominio.isPresent()){
           throw new RuntimeException("Só pode haver um sindico por condominio");
       }
    }
}
