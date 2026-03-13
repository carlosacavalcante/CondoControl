package io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository;

import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity.CondominioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCondominioRepository
        extends JpaRepository<CondominioEntity, Long> {

    boolean existsByCnpj(String cnpj);

    Optional<CondominioEntity> findIdByCnpj(String cnpj);
}