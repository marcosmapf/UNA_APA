package mainProgram;

import lista07.Cadastro.Cadastro;

public class Lista07 {

  public static void main (String[] args) {
    
	  Cadastro c = new Cadastro ();
	  c.cadastrar ();
	  c.listarCadastro ();
	  c.imprimirColisoes();
	  c.buscarPessoa("Evelina Edgell");  
  }  
}