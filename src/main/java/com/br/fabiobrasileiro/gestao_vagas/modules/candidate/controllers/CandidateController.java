package com.br.fabiobrasileiro.gestao_vagas.modules.candidate.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fabiobrasileiro.gestao_vagas.modules.candidate.CandidateEntity;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CandidateEntity> create(@Valid @RequestBody CandidateEntity candidateEntity) {
    // Aqui você pode persistir o candidato ou processar como necessário.
    // Retornamos o objeto recebido com status 201 (Created) para o cliente.
    return ResponseEntity.status(HttpStatus.CREATED).body(candidateEntity);
  }
}
