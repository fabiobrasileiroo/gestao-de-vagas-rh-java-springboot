package com.br.fabiobrasileiro.fundamentos.collections;

public class Pessoa {
  private Long id;
  private String nome;

  public Pessoa(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Pessoa))
      return false;
    Pessoa other = (Pessoa) o;
    return java.util.Objects.equals(this.id, other.id)
        && java.util.Objects.equals(this.nome, other.nome);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, nome);
  }

  @Override
  public String toString() {
    return "Pessoa{id=" + id + ", nome='" + nome + "'}";
  }
}
