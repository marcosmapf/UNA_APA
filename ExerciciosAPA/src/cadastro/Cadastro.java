package cadastro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

import custom.Objects.Pessoa;

public class Cadastro {

  Hashtable<String, LinkedList> tabelaHash = new <String, LinkedList> Hashtable ();

  public void cadastrar () {
    int i;
    LinkedList<Pessoa> pessoas = this.listar ();

    System.out.println ("----------------------------");
    System.out.println ("--- Cadastro de Pessoas: ---");
    System.out.println ("----------------------------");
    for (Pessoa p : pessoas) {
      System.out.println ("Cadatrando: Pessoa: " + p.getNome () + " Profissão: " + p.getProfissao ());
      if (this.tabelaHash.containsKey (p.getProfissao ())) {
        LinkedList l = this.tabelaHash.get (p.getProfissao ());
        l.add (p);
      } else {
        LinkedList<Pessoa> l = new <Pessoa> LinkedList ();
        l.add (p);
        this.tabelaHash.put (p.getProfissao (), l);
      }
    }
    System.out.println ("");
  }

  public void listarCadastro () {
    int i, cont = 0;
    Enumeration profissoes = this.tabelaHash.keys ();

    System.out.println ("-----------------------------");
    System.out.println ("--- Conteúdo do Cadastro: ---");
    System.out.println ("-----------------------------");
    while (profissoes.hasMoreElements ()) {
      cont++;
      String profissao = (String) profissoes.nextElement ();
      LinkedList<Pessoa> l = this.tabelaHash.get (profissao);

      System.out.print (cont + ") " + profissao + ": ");
      for (i = 0; i < l.size (); i++) {
        Pessoa p = l.get (i);
        System.out.print (p.getNome ());
      }
      System.out.println ();
    }
    System.out.println ();

  }

  public LinkedList listar () {
    int i;
    LinkedList<String> listaNomes, listaProfissoes;
    LinkedList<Pessoa> pessoas = new <Pessoa> LinkedList ();

    listaNomes = this.lerArquivo ("listaNomes.txt");
    listaProfissoes = this.lerArquivo ("listaProfissoes.txt");

    System.out.println ("-------------------------------------------");
    System.out.println ("--- Lista de Pessoas e suas Profissões: ---");
    System.out.println ("-------------------------------------------");
    for (i = 0; i < listaNomes.size (); i++) {
      Pessoa p = new Pessoa (listaNomes.get (i), listaProfissoes.get (i));
      System.out.println ("Pessoa: " + p.getNome () + " Profissão: " + p.getProfissao ());
      pessoas.add (p);
    }
    System.out.println ("");

    return pessoas;
  }

  public LinkedList lerArquivo (String nomeArquivo) {
    LinkedList<String> listaEncadeada = new <String> LinkedList ();
    File arq = null;
    FileInputStream entrada = null;
    InputStreamReader leitor = null;
    BufferedReader buffer_entrada = null;

    try {
      arq = new File (nomeArquivo);
      entrada = new FileInputStream (arq);
      leitor = new InputStreamReader (entrada);
      buffer_entrada = new BufferedReader (leitor);

      System.out.println ("-------------------------------------------------");
      System.out.println ("--- Conteúdo do Arquivo : " + nomeArquivo + " ---");
      System.out.println ("-------------------------------------------------");
      String linha;
      while ((linha = buffer_entrada.readLine ()) != null) {
        linha = linha.trim ();
        System.out.println (linha);
        listaEncadeada.add (linha);
      }
      System.out.println ("");
    } catch (Exception e) {
      System.out.println ("Erro ao ler o arquivo " + nomeArquivo + "!");
      e.printStackTrace ();
    } finally {
      try {
        if (buffer_entrada != null) {
          buffer_entrada.close ();
        }
        if (leitor != null) {
          leitor.close ();
        }
        if (entrada != null) {
          entrada.close ();
        }
      } catch (Exception e) {
        e.printStackTrace ();
      }
    }
    return listaEncadeada;
  }
}
