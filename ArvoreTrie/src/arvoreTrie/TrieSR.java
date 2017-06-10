package arvoreTrie;

public class TrieSR<Value> { 

	private static int R = 256;   //tamanho do alfabeto         
	private Node raiz;   	   //no "raiz" da arvore 

	private static class Node {

		private Object valor; 
		private Node[] proximo;

		public Node (int R){
			this.proximo = new Node[R];
		}
	}

	//---------------------------------------------------------//

	public void adicionarChave(String chave, Value valor) {

		this.raiz = adicionarChave(this.raiz, chave, valor, 0);
		System.out.println("O aluno " + chave + " foi inserido");
	}

	private Node adicionarChave(Node x, String chave, Value valor, int d) {

		if (x == null) x = new Node(R);
		if (d == chave.length()) {
			x.valor = valor;
			return x;
		}
		char c = chave.charAt(d);
		x.proximo[c] = adicionarChave(x.proximo[c], chave, valor, d+1);
		return x;
	}

	//---------------------------------------------------------//

	public void removerChave(String chave) { 
		raiz = removerChave(raiz, chave, 0); 
	}

	private Node removerChave(Node x, String chave, int d) {

		if (x == null) return null;
		if (d == chave.length())
			x.valor = null;
		else {
			char c = chave.charAt(d);
			x.proximo[c] = removerChave(x.proximo[c], chave, d+1);
		}
		if (x.valor != null) return x;
		for (char c = 0; c < R; c++)
			if (x.proximo[c] != null) return x; 
		return null;
	}

	//---------------------------------------------------------//

	public void buscarChave(String chave) {

		Node x = buscarChave(raiz, chave, 0);
		if (x == null) System.out.println("O aluno(a) ainda não foi cadastrado(a)");
		else if (x.valor != null)
			System.out.println("O RA do aluno(a) " + chave + " e: " + x.valor);
		else 
			System.out.println("O aluno(a) ainda não foi cadastro(a)");
	}

	private Node buscarChave(Node x, String chave, int d) {

		if (x == null) return null;
		if (d == chave.length()) return x;
		char c = chave.charAt(d);
		return buscarChave(x.proximo[c], chave, d+1);
	}
}