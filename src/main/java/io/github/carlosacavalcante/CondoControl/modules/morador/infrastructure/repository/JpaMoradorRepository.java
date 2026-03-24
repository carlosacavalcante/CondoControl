package io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.repository;

import io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity.CondominioEntity;
import io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.entity.MoradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaMoradorRepository
        extends JpaRepository<MoradorEntity, Long> {

    @Query(value = """
            select * from morador where condominio_id =:id and sindico = true
            """, nativeQuery = true)
    Optional<MoradorEntity> consultarSeCondominioExisteSindico(Long id);
}
