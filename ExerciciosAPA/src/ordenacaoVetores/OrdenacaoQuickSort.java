package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoQuickSort extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método QuickSort. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoQuickSort(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
	}


	public OrdenacaoQuickSort(int[] vetor){

		this.vetorOrdena = new VetorItems(vetor);
	}
}