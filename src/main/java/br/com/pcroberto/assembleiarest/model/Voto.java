package br.com.pcroberto.assembleiarest.model;

import javax.persistence.*;

@Entity
@Table(name = "voto", uniqueConstraints = @UniqueConstraint(columnNames = {"associado", "votacao_id"}))
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(nullable = false)
    private boolean voto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Votacao votacao;

    @Column(nullable = false)
    private Integer associado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }

    public Votacao getVotacao() {
        return votacao;
    }

    public void setVotacao(Votacao votacao) {
        this.votacao = votacao;
    }

    public Integer getAssociado() {
        return associado;
    }

    public void setAssociado(Integer associado) {
        this.associado = associado;
    }
}
