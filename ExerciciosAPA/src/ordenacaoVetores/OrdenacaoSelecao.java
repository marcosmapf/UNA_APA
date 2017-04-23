package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoSelecao extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método Selecao. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoSelecao(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
	}


	public OrdenacaoSelecao(int[] vetor){

		this.vetorOrdena = new VetorItems(vetor);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void ordenar(){

		Item menor = null;
		int indice = 0;

		this.comparacoes = 0; 
		this.trocas = 0;

		for (int i = 0; i < this.vetorOrdena.getTamanhoVetor() - 1; i++){

			menor = this.vetorOrdena.getItem(i);
			indice = i;	

			for (int j = i + 1; j < this.vetorOrdena.getTamanhoVetor(); j++){

				this.comparacoes++;				

				//menor = vetorOrdena.getChaveOfItem(j) < menor.getChave()? vetorOrdena.getItem(j) : menor;				
				if (this.vetorOrdena.getChaveOfItem(j) < menor.getChave()){

					menor = this.vetorOrdena.getItem(j);			
					indice = j;
				}
			}

			if (this.vetorOrdena.getChaveOfItem(i) != menor.getChave()){

				this.trocas++;
				this.vetorOrdena.setItem(indice, this.vetorOrdena.getItem(i));
				this.vetorOrdena.setItem(i, menor);
			}
		}		
	}


	public static Item[] ordenar(Item[] vetor){

		int indice = 0;
		Item menor = null;

		for (int i = 0; i < vetor.length - 1; i++){

			menor = vetor[i];
			indice = i;	

			for (int j = i + 1; j < vetor.length; j++){			

				if (vetor[j].getChave() < menor.getChave()){

					menor = vetor[j];			
					indice = j;
				}
			}

			vetor[indice] = vetor[i];
			vetor[i] = menor;	
		}		

		return  vetor;
	}


	public static void ordenar(int[] vetor){

		int menor = 0;
		int indice = 0;

		for (int i = 0; i < vetor.length - 1; i++){

			menor = vetor[i];
			indice = i;	

			for (int j = i + 1; j < vetor.length; j++){		

				if (vetor[j] < menor){

					menor = vetor[j];			
					indice = j;
				}
			}

			vetor[indice] = vetor[i];
			vetor[i] = menor;	
		}		
	}
}