package com.lucasmartins.mineiracaodados.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lucasmartins.mineiracaodados.Turma;
import com.lucasmartins.mineiracaodados.repository.TurmaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/turmas")

public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Turma criarTurma(@RequestBody Turma turma){
        return repository.save(turma);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Turma> ListarTurma() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Turma buscarId(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Turma atualizarTurma(@PathVariable int id, @RequestBody Turma turma) {
        if(repository.existsById(id)){
            turma.setId(id);
            return repository.save(turma);
        }
        return null;
    }

    
    @DeleteMapping("/{id}")
    public void deletaTurma(@PathVariable int id) {
        repository.deleteById(id);
    }
}
