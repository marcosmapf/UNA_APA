package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoBolha extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método bolha. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoBolha(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
	}


	public OrdenacaoBolha(int[] vetor){

		this.vetorOrdena = new VetorItems(vetor);
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

		Item auxiliar;

		this.comparacoes = 0; 
		this.trocas = 0;

		for (int i = 0; i < this.vetorOrdena.getTamanhoVetor() - 1; i++){
			for (int j = 0; j < this.vetorOrdena.getTamanhoVetor() - 1 - i; j++){

				this.comparacoes++;

				if (this.vetorOrdena.getChaveOfItem(j) > this.vetorOrdena.getChaveOfItem(j+1)){

					this.trocas++;
					auxiliar = this.vetorOrdena.getItem(j+1);	

					this.vetorOrdena.setItem(j+1, vetorOrdena.getItem(j));
					this.vetorOrdena.setItem(j, auxiliar);	
				}
			}
		}
	}


	public static Item[] ordenar(Item[] vetor){

		Item auxiliar;

		for (int i = 0; i < vetor.length - 1; i++){
			for (int j = 0; j < vetor.length - 1 - i; j++){

				if (vetor[j].getChave() > vetor[j+1].getChave()){

					auxiliar = vetor[j+1];
					vetor[j+1] = vetor[j];
					vetor[j] = auxiliar;

				}
			}
		}

		return  vetor;
	}

	public static int[] ordenar(int[] vetor){

		int auxiliar = 0;

		for (int i = 0; i < vetor.length - 1; i++){
			for (int j = 0; j < vetor.length - 1 - i; j++){

				if (vetor[j] > vetor[j+1]){

					auxiliar = vetor[j+1];
					vetor[j+1] = vetor[j];
					vetor[j] = auxiliar;
				}
			}
		}

		return vetor;
	}
}