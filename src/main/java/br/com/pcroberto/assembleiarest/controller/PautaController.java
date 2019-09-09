package br.com.pcroberto.assembleiarest.controller;

import br.com.pcroberto.assembleiarest.model.Pauta;
import br.com.pcroberto.assembleiarest.repository.PautaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0/pauta")
public class PautaController {

    private final PautaRepository repository;

    public PautaController(PautaRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public Pauta add(@RequestBody Pauta pauta) {
        return repository.save(pauta);
    }

    @GetMapping()
    public List<Pauta> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
