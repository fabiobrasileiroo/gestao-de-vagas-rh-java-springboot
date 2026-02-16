package com.br.fabiobrasileiro.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.fabiobrasileiro.gestao_vagas.exceptions.UserFoundException;
import com.br.fabiobrasileiro.gestao_vagas.modules.candidate.CandidateEntity;
import com.br.fabiobrasileiro.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCases {
  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException();
        });

    var value = this.candidateRepository.save(candidateEntity);
    return value;

  }
}
