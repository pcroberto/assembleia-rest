package br.com.pcroberto.assembleiarest.repository;

import br.com.pcroberto.assembleiarest.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
