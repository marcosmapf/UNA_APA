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

		vetorOrdena = new VetorItems(tamanho);
	}


	public OrdenacaoBolha(int[] vetor){

		vetorOrdena = new VetorItems(vetor);
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

		comparacoes = 0; 
		trocas = 0;

		for (int i = 0; i < vetorOrdena.getTamanhoVetor() - 1; i++){
			for (int j = 0; j < vetorOrdena.getTamanhoVetor() - 1 - i; j++){

				comparacoes++;

				if (vetorOrdena.getChaveOfItem(j) > vetorOrdena.getChaveOfItem(j+1)){

					trocas++;
					auxiliar = vetorOrdena.getItem(j+1);	

					vetorOrdena.setItem(j+1, vetorOrdena.getItem(j));
					vetorOrdena.setItem(j, auxiliar);	
				}
			}
		}
	}
	

	/*<--------------------------------------------------------------------------------------->*/


	public void ordenar(Item[] vetor){

		Item auxiliar;
		int tamanho = vetor.length;

		comparacoes = 0; 
		trocas = 0;

		for (int i = 0; i < tamanho - 1; i++){
			for (int j = 0; j < tamanho - 1 - i; j++){

				comparacoes++;

				if (vetor[j].getChave() > vetor[j+1].getChave()){

					trocas++;
					auxiliar = vetor[j+1];
					
					vetor[j+1] = vetor[j];
					vetor[j] = auxiliar;
					
				}
			}
		}
	}
}