package io.github.carlosacavalcante.CondoControl.modules.condominio.domain.model;

public record Condominio(
        Long id,
        String nome,
        String cnpj,
        String endereco,
        String numero,
        String cidade,
        String estado,
        String cep,
        boolean ativo
) {

    public Condominio desativar() {
        return new Condominio(id, nome, cnpj, endereco, numero,cidade, estado,cep,false);
    }
}