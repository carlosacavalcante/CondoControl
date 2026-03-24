package io.github.carlosacavalcante.CondoControl.modules.condominio.domain.service;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity.CondominioEntity;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository.JpaCondominioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CondominioDomainService {

    private final JpaCondominioRepository repository;

    public CondominioEntity validarIdCondominio(Long id) {
        return repository.findById(id).orElseThrow(()->
                new RuntimeException("Condominio não encontrado"));
    }

    public void validarCnpj(CondominioRequestDTO requestDTO, Long id) {
        var idEncontre = consultarIdPorCnpj(requestDTO.cnpj());
        if(idEncontre != null && !idEncontre.equals(id)){
            throw new RuntimeException("Cnpj Informado já esta sendo usado por outro condominio");
        }
    }

    public void existeCnpjInformado(String cnpj){
        if(repository.existsByCnpj(cnpj)){
            throw new RuntimeException("Já existe um condominio com o cnpj informado!");
        }
    }

    private Long consultarIdPorCnpj(String cnpj) {
        return repository.findIdByCnpj(cnpj)
                .map(CondominioEntity::getId)
                .orElse(null);
    }
}
