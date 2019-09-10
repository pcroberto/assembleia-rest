package br.com.pcroberto.assembleiarest.repository;

import br.com.pcroberto.assembleiarest.model.Votacao;
import br.com.pcroberto.assembleiarest.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "voto", path = "voto")
public interface VotoRepository extends JpaRepository<Voto, Long> {

    @RestResource(path = "votacao", rel = "votacao")
    public List<Voto> findByVotacao(@Param("votacao") Votacao votacao);
}
