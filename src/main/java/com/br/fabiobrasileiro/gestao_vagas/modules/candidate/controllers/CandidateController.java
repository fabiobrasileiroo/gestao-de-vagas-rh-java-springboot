package com.br.fabiobrasileiro.gestao_vagas.modules.candidate.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fabiobrasileiro.gestao_vagas.modules.candidate.CandidateEntity;
import com.br.fabiobrasileiro.gestao_vagas.modules.candidate.CandidateRepository;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  private CandidateRepository candidateRepository;

  @PostMapping(value = "/")
  public ResponseEntity<CandidateEntity> create(@Valid @RequestBody CandidateEntity candidateEntity) {
    var value = this.candidateRepository.save(candidateEntity);
    return ResponseEntity.status(HttpStatus.CREATED).body(value);
  }
}
