package ordenacaoVetores;

import java.security.SecureRandom;

public class OrdenacaoBolha {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método bolha. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	private int[] vetor;
	int tamanhoVetor = 0;

	public OrdenacaoBolha(int tamanho){

		this.tamanhoVetor = tamanho;
		int[] vetor = new int[tamanho];

		this.vetor = preencherAleatorio(vetor);
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	

	private int[] preencherAleatorio(int[] vetor){

		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < this.tamanhoVetor; i++){

			Item numero = new Item(aleatorio.nextInt(1000));
			vetor[i] = numero.getChave();
		}

		return vetor;
	}
	
	public void ordenarVetor(){

		
	}

	
	/*<--------------------------------------------------------------------------------------->*/
	

	/*public void printVetor(){

		for (int i = 0; i < this.tamanhoVetor; i ++){

			System.out.print(this.vetor[i] + ", ");
		}

	}
	 */
	
	
}