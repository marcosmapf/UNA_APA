package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoQuickSort extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método QuickSort. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */

	int ponteiroI;
	int ponteiroJ;

	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoQuickSort(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
	}


	public OrdenacaoQuickSort(int[] vetor){

		this.vetorOrdena = new VetorItems(vetor);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void ordenar(int comeco, int posicaoFinal){

		this.particao (comeco, posicaoFinal);

		if (comeco < this.ponteiroJ){
			this.ordenar (comeco, this.ponteiroJ);
		}
		else if (this.ponteiroI < posicaoFinal){
			this.ordenar (this.ponteiroI, posicaoFinal);
		}

	}


	public static Item[] ordenar(Item[] vetor){

		return vetor;
	}


	public static int[] ordenar(int[] vetor){

		return vetor;
	}

	public void particao (int esquerda, int direita) {

		Item pivo, auxiliar;
		this.ponteiroI = esquerda;
		this.ponteiroJ = direita;		
		pivo = this.vetorOrdena.getItem((this.ponteiroI + this.ponteiroJ)/2);

		do {

			while (this.vetorOrdena.getChaveOfItem(ponteiroI) < pivo.getChave()){

				comparacoes++;
				this.ponteiroI++;
			}

			while (this.vetorOrdena.getChaveOfItem(this.ponteiroJ) > pivo.getChave()){

				comparacoes++;
				this.ponteiroJ--;
			}

			if (this.ponteiroI <= this.ponteiroJ) {

				this.trocas++;

				auxiliar = this.vetorOrdena.getItem(this.ponteiroI);
				this.vetorOrdena.setItem(this.ponteiroI, this.vetorOrdena.getItem(ponteiroJ));
				this.vetorOrdena.setItem(this.ponteiroJ, auxiliar);

				this.ponteiroI++;
				this.ponteiroJ--;
			}

		} while (this.ponteiroI <= this.ponteiroJ);
	}
}