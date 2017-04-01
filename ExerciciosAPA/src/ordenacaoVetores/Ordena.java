package ordenacaoVetores;

import java.security.SecureRandom;

import custom.Objects.Item;

public abstract class Ordena {

	protected Item[] vetorItems;
	int tamanhoVetor = 0;
	
	public int comparacoes = 0;
	public int trocas = 0;

	//public int comparacoes = 0;
	//public int trocas = 0;

	/*<--------------------------------------------------------------------------------------->*/


	public void printVetor(){

		for (int i = 0; i < this.tamanhoVetor - 1; i ++){

			System.out.print(vetorItems[i].getChave() + ", ");
		}

		System.out.println(vetorItems[tamanhoVetor -1].getChave());
	}


	/*<--------------------------------------------------------------------------------------->*/


	protected Item[] preencherAleatorio(int tamanho){

		Item[] vetor = new Item[tamanho];		
		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < this.tamanhoVetor; i++){

			Item numero = new Item(aleatorio.nextInt(1000));
			vetor[i] = numero;
		}

		return vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/

}
