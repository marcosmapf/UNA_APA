package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoSelecao extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método bolha. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoSelecao(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
	}


	public OrdenacaoSelecao(int[] vetor){

		vetorOrdena = new VetorItems(vetor);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void ordenar(){

		Item menor = null;
		int indice = 0;

		comparacoes = 0; 
		trocas = 0;

		for (int i = 0; i < vetorOrdena.getTamanhoVetor() - 1; i++){

			menor = vetorOrdena.getItem(i);
			indice = i;	

			for (int j = i + 1; j < vetorOrdena.getTamanhoVetor(); j++){

				comparacoes++;				

				//menor = vetorOrdena.getChaveOfItem(j) < menor.getChave()? vetorOrdena.getItem(j) : menor;				
				if (vetorOrdena.getChaveOfItem(j) < menor.getChave()){

					menor = vetorOrdena.getItem(j);			
					indice = j;
				}
			}

			trocas++;
			vetorOrdena.setItem(indice, vetorOrdena.getItem(i));
			vetorOrdena.setItem(i, menor);	
		}		
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void ordenar(Item[] vetor){
		
		int tamanho = vetor.length;
		Item menor = null;
		int indice = 0;

		comparacoes = 0; 
		trocas = 0;

		for (int i = 0; i < tamanho - 1; i++){

			menor = vetor[i];
			indice = i;	

			for (int j = i + 1; j < tamanho; j++){

				comparacoes++;				

				//menor = vetorOrdena.getChaveOfItem(j) < menor.getChave()? vetorOrdena.getItem(j) : menor;				
				if (vetorOrdena.getChaveOfItem(j) < menor.getChave()){

					menor = vetor[j];			
					indice = j;
				}
			}

			trocas++;
			vetor[indice] = vetor[i];
			vetor[i] = menor;	
		}		
	}
}