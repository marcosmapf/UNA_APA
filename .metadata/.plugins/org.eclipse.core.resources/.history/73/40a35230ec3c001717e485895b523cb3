package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoHeapsort extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método bolha. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */

	int tamanhoHeap = 0;

	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoHeapsort(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
	}


	public OrdenacaoHeapsort(int[] vetor){

		this.vetorOrdena = new VetorItems(vetor);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void ordenar (){

		buildMaxHeap();
		
		System.out.print("HEAP: ");
		this.vetorOrdena.printVetor();

		for (int i = tamanhoHeap; i > 0; i--){

			trocaItems(0, i);
			this.tamanhoHeap = this.tamanhoHeap - 1;
			maxHeapify(0);
		}		
	}

	/*<--------------------------------------------------------------------------------------->*/

	private void buildMaxHeap() {
		
		this.tamanhoHeap = this.vetorOrdena.getTamanhoVetor() -1;
		
		for (int i = Math.floorDiv(this.tamanhoHeap, 2); i >= 0; i--){
			
			maxHeapify(i);			
		}
	}

	/*<--------------------------------------------------------------------------------------->*/

	private void maxHeapify (int indice) {

		int maior = 0;
		int esquerda = 2 * indice + 1;
		int direita = 2* indice + 2;

		if ((esquerda <= this.tamanhoHeap) && (vetorOrdena.getChaveOfItem(esquerda) > vetorOrdena.getChaveOfItem(indice))){
			maior = esquerda;
		}
		else maior = indice;
		
		this.comparacoes++;

		if ((direita <= this.tamanhoHeap) && (vetorOrdena.getChaveOfItem(direita) > vetorOrdena.getChaveOfItem(maior))){ 
			maior = direita;
		}
		
		this.comparacoes++;

		if (maior != indice) {
			
			trocaItems(indice, maior);
			maxHeapify(maior);
		}
	}

	private void trocaItems (int primeiro, int segundo){

		Item auxiliar = vetorOrdena.getItem(primeiro);
		vetorOrdena.setItem(primeiro, vetorOrdena.getItem(segundo));
		vetorOrdena.setItem(segundo, auxiliar);
		this.trocas++;
	}
}