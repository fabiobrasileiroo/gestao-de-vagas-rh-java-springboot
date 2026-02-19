package com.br.fabiobrasileiro.fundamentos.poo_pilares;

public class ComputadorPedrinho {
  public static void main(String[] args) {
    ServicoMensagemInstantanea smi = null;
    String appEscolhido="msn";

    if(appEscolhido.equals("msn"))
      smi = new MSNMesseger();
    else if(appEscolhido.equals("meta"))
      smi = new MetaMessager();

    smi.enviarMensagem();
    smi.receberMensagem();
  }
}
