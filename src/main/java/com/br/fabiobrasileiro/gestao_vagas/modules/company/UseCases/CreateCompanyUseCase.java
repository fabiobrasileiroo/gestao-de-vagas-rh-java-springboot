package com.br.fabiobrasileiro.gestao_vagas.modules.company.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fabiobrasileiro.gestao_vagas.exceptions.UserFoundException;
import com.br.fabiobrasileiro.gestao_vagas.modules.company.entities.CompanyEntity;
import com.br.fabiobrasileiro.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
  @Autowired
  private CompanyRepository companyRepository;

  private void execute(CompanyEntity companyEntity) {
    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent(user -> {
          throw new UserFoundException();
        });

    this.companyRepository.save(companyEntity);

  }
}
