package com.lucasmartins.mineiracaodados.controller;

import com.lucasmartins.mineiracaodados.controller.dto.TurmaDto;
import com.lucasmartins.mineiracaodados.model.TurmaEntity;
import com.lucasmartins.mineiracaodados.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @PostMapping("/turma")
    public TurmaDto salvarTurma(@RequestBody TurmaDto turma) {
        final TurmaEntity turmaEntity = new TurmaEntity();
        turmaEntity.setCurso(turma.getCurso());
        turmaEntity.setNome(turma.getNome());

        TurmaEntity turmaPersistida = turmaRepository.save(turmaEntity);

        return turma;
    }

    @GetMapping("/turma/{nome}")
    public TurmaEntity buscarTurma(@PathVariable String nome) {
        TurmaEntity entity = turmaRepository.findByNome(nome);

        return entity;
    }

}
