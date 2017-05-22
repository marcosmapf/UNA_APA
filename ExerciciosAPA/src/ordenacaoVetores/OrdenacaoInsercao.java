package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoInsercao extends Ordena {

	/*Escreva um pacote em linguagem Java para ordenação de vetores. O pacote deve conter o
	 * algoritmo de ordenação pelo método Insercao. Teste o algoritmo de ordenação implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoInsercao(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
		this.vetorOrdena.preencherAleatorio(200);
	}


	public OrdenacaoInsercao(int[] vetor){

		this.vetorOrdena = new VetorItems(vetor);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void ordenar(){

		Item auxiliar;

		this.comparacoes = 0; 
		this.trocas = 0;

		int i = 0;
		int j = 0;

		for (i = 1; i < this.vetorOrdena.getTamanhoVetor(); i++){

			auxiliar = this.vetorOrdena.getItem(i);

			for (j = i - 1; (j >= 0) && (auxiliar.getChave() < this.vetorOrdena.getChaveOfItem(j)); j--){			

				this.trocas++;
				this.vetorOrdena.setItem(j+1, this.vetorOrdena.getItem(j));	
			}

			this.comparacoes += i - j;
			
			if (vetorOrdena.getItem(j+1) != auxiliar){
			
				this.trocas++;
				this.vetorOrdena.setItem(j+1, auxiliar);
			}
		}
	}


	public static Item[] ordenar(Item[] vetor){

		Item auxiliar;

		int i = 0;
		int j = 0;

		for (i = 1; i < vetor.length; i++){

			auxiliar = vetor[i];

			for (j = i - 1; (j >= 0) && (auxiliar.getChave() < vetor[i].getChave()); j--){			

				vetor[j+1] = vetor[j];	
			}

			vetor[j+1] = auxiliar;
		}

		return vetor;
	}


	public static int[] ordenar(int[] vetor){

		int auxiliar;

		int i = 0;
		int j = 0;

		for (i = 1; i < vetor.length; i++){

			auxiliar = vetor[i];

			for (j = i - 1; (j >= 0) && (auxiliar < vetor[j]); j--){			

				vetor[j+1] = vetor[j];	
			}

			vetor[j+1] = auxiliar;
		}

		return vetor;
	}
}