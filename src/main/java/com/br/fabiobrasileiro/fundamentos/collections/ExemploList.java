package com.br.fabiobrasileiro.fundamentos.collections;

import java.util.ArrayList;
import java.util.List;

public class ExemploList {
  public static void main(String[] args) {
    List<Pessoa> pessoas = new ArrayList<>();
    pessoas.add(new Pessoa(1L, "João"));
    pessoas.add(new Pessoa(2L, "Fábio"));
    Pessoa a = pessoas.get(0);
    pessoas.remove(a);

    for (Pessoa pessoa : pessoas) {
      System.out.println(pessoa.getNome());
    }

    pessoas.add(a);
    System.out.println("----------------------");

    for (Pessoa pessoa : pessoas) {
      System.out.println(pessoa.getNome());
    }
  }
}
