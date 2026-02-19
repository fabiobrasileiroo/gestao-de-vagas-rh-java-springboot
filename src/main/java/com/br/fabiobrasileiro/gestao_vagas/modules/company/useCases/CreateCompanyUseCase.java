package com.br.fabiobrasileiro.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.fabiobrasileiro.gestao_vagas.exceptions.UserFoundException;
import com.br.fabiobrasileiro.gestao_vagas.modules.company.entities.CompanyEntity;
import com.br.fabiobrasileiro.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEnconder;

  public CompanyEntity execute(CompanyEntity companyEntity) {
    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent(user -> {
          throw new UserFoundException();
        });

    var password = passwordEnconder.encode(companyEntity.getPassword());

    return this.companyRepository.save(companyEntity);
  }
}
