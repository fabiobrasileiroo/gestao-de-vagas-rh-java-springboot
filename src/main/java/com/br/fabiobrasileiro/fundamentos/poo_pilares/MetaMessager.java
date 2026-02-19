package com.br.fabiobrasileiro.fundamentos.poo_pilares;

public class MetaMessager extends ServicoMensagemInstantanea {
  String nameMessager = "Meta";

  @Override
  public void enviarMensagem() {
    System.out.println("Enviando mensagem pelo " + nameMessager);
  }

  @Override
  public void receberMensagem() {
    System.out.println("Recebendo mensagem pelo " + nameMessager);
  }
}
