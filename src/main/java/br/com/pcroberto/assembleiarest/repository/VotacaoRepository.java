package br.com.pcroberto.assembleiarest.repository;

import br.com.pcroberto.assembleiarest.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
}
