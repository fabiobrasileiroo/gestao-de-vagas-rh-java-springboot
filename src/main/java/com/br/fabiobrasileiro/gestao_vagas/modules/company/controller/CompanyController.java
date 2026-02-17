package com.br.fabiobrasileiro.gestao_vagas.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fabiobrasileiro.gestao_vagas.modules.company.entities.CompanyEntity;
import com.br.fabiobrasileiro.gestao_vagas.modules.company.useCases.CreateCompanyUseCase;
import com.br.fabiobrasileiro.gestao_vagas.modules.company.useCases.FindAllCompanyUseCase;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CreateCompanyUseCase createCompanyUseCase;

  @Autowired
  private FindAllCompanyUseCase findAllCompanyUseCase;

  @GetMapping("/")
  public ResponseEntity<Object> findAll() {
    var result = this.findAllCompanyUseCase.execute();
    return ResponseEntity.ok(result);
  }

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity CompanyEntity) {
    try {
      var result = this.createCompanyUseCase.execute(CompanyEntity);
      return ResponseEntity.status(HttpStatus.CREATED).body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest()
          .body(e.getMessage());
    }
  }

}
