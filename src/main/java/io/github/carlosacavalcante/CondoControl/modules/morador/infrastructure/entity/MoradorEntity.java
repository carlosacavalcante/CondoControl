package io.github.carlosacavalcante.CondoControl.modules.morador.infrastructure.entity;

import io.github.carlosacavalcante.CondoControl.modules.morador.domain.enums.TipoMorador;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "morador",
        indexes = {
                @Index(name = "idx_morador_condominio_id", columnList = "condominio_id"),
                @Index(name = "idx_morador_nome", columnList = "nome")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_morador_cpf", columnNames = "cpf")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "condominio_id", nullable = false)
    private Long condominioId;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(length = 150)
    private String email;

    @Column(length = 20)
    private String telefone;

    @Column(name = "numero_apartamento", length = 20)
    private String numeroApartamento;

    @Column(length = 20)
    private String bloco;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_morador", nullable = false, length = 20)
    private TipoMorador tipoMorador;

    @Column(nullable = false)
    private Boolean sindico = false;

    @Column(nullable = false)
    private Boolean ativo = true;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();

        if (this.sindico == null) {
            this.sindico = false;
        }

        if (this.ativo == null) {
            this.ativo = true;
        }
    }
}