package ordenacaoVetores;

import java.security.SecureRandom;

public class OrdenacaoBolha extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método bolha. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */

	public OrdenacaoBolha(int tamanho){

		Ordena nomealeatorio = new Ordena();
		
		this.tamanhoVetor = tamanho;
		int[] vetor = new int[tamanho];

		this.vetor = preencherAleatorio(vetor);
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	

	
	
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