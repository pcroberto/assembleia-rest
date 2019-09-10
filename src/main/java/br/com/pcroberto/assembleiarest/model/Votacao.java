package br.com.pcroberto.assembleiarest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "votacao", uniqueConstraints = @UniqueConstraint(columnNames = {"pauta_id"}))
public class Votacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @OneToOne(optional = false)
    private Pauta pauta;

    @Column(nullable = false)
    private Integer minutos;

    @Column(nullable = false)
    private Date dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }


    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
