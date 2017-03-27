package ordenacaoVetores;

import java.security.SecureRandom;

public class OrdenacaoBolha extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método bolha. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */



	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoBolha(){

	}


	public OrdenacaoBolha(int tamanho){

		tamanhoVetor = tamanho;
		vetorItems = preencherAleatorio(tamanho);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void ordenarBolha(){

		int auxiliar = 0;

		for (int i = 0; i < tamanhoVetor - 1; i++){
			for (int j = 1; j < tamanhoVetor - i; j ++){

				if (vetorItems[j].getChave() < vetorItems[j-1].getChave()){

					auxiliar = vetorItems[j-1].getChave();
					vetorItems[j-1].setChave(vetorItems[j].getChave());
					vetorItems[j].setChave(auxiliar);
				}
			}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void ordenarBolha(Item[] vetor){

		this.vetorItems = vetor;
		this.tamanhoVetor = vetor.length;

		int auxiliar = 0;

		for (int i = 0; i < tamanhoVetor - 1; i++){
			for (int j = 1; j < tamanhoVetor - i; j ++){

				if (vetor[j].getChave() < vetor[j-1].getChave()){

					auxiliar = vetor[j-1].getChave();
					vetor[j-1].setChave(vetor[j].getChave());
					vetor[j].setChave(auxiliar);
				}
			}
		}
	}
}