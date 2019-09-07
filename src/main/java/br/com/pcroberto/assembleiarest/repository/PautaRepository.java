package br.com.pcroberto.assembleiarest.repository;

import br.com.pcroberto.assembleiarest.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pauta", path = "pauta")
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
