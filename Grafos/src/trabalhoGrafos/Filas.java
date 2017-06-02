package trabalhoGrafos;

/* A classe Filas é utilizada para criação de manipulação de Filas homogêneas (numero [identificador])
 * -> Possui uma inner class elemento que é instanciada para cada novo elemento da fila que é criado,
 * através do método Inserir elemento.
 * 
 * O método InserirElemento(int vertice) cria um novo elemento no final da fila e atribui uma posição para ele
 * o método RemoverElemento() remove o primeiro elemento da fila e atribui a posição 1 para o elemento seguinte 
 */

public class Filas {

	//Declaração de variaveis do tipo elemento (criado na classe abaixo) que indicam o comeco e fim da fila
	private static elemento comeco;
	private static elemento fundo;

	protected static class elemento {

		/*Atributos que compoem a variável elemento. Número fornece a identificação do elemento e proximo é usado para fazer a ligação
		 * entre um elemento e seu elemento subsequente
		 */

		int numero;
		elemento proximo;
	}

	//---------------------------------------------------------------//

	//Opção 1
	protected static void InserirElemento(int vertice){

		/*Metódo para a inserção de um elemento na fila. Requisita o numero de identificação do vertice
		 * e então o adiciona na ordem de sequência da fila
		 */

		elemento novo = new elemento();
		novo.numero = vertice;

		//---------------------------------------------------------------//

		if (getComeco() == null){

			//Se não existerem elementos na fila; quer dizer, a fila está vazia

			setFundo(novo);
			setComeco(novo);

			novo.proximo = null;
		}
		else{

			//Se já existirem elementos na fila, adiciona um novo elemento no final dela.
			getFundo().proximo = novo;
			novo.proximo = null;
			setFundo(novo);

		}
	}

	//---------------------------------------------------------------//

	protected static void RemoverElemento(){

		//Remove o primeiro elemento da lista, e diminui a posição de todos os outros membros em 1 unidade

		if (getComeco().proximo != null){

			setComeco(getComeco().proximo);
		}
		else{
			setComeco(null);
		}
	}

	static void ConsultarFila() {

		//itera por todos os elementos da fila e imprime seu identificador (numero), nome e posição na fila

		System.out.println("\n" + "//-----------------------------------------------------//");

		elemento auxiliar = new elemento ();
		auxiliar = comeco;

		//---------------------------------------------------------------//	


		if (auxiliar == null){

			//Se a fila estiver vazia

			System.out.print("A fila está vazia.");
			System.out.println("\n" + "//-----------------------------------------------------//");
		}
		else{

			System.out.println("A fila possui os elementos: " + "\n");

			while (auxiliar != null){

				System.out.println("Elemento: " + auxiliar.numero + " || Endereço Hash: " + auxiliar.hashCode());
				auxiliar = auxiliar.proximo;
			}

			System.out.println("//-----------------------------------------------------//");
		}
	}

	//---------------------------------------------------------------//


	public static elemento getComeco() {
		return comeco;
	}

	public static void setComeco(elemento comeco) {
		Filas.comeco = comeco;
	}

	private static elemento getFundo() {
		return fundo;
	}

	private static void setFundo(elemento fundo) {
		Filas.fundo = fundo;
	}

}
