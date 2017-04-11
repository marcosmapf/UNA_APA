package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoQuickSort extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método bolha. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoQuickSort(int tamanho){

		vetorOrdena = new VetorItems(tamanho);
		tamanhoVetor = tamanho;
		vetorOrdena.preencherAleatorio();
	}


	public OrdenacaoQuickSort(int[] vetor){

		vetorOrdena = new VetorItems(vetor);
		tamanhoVetor = vetor.length;
	}


	/*<--------------------------------------------------------------------------------------->*/

	/*
	public void ordenarBolha(){

		int auxiliar = 0;

		comparacoes = 0; 
		trocas = 0;

		for (int i = 0; i < tamanhoVetor - 1; i++){
			for (int j = 1; j < tamanhoVetor - i; j ++){

				comparacoes += 1;

				if (vetorItems[j].getChave() < vetorItems[j-1].getChave()){

					auxiliar = vetorItems[j-1].getChave();
					vetorItems[j-1].setChave(vetorItems[j].getChave());
					vetorItems[j].setChave(auxiliar);
					trocas++;
				}
			}
		}
	}
	 */

	public void ordenar(){

		int auxiliar = 0;

		comparacoes = 0; 
		trocas = 0;

		for (int i = 0; i < tamanhoVetor - 1; i++){
			for (int j = 0; j < tamanhoVetor - 1 - i; j ++){

				comparacoes++;

				if (vetorOrdena.getChaveOfItem(j) > vetorOrdena.getChaveOfItem(j+1)){

					auxiliar = vetorOrdena.getChaveOfItem(j+1);
					vetorOrdena.setChaveOfItem(j+1, vetorOrdena.getChaveOfItem(j));
					vetorOrdena.setChaveOfItem(j, auxiliar);
					trocas++;
				}
			}
		}
	}

	/*<--------------------------------------------------------------------------------------->*/


	public void ordenar(Item[] vetor){

		int auxiliar = 0;

		comparacoes = 0; 
		trocas = 0;

		for (int i = 0; i < tamanhoVetor - 1; i++){
			for (int j = 1; j < tamanhoVetor - i; j ++){

				comparacoes++;

				if (vetor[j].getChave() < vetor[j-1].getChave()){

					auxiliar = vetor[j-1].getChave();
					vetor[j-1].setChave(vetor[j].getChave());
					vetor[j].setChave(auxiliar);
					trocas++;
				}
			}
		}
	}
}