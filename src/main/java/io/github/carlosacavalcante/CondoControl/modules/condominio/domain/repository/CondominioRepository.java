package io.github.carlosacavalcante.CondoControl.modules.condominio.domain.repository;

import io.github.carlosacavalcante.CondoControl.modules.condominio.domain.model.Condominio;

import java.util.Optional;

public interface CondominioRepository {

    Condominio salvar(Condominio condominio);

    Optional<Condominio> buscarPorId(Long id);

}