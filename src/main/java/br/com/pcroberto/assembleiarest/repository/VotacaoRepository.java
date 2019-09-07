package br.com.pcroberto.assembleiarest.repository;

import br.com.pcroberto.assembleiarest.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "votacao", path = "votacao")
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
}
