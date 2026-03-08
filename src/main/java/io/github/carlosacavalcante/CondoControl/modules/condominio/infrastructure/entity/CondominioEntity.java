package io.github.carlosacavalcante.CondoControl.modules.condominio.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.groups.Default;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "condominio",
        indexes = {
                @Index(name = "idx_condominio_nome", columnList = "nome"),
                @Index(name = "idx_condominio_cnpj", columnList = "cnpj")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CondominioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "cnpj", length = 18, unique = true)
    private String cnpj;

    @Column(name = "endereco", length = 255)
    private String endereco;

    @Column(name = "numero", length = 20)
    private String numero;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "ativo")
    private Boolean ativo;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
        if (this.ativo == null) {
            this.ativo = true;
        }
    }

    public void desativar() {
        this.ativo = false;
    }

    public void atualizarEndereco(String endereco, String numero, String cidade, String estado, String cep) {
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}