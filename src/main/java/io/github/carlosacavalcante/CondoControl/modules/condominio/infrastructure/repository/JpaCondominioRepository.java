package io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.repository;

import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity.CondominioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCondominioRepository
        extends JpaRepository<CondominioEntity, Long> {
}