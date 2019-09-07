package br.com.pcroberto.assembleiarest.repository;

import br.com.pcroberto.assembleiarest.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "voto", path = "voto")
public interface VotoRepository extends JpaRepository<Voto, Long> {

}
