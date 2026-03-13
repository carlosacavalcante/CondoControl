package io.github.carlosacavalcante.CondoControl.modules.condominio.application.usecase;

import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioDto;
import io.github.carlosacavalcante.CondoControl.modules.condominio.application.dto.CondominioRequestDTO;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity.CondominioEntity;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.mapper.CondominioMapper;
import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository.JpaCondominioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditarCondominioUseCase {

    private final JpaCondominioRepository repository;

    private final CondominioMapper mapper;

    public EditarCondominioUseCase(JpaCondominioRepository repository, CondominioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public CondominioDto execute(Long id, CondominioRequestDTO requestDTO){
        return editarCondominio(validarIdCondominio(id), requestDTO);
    }

    private CondominioDto editarCondominio(CondominioEntity entity, CondominioRequestDTO requestDTO) {
        validarCnpj(requestDTO, entity.getId());
        return  mapper.toCondominio(repository.save(mapper.toEditar(requestDTO, entity)));
    }

    private void validarCnpj(CondominioRequestDTO requestDTO, Long id) {
        var idEncontre = consultarIdPorCnpj(requestDTO.cnpj());
        if(idEncontre != null && !idEncontre.equals(id)){
            throw new RuntimeException("Cnpj Informado já esta sendo usado por outro condominio");
        }
    }

    private Long consultarIdPorCnpj(String cnpj) {
        return repository.findIdByCnpj(cnpj)
                .map(CondominioEntity::getId)
                .orElse(null);
    }

    private CondominioEntity validarIdCondominio(Long id) {
        return repository.findById(id).orElseThrow(()->
                new RuntimeException("Condominio não encontrado"));
    }
}
